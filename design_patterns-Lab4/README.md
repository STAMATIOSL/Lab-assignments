## About the third Lab assignment

1. Build the executable Java application with: 
	mvn package jacoco:report

2. Run the executable by executing
	java –jar “jar-with-dependencies” arg0 arg1 arg2 arg3 arg4
were args translate to: 	
	arg0 = “JavaSourceCodeInputFile” (e.g., src/test/resources/TestClass.java)
	arg1 = “sourceCodeAnalyzerType” [regex|strcomp]
	arg2 = “SourceCodeLocationType” [local|web]
	arg3 = “OutputFilePath” (e.g., ../output_metrics_file)
	arg4 = “OutputFileType” [csv|json]
example: 
	java –jar ./target/sourcecodeanalyzer-0.0.1-SNAPSHOT-jar-with-dependencies.jar ./src/test/resources/TestClass.java regex local metrics_results csv

3. Make changes with Patterns to improve the quality of the system

### *1st Pattern:* Strategy Pattern
* Create an Interface named *FileParser* in order to implement a class that parses different types of files. In our example 
we have the csv and the json types.
* (+) In this way, we can easily add more functionalities (more types of files here) that they would be required.
* (+) Also, if something is needed to be changed, it will not affect the other functionalities.
* (+) Parsers are extensible. There is almost no need for changes in the Client.
* (+) Complexity is reduced with less *if* statements.
* (-) On he other hand, the Client, here the *FileParser* class is still coupled to Parser implementations.

*Create an Interface named *AnalyzerType* in order to implement a class that parses different types of expressions. In our example 
we have the regex and the strcomp expressions.
* (+) In this way, we can easily add more functionalities (more types of expressions here) that they would be required.
* (+) Also, if something is needed to be changed, it will not affect the other functionalities.
* (+) Parsers are extensible. There is almost no need for changes in the Client.
* (+) Complexity is reduced with less *if* statements.
* (-) On he other hand, the Client, here the *AnalyzerType* class is still coupled to Parser implementations.

*Create an Interface named *Type* in order to implement a class that parses different types of source code location. In our example 
we have the local and the web source code location.
* (+) In this way, we can easily add more functionalities (more source code location of files here) that they would be required.
* (+) Also, if something is needed to be changed, it will not affect the other functionalities.
* (+) Parsers are extensible. There is almost no need for changes in the Client.
* (+) Complexity is reduced with less *if* statements.
* (-) On he other hand, the Client, here the *Type* class is still coupled to Parser implementations.


### *2nd Pattern:* Factory Pattern
* Create a seperate Java class named *FileParserFactory* which has all the *if* statements regarding the type of the output file.
* (+) Take all these *if* statements from *MetricsExporter* class and put them in the *FileParserFactory* one.
* (+) In this way, we provide a seperate class to refer to all types of an object, here the types of the output file. So, the seperation of concerns is increased.
* (+) Also, we can extend the hierarchy without affecting the clients.

* Create a seperate Java class named *AnalyzerTypeFactory* which has all the *if* statements regarding the type of the expression.
* (+) Take all these *if* statements from *SourceCodeAnalyzer* class and put them in the *AnalyzerTypeFactory* one.
* (+) In this way, we provide a seperate class to refer to all types of an object, here the types of the expression. So, the seperation of concerns is increased.
* (+) Also, we can extend the hierarchy without affecting the clients.

* Create a seperate Java class named *TypeFactory* which has all the *if* statements regarding the type of the source code location.
* (+) Take all these *if* statements from *SourceFileReader* class and put them in the *TypeFactory* one.
* (+) In this way, we provide a seperate class to refer to all types of an object, here the types of the source code location. So, the seperation of concerns is increased.
* (+) Also, we can extend the hierarchy without affecting the clients.


### *3rd Pattern:* Façade Pattern
* Create a seperate Java class named *Facade*.
* This class will be called by the Client, here the *DemoClient*, in order for the *DemoClient* not to call all the other classes.
* So, in the *Facade* class will be all the classes gathered. It's like un umbrella which has all the classes under it.
* (+) In this way, a simple class is provided to a complex system making the operation easier.
* (+) Also, it increases the independence and the portability of the subsystem.


### *4th Pattern:* Null Object
* In the *AnalyzerType* class create a seperate class named *NullAnalyzerType*.
* This class will be called when the type of the given expression is neither regex nor strcomp.
* (+) In this way, *NullAnalyzerType* class implements its interface to do nothing. Here, it creates a file with the number *-3* inside.
* (+) Also, there is no need to write code in order to handle the *NullPointerException*.
* (-) However, it could hide errors that would be critical and make the testing code more complicated.

* In the *Type* class create a seperate class named *NullType*.
* This class will be called when the type of the given source code location is neither local nor web.
* (+) In this way, *NullType* class implements its interface to do nothing. Here, it causes a *NullPointerException*.
* (+) Also, there is no need to write code in order to handle the *NullPointerException* because it handles it itself.
* (-) However, it could hide errors that would be critical and make the testing code more complicated.


For further information about the functionality of each class, see the documentation inside them.
