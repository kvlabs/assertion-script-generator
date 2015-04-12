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
##### Step 1
Generate / Create junit test case. 

##### Step 2
Do the relevant mocking or data creation for the input variable. 

##### Step 3
Use `AssertionScriptGenerator` to generate assertion script form the actual returned object. 
![step1](/prasanthkv/AssertionScriptGenerator/blob/master/doc/images/step_1.png?raw=true)

##### Step 4
Run the test script and copy the assertion script printed in the console.
![step2](/prasanthkv/AssertionScriptGenerator/blob/master/doc/images/step_2.png?raw=true)

##### Step 5
Replace the AssertionScriptGenerator generation with the generated code.
![step3](/prasanthkv/AssertionScriptGenerator/blob/master/doc/images/step_3.png?raw=true)
 