Assertion Script Generator
===
Utility class to generate junit assertion script for the given object. 

## Usage.

~~~java 
String assertionScript;
assertionScript = new AssertionScriptGenerator(resultsObject, "result").generateAssertionScript();
//or
assertionScript = new AssertionScriptGenerator(resultsObject).generateAssertionScript();
System.out.println(assertionScript);
~~~
