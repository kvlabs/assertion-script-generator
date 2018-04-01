package io.kvlabs.test.generator.junit.assertion;

import java.lang.reflect.Field;
import java.util.*;

/**
 * Class to generate JUnit assertion for any java composite object. this class
 * can support, POJOs, Map n Collections
 *
 * @author prasanthkv
 * @param <T> as result data type
 */
public class AssertionScriptGenerator<T> {

    private final Map<String, Integer> VAR_NAME_MAP = new HashMap<>();
    private StringBuilder builder;
    private final T type;
    private String name;
    private final int level;

    /**
     * Create new instance of AUnit
     *
     * @param object as object of Type T
     */
    public AssertionScriptGenerator(T object) {
        this(object, 0, "result");
    }

    /**
     * Create new instance of AUnit
     *
     * @param object as object of Type T
     * @param level at the super class level
     */
    public AssertionScriptGenerator(T object, int level) {
        this(object, level, "result");
    }

    /**
     * Create new instance of AUnit
     *
     * @param object as object of Type T
     * @param level at the super class level
     * @param var as root variable Name
     */
    public AssertionScriptGenerator(T object, int level, String var) {
        this.type = object;
        this.name = var;
        this.level = level;
    }

    /**
     * Generate Assertions to validated the given object
     *
     * @return Assertion code as String
     */
    public String generateAssertionScript() {
        this.builder = new StringBuilder(10000).append("\n\n");
        long start = System.currentTimeMillis();
        this.processObject(this.type, this.name);
        long end = System.currentTimeMillis();
        //
        write("\n\n");
        write(String.format("//Generated in %s ms", end - start));
        write("\n\n");
        return this.builder.toString();
    }

    /**
     * Writes the given text to common buffer.
     *
     * @param text as text to write
     */
    private void write(String text) {
        this.builder.append("        ").append(text).append("\n");
    }

    /**
     * Process given object to generate assertion script
     *
     * @param object as Object
     * @param variableName as current variable name which host the object.
     */
    private void processObject(Object object, String variableName) {
        //Null item
        if (object == null) {
            String getterName = formGetter(null, variableName, false);
            write(String.format("Assert.assertNull(%s);", getterName));
            return;
        }
        //Base Objects
        if (this.isPrimitiveObject(object)) {
            generateAssert(object, variableName, null);
            return;
        }
        //Collections
        if ((object instanceof Map) || (object instanceof Collection) || object.getClass().isArray() || (object instanceof Date)) {
            generateAssert(object, variableName, null);
            return;
        }
        //ignore common java package
        if (object.getClass().getCanonicalName().startsWith("java.")) {
            write("//NON Supported Package" + object.getClass().getPackage().getName());
            return;
        }
        //pojos
        try {
            //get all elements of current class
            Set<Field> fieldList = new HashSet<>();
            //now try for parent class
            if (object.getClass().getSuperclass() != null) {
                Class<?> current = object.getClass();
                while ((current.getSuperclass() != null) && (!"java.lang.Object".equals(current.getCanonicalName()))) {
                    Field[] declaredFields = current.getDeclaredFields();
                    if ((declaredFields != null) && (declaredFields.length > 0)) {
                        fieldList.addAll(Arrays.asList(declaredFields));
                    }
                    current = current.getSuperclass();
                }
            } else {
                fieldList = new HashSet<>(Arrays.asList(object.getClass().getDeclaredFields()));
            }
            //
            for (Field field : fieldList) {
                if (!"serialVersionUID".equals(field.getName())) {
                    field.setAccessible(true);
                    generateAssert(field.get(object), field.getName(), variableName);
                }
            }
        } catch (SecurityException | IllegalArgumentException | IllegalAccessException e) {
            e.printStackTrace();
            write("//ERROR");
        }
    }

    /**
     * Generate Assertion script for the given object
     *
     * @param object as object who's assertion script is to be made
     * @param variableName as variable name
     * @param parentName as parent filed name
     */
    private void generateAssert(Object object, String variableName, String parentName) {
        String getterName = formGetter(parentName, variableName, false);
        //Null item
        if (object == null) {
            //Number -> char , short , int , long, float & double
            write(String.format("Assert.assertNull(%s);", getterName));
        } else if ((object instanceof Number) || (object instanceof Character)) {
            //Number -> char , short , int , long, float & double
            assertEqualsForNumber(object, getterName);
        } else if (object instanceof String) {
            //String added suport for json
            write(String.format("Assert.assertEquals(\"%s\", %s);", ((String) object).replace("\"", "\\\""), getterName));
        } else if (object instanceof Boolean) {
            //boolean
            getterName = formGetter(parentName, variableName, true);
            if ((Boolean) object) {
                write(String.format("Assert.assertTrue(%s);", getterName));
            } else {
                write(String.format("Assert.assertFalse(%s);", getterName));
            }
        } else if (object.getClass().isEnum()) {
            write(String.format("Assert.assertEquals(%s.%s,%s);", object.getClass().getSimpleName(), String.valueOf(object), getterName));
        } else {
            //Collection -> List, Set etc 
            write(String.format("Assert.assertNotNull(%s);", getterName));
            //
            if (object instanceof Date) {
                write("//Date Not supported yet");
            }
            if (object instanceof Collection) {
                write("//Collection");
                processCollections(object, getterName);
            } else if (object instanceof Map) {
                write("//MAP");
                processMap(object, getterName);
            } else if (object.getClass().isArray()) {
                write("//Array");
                processArray(object, getterName);
            } else {
                write("//  " + object.getClass().getSimpleName() + " //");
                this.processObject(object, getterName);
            }
        }

    }

    /**
     * Generates assertion for the given Collection object.
     *
     * @param object as collection object
     * @param getterName as getter Name
     */
    private void processCollections(Object object, String getterName) {
        Collection collection = (Collection) object;
        if (collection.isEmpty()) {
            write(String.format("Assert.assertTrue(%s.isEmpty());", getterName));
        } else if (object instanceof List) {
            write(String.format("Assert.assertEquals(%s, %s.size());", collection.size(), getterName));
            int i = 0;
            for (Object value : collection) {
                if (this.isPrimitiveObject(value)) {
                    //BASE OBJECTS
                    this.processObject(value, String.format("%s.get(%s)", getterName, i++));
                } else {
                    //create new vareable
                    String className = value.getClass().getSimpleName();
                    String varName = findVarName(className);
                    if (!varName.contains("$")) {
                        write("// " + (i + 1));
                        write(String.format("%s %s = %s.get(%s);", className, varName, getterName, i++));
                        //process
                        this.processObject(value, varName);
                    }
                }
            }
        } else if (object instanceof Set) {
            for (Object value : collection) {
                //BASE OBJECTS
                if (this.isPrimitiveObject(value)) {
                    write(String.format("%s.contains(%s)", getterName, this.generateWrapperFormat(value, getterName)));
                } else {
                    write("//Non Primitive Objects are not yet supported in SET assertion.");
                }
            }
        } else {
            write(String.format("//Support for [%s] is yet to be added", object.getClass().getName()));
        }
    }

    /**
     * Generates assertion for the given Array object.
     *
     * @param object as Array object
     * @param getterName as getter Name
     */
    private void processArray(Object object, String getterName) {
        Object[] collection = (Object[]) object;
        write(String.format("Assert.assertEquals(%s, %s.length);", collection.length, getterName));
        if (collection.length != 0) {
            int i = 0;
            for (Object value : collection) {
                write("// " + (i + 1));
                if (value == null) {
                    write(String.format("Assert.assertNull(%s[%s]);", getterName, i++));
                } else if (this.isPrimitiveObject(value)) {
                    //BASE OBJECTS
                    this.processObject(value, String.format("%s[%s]", getterName, i++));
                } else {
                    //create new vareable
                    String className = value.getClass().getSimpleName();
                    String varName = findVarName(className);
                    write(String.format("%s %s = %s[%s];", className, varName, getterName, i++));
                    //process
                    this.processObject(value, varName);
                }
            }
        }
    }

    /**
     * Generates assertion for the given Map object.
     *
     * @param object as Map object
     * @param getterName as getter Name
     */
    private void processMap(Object object, String getterName) {
        Map map = (Map) object;
        if (map.isEmpty()) {
            write(String.format("Assert.assertTrue(%s.isEmpty());", getterName));
        } else {
            write(String.format("Assert.assertEquals(%s, %s.size());", map.size(), getterName));
            Set keySet = map.keySet();
            int i = 0;
            for (Object key : keySet) {
                Object value = map.get(key);
                if (this.isPrimitiveObject(value)) {
                    //BASE OBJECTS
                    this.processObject(value, String.format("%s.get(%s)", getterName, this.generateWrapperFormat(key, getterName)));
                } else {
                    write("// " + (i + 1));
                    //Yet Another Pojo need to create new object here
                    String className = value.getClass().getSimpleName();
                    String varName = findVarName(className);
                    write(String.format("%s %s = %s.get(%s);", className, varName, getterName, this.generateWrapperFormat(key, getterName)));
                    this.processObject(value, varName);
                }
            }
        }
    }

    /**
     * Format Key for a HashMap since hash map does't support basic data type
     *
     * @param object as data type object
     * @return formated string variable
     */
    private String generateWrapperFormat(Object object, String getterName) {
        if (object instanceof Integer) {
            return String.format("new Integer(%s)", (int) object);
        } else if (object instanceof Short) {
            return String.format("new Short((short)%s)", (short) object);
        } else if (object instanceof Byte) {
            return String.format("new Byte((byte)%s)", (byte) object);
        } else if (object instanceof Double) {
            return String.format("new Double(%s)", (double) object);
        } else if (object instanceof Long) {
            return String.format("new Long(%sL)", (long) object);
        } else if (object instanceof Float) {
            return String.format("new Float(%sF)", (float) object);
        } else if (object instanceof String) {
            return String.format("\"%s\"", (String) object);
        } else if (object instanceof Character) {
            return String.format("new Character('%s')", (char) object);
        } else if (object.getClass().isEnum()) {
            return String.format("%s.%s", object.getClass().getSimpleName(), String.valueOf(object), getterName);
        }
        //TODO ENUM
        return String.valueOf(object);
    }

    /**
     * Validate the given object is base object
     *
     * @param object as object to he evaluated.
     * @return true if the object belongs to basic object
     */
    private boolean isPrimitiveObject(Object object) {
        if (object == null) {
            return false;
        }
        return (object.getClass().isPrimitive()
                || (object instanceof Number)
                || (object instanceof String)
                || (object instanceof Character)
                || object.getClass().isEnum());
    }

    /**
     * Generate Assert Equals script for the given number object, this also
     * support Character out of the box
     *
     * @param number as object who's value need to be asserted.
     * @param getter as the getter values.
     */
    private void assertEqualsForNumber(Object number, String getter) {
        if (number instanceof Integer) {
            write(String.format("Assert.assertEquals(%s, %s);", (int) number, getter));
        } else if (number instanceof Long) {
            write(String.format("Assert.assertEquals(%sL, %s);", (long) number, getter));
        } else if (number instanceof Float) {
            write(String.format("Assert.assertEquals(%sf, %s, 0);", (float) number, getter));
        } else if (number instanceof Double) {
            write(String.format("Assert.assertEquals(%s, %s, 0);", (double) number, getter));
        } else if (number instanceof Character) {
            write(String.format("Assert.assertEquals('%s', %s);", (char) number, getter));
        } else if (number instanceof Short) {
            write(String.format("Assert.assertEquals(%s, %s);", (short) number, getter));
        } else if (number instanceof Byte) {
            write(String.format("Assert.assertEquals(%s, %s);", (byte) number, getter));
        }
    }

    /**
     * Create getter format for the given parent and variable. parentName =
     * simplePojo, variableName name will get tranformed into
     * simplePojo.getName() if the booleanObj is true this will return
     * simplePojo.isName()
     *
     * @param parentName as parent name
     * @param variableName variable name
     * @param booleanObj true if the variable is boolean
     * @return getter format for the given combination.
     */
    private String formGetter(String parentName, String variableName, boolean booleanObj) {
        if (parentName == null) {
            return variableName;
        }
        String upper = variableName.toUpperCase().charAt(0) + variableName.substring(1);
        if (booleanObj) {
            return String.format("%s.is%s()", parentName, upper);
        }
        return String.format("%s.get%s()", parentName, upper);
    }

    /**
     * Returns unique variable name for the given class name.
     *
     * @param className as the simple class name
     * @return unique variable name
     */
    private String findVarName(String className) {
        Integer count = VAR_NAME_MAP.get(className);
        String varName = className.toLowerCase().charAt(0) + className.substring(1);
        if (count == null) {
            VAR_NAME_MAP.put(className, 1);
        } else {
            VAR_NAME_MAP.put(className, ++count);
            varName = (varName + count);
        }
        return varName;
    }
}
