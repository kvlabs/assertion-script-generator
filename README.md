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
![step1](https://user-images.githubusercontent.com/3488602/33926522-615daca6-df93-11e7-8621-42b5fd3f5803.png)

##### Step 4
Run the test script and copy the assertion script printed in the console.
![step2](https://user-images.githubusercontent.com/3488602/33926525-618a9982-df93-11e7-98b4-68c5c085d601.png)

##### Step 5
Replace the AssertionScriptGenerator generation with the generated code.
![step3](https://user-images.githubusercontent.com/3488602/33926526-61a00e7a-df93-11e7-8f47-4da66fb91bc1.png)
 
