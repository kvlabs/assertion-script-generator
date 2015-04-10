Assertion Script Generator
===
Utility class to generate junit assertion script for the given object. 

### Usage.

~~~java 
String assertionScript;
assertionScript = new AssertionScriptGenerator(actual, "actual").generateAssertionScript();
//or
assertionScript = new AssertionScriptGenerator(result).generateAssertionScript();
System.out.println(assertionScript);
~~~
