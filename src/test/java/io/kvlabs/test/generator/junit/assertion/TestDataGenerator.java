package io.kvlabs.test.generator.junit.assertion;

import io.kvlabs.test.generator.junit.assertion.model.First;
import io.kvlabs.test.generator.junit.assertion.model.OruEnum;
import io.kvlabs.test.generator.junit.assertion.model.Second;
import io.kvlabs.test.generator.junit.assertion.model.Thrird;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author prasanthkv
 */
public class TestDataGenerator {

    public First getFirst() {
        // INIT 
        First first = new First();
        first.setOruBoolean(true);
        first.setOruDoble(9999666633.22);
        first.setOruFloat(88886666.22f);
        first.setOruLong(5555533333222l);
        first.setOruInt(444422);
        first.setOruString("Here is a string to check");
        first.setOruEnum(OruEnum.FIRST_ENUM);
        //
        Second second = new Second();
        second.setOruLong(666666666L);
        second.setSecondBoolean(false);
        second.setSecondDoble(555555.55555);
        second.setSecondFloat(4444.333f);
        second.setSecondInt(531223);
        second.setSecondString("Here is a second String");

        first.setSecond(second);
        List<Thrird> listOfThrird = new ArrayList<>();
        Thrird[] arrayOfThrird = new Thrird[5];
        for (int i = 0; i < 3; i++) {
            Thrird thrird = new Thrird();
            thrird.setThrirdBoolean(true);
            thrird.setThrirdDoble(i);
            thrird.setThrirdFloat(i);
            thrird.setThrirdInt(i);
            thrird.setThrirdLong(i);
            thrird.setThrirdString("Thrird String " + i);
            listOfThrird.add(thrird);
            arrayOfThrird[i] = thrird;
        }
        first.setListOfThrird(listOfThrird);
        first.setArrayOfThrird(arrayOfThrird);
        //
        Map<String, Thrird> mapOfThrird = new HashMap<>();
        for (int i = 10; i < 15; i++) {
            Thrird thrird = new Thrird();
            thrird.setThrirdBoolean(true);
            thrird.setThrirdDoble(i);
            thrird.setThrirdFloat(i);
            thrird.setThrirdInt(i);
            thrird.setThrirdLong(i);
            thrird.setThrirdString("Thrird String " + i);
            mapOfThrird.put("KEY_" + i, thrird);
        }
        first.setMapOfThrird(mapOfThrird);
        //
        Map< Object, String> mapOfObjects = new HashMap<>();
        mapOfObjects.put('1', "VALUE_1");
        mapOfObjects.put((byte) 123, "VALUE_2");
        mapOfObjects.put((short) 12345, "VALUE_3");
        mapOfObjects.put(1234567, "VALUE_4");
        mapOfObjects.put(1234567891011L, "VALUE_5");
        mapOfObjects.put(1234.56F, "VALUE_6");
        mapOfObjects.put(new Double(123456.789F), "VALUE_7");
        mapOfObjects.put("KEY_FOR_STRING", "VALUE_7");
        first.setMapOfObjects(mapOfObjects);
        //
        first.setCollectionOfObjects(mapOfObjects.keySet());
        //
        String[] arrayOfString = {"array_1", "array_2", "arrat_3"};
        first.setArrayOfString(arrayOfString);
        return first;
    }

    public Map< Object, String> getMap() {
        Map< Object, String> mapOfObjects = new HashMap<>();
        mapOfObjects.put('1', "VALUE_1");
        mapOfObjects.put((byte) 123, "VALUE_2");
        mapOfObjects.put((short) 12345, "VALUE_3");
        mapOfObjects.put(1234567, "VALUE_4");
        mapOfObjects.put(1234567891011L, "VALUE_5");
        mapOfObjects.put(1234.56F, "VALUE_6");
        mapOfObjects.put(new Double(123456.789F), "VALUE_7");
        mapOfObjects.put("KEY_FOR_STRING", "VALUE_7");
        return mapOfObjects;
    }

    public Set<Object> getSet() {
        Set< Object> setOfObject = new HashSet<>();
        setOfObject.add('1');
        setOfObject.add((byte) 123);
        setOfObject.add((short) 12345);
        setOfObject.add(1234567);
        setOfObject.add(1234567891011L);
        setOfObject.add(1234.56F);
        setOfObject.add(new Double(123456.789F));
        setOfObject.add("KEY_FOR_STRING");
        return setOfObject;

    }
}
