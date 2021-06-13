package codeanalyzer;

import java.io.IOException;

/**
 * Analyzes the contents of a Java source code file 
 * and calculates the following metrics: loc = lines of code,
 * nom = number of methods, and noc=number of classes. 
 * The current functionality supports two types of source code analysis,
 * namely regex (with the use of regular expressions) and 
 * strcomp (with the use of string comparison).
 * It calls all these 3 methods (calculateLOC, calculateNOM, calculateNOC)
 * and each of it returns an integer which depends on the sourceFileLocation
 * (Local, web) and the analyzerType (regex or strcomp).
 * @author sliakos
 *
 */

public class SourceCodeAnalyzer {
	
	public int calculateLOC(String sourceFileLocation, String filepath, String analyzerType) throws IOException {
		AnalyzerTypeFactory atfactory = new AnalyzerTypeFactory();
		AnalyzerType antype = atfactory.analyzerType(sourceFileLocation, analyzerType);
		
		return antype.LOC(filepath);
	}
	
	public int calculateNOM(String sourceFileLocation, String filepath, String analyzerType) throws IOException {
		AnalyzerTypeFactory atfactory = new AnalyzerTypeFactory();
		AnalyzerType antype = atfactory.analyzerType(sourceFileLocation, analyzerType);
		
		return antype.NOM(filepath);
	}
	
	public int calculateNOC(String sourceFileLocation, String filepath, String analyzerType) throws IOException {
		AnalyzerTypeFactory atfactory = new AnalyzerTypeFactory();
		AnalyzerType antype = atfactory.analyzerType(sourceFileLocation, analyzerType);
		
		return antype.NOC(filepath);
	}
	
}
