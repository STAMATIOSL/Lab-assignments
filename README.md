# Test Maven Project

[![Build Status](https://travis-ci.com/STAMATIOSL/Lab-assignments.svg?token=otdXqsDjaQigqWQQSPs1&branch=development)](https://travis-ci.com/STAMATIOSL/Lab-assignments)

# Lab-assignments
It has all the lab assignments for the ASE Lab.

## About the first Lab assignment
In the first Lab assignment in ASE a creation of *histogram* is required.

By using the maven project, a parent and a module maven porject are created. They are connected with heritance.

In the module maven project a *HistogramGenerator.java* is created in order to read a txt file and generate the histogram.

This txt file has all grades that are needed to create this histogram. It is given from the command line as an argument.

After reading the txt file, the java class makes an integer array with the frequency of all grades (0-10).

This integer array is given to the generateChart function whcih generates and draws the right histogram.

This histogram has the title **"Histogram of all Grades"** and two axes with the appropriate title in each one.

## Technologies and tools
* *Eclipse* is the main IDE tool for building this project

* *Java* is the main language for this project as it uses Maven

* *JFreeChart* is the main external and very useful tool. *JFreeChart* is a class library written in Java for generating charts.
For this tool the version 1.5.3 is used. For more information, [click here](https://mvnrepository.com/artifact/org.jfree/jfreechart)

## How to build and run the project
In order to build and run th project the use of IDE *Eclipse* is required. 

### *Step 1:* Build the parent and the module projects
For the creation of the parent maven: 
* In Eclipse open *File* --> *Other* --> *Maven* --> *Maven Project* and click *Next*. 
* Then, select *Create a simple project (skip archetype selection)* and click *Next*.
* Complete the sections: *Group Id*, *Artifact Id*, *Name* and *Description* with names of your preference, 
choose the *pom* in the *Packaging* section and click *Finish*.

For the creation of the module maven: 
* In Eclipse open again *File* --> *Other* --> *Maven* --> *Maven Module* and click *Next*.
* Then, select *Create a simple project (skip archetype selection)*, complete the *Module Name* with a name of your preference 
and in the *Parent Project* find the parent project you created before by using the *Browse...* section. 
* Finally click *Finish*.

### *Step 2:* Add the txt file
You need to download the txt file that has all the grades. This file is [here](https://drive.google.com/file/d/1Yz_WY_uDTqEbGGjo2SpoXjWDU9WDlnTl/view).

Also, put this file in the *target* directory that it will be created later (after Step 5).

### *Step 3:* Build the java file
* In the module project, right click in the *src/main/java* --> *New* --> *Package* and complete the name of your preference.
* In the package that you created, right click and then *New* --> *Class*, complete the *name* section with the name 
*HistorgramGenerator* and click *Finish*.
* Some useful tools are provided by progessor **AntonisGkortzis** in his Github profile.
* In the java file that you just created, you need to import some features for the chart. For more help, please [click here](https://github.com/AntonisGkortzis/BuildAutomationToolsDemoProject/blob/master/histogramgenerator/src/main/java/histogramgenerator/JFreeChartXYLineChartDemo.java).
* Also, you need to add some functions in order to read the txt file that is given from the command line and to create an array with the frequencies of each grade (0-10).
* Another useful function is the *generatorChart*. You can take this function by [clicking here](https://github.com/AntonisGkortzis/BuildAutomationToolsDemoProject/blob/master/histogramgenerator/src/main/java/histogramgenerator/JFreeChartXYLineChartDemo.java). 
* Then, you need to pass this array to the *generatorChart* function that you have just taken.

### *Step 4:* Add the approriate plugin in the POM of the module project
* In the module project, you need to add some features in order to run your porject without a problem. More specific: 
1. The appropriate dependencies. The appropriate code is given [here](https://maven.apache.org/guides/introduction/introduction-to-dependency-mechanism.html#Importing_Dependencies) 
2. The appropriate plugins. The appropriate code is given [here](https://maven.apache.org/guides/mini/guide-configuring-plugins.html).
* In the section *mainClass* add the path: *name-of-the-package*.*name-of-the-java-class*.

### *Step 5:* Execute the *Maven install*
As you build the project with *Eclipse* there is no need to add Maven by yourself because it is provided automatically.

* So, next step is to do a right click on the module project, then *Run As* --> *Maven install*. 
By doing this, two jar files will be created.

### *Step 6:* Cmd
* The last step is to use the command line. Open the git bash and find your directory with the maven project.
* Then, go inside the target directory and type *java -jar gradeshistogram-0.0.1-SNAPSHOT-jar-with-dependencies grades.txt*.
* If you follow all the previous instructions step-by-step, a histogram with the frequencies of the grades will 
automatically generated.



#### And that's all!! It's a given that the histogram will reward your effort...


## About the second Lab assignment
You can find the README.md file for the second Lab assignment by clicking [here](https://github.com/STAMATIOSL/Lab-assignments/tree/development/unit_testing-Lab3/README.md)

## About the third Lab assignment
You can find the README.md file for the third Lab assignment by clicking [here](https://github.com/STAMATIOSL/Lab-assignments/blob/development/design_patterns-Lab4/README.md)
