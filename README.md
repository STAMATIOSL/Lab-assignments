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
