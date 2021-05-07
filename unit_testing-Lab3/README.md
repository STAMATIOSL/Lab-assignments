## About the second Lab assignment
In the second Lab assignment in ASE creations of *JUnit Tests* are required.

By using the maven project, a parent and a module maven porject are created. They are connected with heritance.

In the module maven project classes like *ArithmeticOperations.java*, *MyMath.java*, *FileIO.java* and their *...Test.java* are created in order to test their functions.

If everything is tested right, then errors won't be shown up.

## Technologies and tools
* *Eclipse* is the main IDE tool for building this project

* *Java* is the main language for this project as it uses Maven

* *JUnit* is the main external and very useful tool. *JUnit* is a class library written in Java for testing.
For this tool the version 4.12 is used. For more information, [click here](https://junit.org/junit4/)

## How to build and run the project
In order to build and run the project the use of IDE *Eclipse* is required. 

## For the **First Part** (Part 1) of the second assignement

### *Step 1:* Build the module project
For the creation of the module maven: 
* In Eclipse open *File* --> *Other* --> *Maven* --> *Maven Module* and click *Next*.
* Then, select *Create a simple project (skip archetype selection)*, complete the *Module Name* with a name of your preference 
and in the *Parent Project* find the parent project you created in the first assignement by using the *Browse...* section. 
* Finally click *Finish*.

### *Step 2:* Download the *ArithmeticOperations.java* and *FileIO.java* files
You need to download these two files. Both are provided [here](https://drive.google.com/drive/folders/14E19OUxEeO0RIxxszwD1h0tbXpnqtr5d).

### *Step 3:* Build the java files
* In the module project, right click in the *src/main/java* --> *New* --> *Package* and complete the name of your preference.
* In the package that you created, right click and then *New* --> *Class*, complete the *name* section with the name 
*ArithmeticOperations* and click *Finish*. Put the *ArithmeticOperations.java* that you downloaded there.

### *Step 4:* Build the test java files
* In the module project, right click in the *src/test/java* --> *New* --> *Package* and complete the name of your preference.
* In the package that you created, right click and then *New* --> *Class*, complete the *name* section with the name 
*ArithmeticOperationsTest* and click *Finish*.

### *Step 5:* For the *ArithmeticOperationsTest.java*
* For the *divide* method, the exception should be tested in the annotation above the method (expected = ArithmeticException.class).
1. So, a call of the method with 0 as a second integer is required.
* For the *multiply* method, the exception cases should be tested with the use of a @Rule that also verifies the messages printed by the exceptions.
1. You can test this method by calling it with proper integers, such as 2*5 = 10. The use of *Assert.assertEquals* method is required.
2. You create an ExpectedException with the Rule once. Then, you use it in order to test two different exceptions: negative numbers and numbers that their product does not fit in an Integer variable).

### *Step 6:* For the *MyMath.java*
In the math package create the MyMath.java class. In this class, create a method that calculates the factorial of a given number.

This method should create an *IllegalArgumentException* for given numbers that are <0 and >12

### *Step 7:* For the *Parameterized.java* and *TestSuite.java*
In the math package of the test classes (*src/test/main/*) create a class with an appropriate name that tests the number 0, 1, 2, 12 as parameters.

Then, in *MyMathTest.java* create seperate tests for the factorial exceptions

Then, create a TestSuite that associates the *MyMathTest* and the *Parameterized* test classes.

### *Step 8:* Travis CI
First, you should take a GitHub student pack by clicking [here](https://education.github.com/pack)

After, visit the site of the Travis CI [here](https://travis-ci.com/) and by using your GitHub account synchronized them.

Finally, add the *.travis.yml* in the roor directory and add your badge of Travis CI build status at the top of your main README file.


## For the **Second Part** (Part 2) of the second assignement

### *Step 1:* JaCoCo and .travis.yml
1. Add the JaCoCo plugin in the parent POM. You can find it [here](https://github.com/AntonisGkortzis/UnitTestingDemoProject/blob/master/project/pom.xml)
(Provided by professor Antonis Gkortzis, lines 37-76)
2. Change the .travis.yml file in order to iclude the JaCoCo report generation

### *Step 2:* Download the *FileIO.java* file
You need to download these two files. Both are provided [here](https://drive.google.com/drive/folders/14E19OUxEeO0RIxxszwD1h0tbXpnqtr5d).

### *Step 3:* Build the java files
* In the module project, right click in the *src/main/java* --> *New* --> *Package* and complete the name of your preference.
* In the package that you created, right click and then *New* --> *Class*, complete the *name* section with the name 
*FileIO* and click *Finish*. Put the *FileIO.java* that you downloaded there.

### *Step 4:* Build the test java files
* In the module project, right click in the *src/test/java* --> *New* --> *Package* and complete the name of your preference.
* In the package that you created, right click and then *New* --> *Class*, complete the *name* section with the name 
*FileIOTest* and click *Finish*.

### *Step 5:* For the *FileIOTest.java*
For the *readfile* method:
1. A normal case should be tested: put a file with integers an read it.
2. Two IllegalArgumentExceptions cases should be tested: use the @Rule for both of them. In the first method, give as an input a file that doesn't exist.
In the second method, give as an input a file that is empty.
*Note: you should put all test files in **src/test/resources**. You can load them by [this way](https://www.baeldung.com/junit-src-test-resources-directory-path)*

### *Step 6:* For the *testReadFileContainsInvalidEntries*
* In *FileIOTest.java* add a method called *testReadFileContainsInvalidEntries* that takes as an input a file that includes integer and non-integer values 
(like double, string) and verify that the test fails. The test file should be placed again in *src/test/resources*.
* Then, change the *readfile* method in order to ignore values from the files that aren't integers. Verify taht the test now succeeds.

### *Step 7:* For the *isPrime* method
In *MyMath* class create a method called *isPrime* that checks if the number that is given is prime or not.

If the given number is <2 an IllegalArgumentException should be thrown. Also, check this method by giving a lot of numbers.

### *Step 8:* For the *ArrayOperations.java*
* First, in the math package in *src/main/java*, right click and then *New* --> *Class*, complete the *name* section with the name *ArrayOperations* and click *Finish*.
* Then, in class you just made, create a method called *findPrimesInFile* that takes 3 arguments:
1. A fileIo from the *FileIO* class
2. A String filepath
3. A myMath from the *MyMath* class
* The *findPrimesInFile* method should iterate an array of numbers and return a new array that contains only its prime numbers.

### *Step 9:* For the *ArrayOperationsTest.java*
* First, in the math package in *src/test/java*, right click and then *New* --> *Class*, complete the *name* section with the name *ArrayOperationsTest* and click *Finish*.
* Check the method *findPrimesInFile* that you created in *Step 8* by mocking with *Mockito* the *FileIO* and *MyMath* instances you pass as parameters.
* Finally, add the *Mockito dependency* in your parent POM. You can find it [here](https://mvnrepository.com/artifact/org.mockito/mockito-core/3.9.0)

### *Step 10:* Check all of these steps
Right click in the module project that you firstly created, *Run As* --> *2 JUnit Test*.

If you see a green tick in all of your checks taht you made, it means that everything gone right.

Else, click in the methods that have errors and fix them... (it won't be something difficult)



#### That's a wrap everybody.. Now, you know the first and basic steps about the JUnit Test.. **Congrats!!!**
