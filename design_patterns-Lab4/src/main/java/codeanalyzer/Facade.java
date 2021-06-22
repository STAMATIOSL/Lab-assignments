package codeanalyzer;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * This class, the Facade class, contains the association
 * with all the other classes.
 * It takes data (sourceFileLocation, filepath, sourceCodeAnalyzerType, 
 * outputFileType, outputFilePath etc.) from the Client class and it
 * sends them (the proper ones each time) to all the other classes of the project.
 * @author sliakos
 *
 */

public class Facade {
	
	public void operationAnalyzer(String sourceFileLocation, String filepath, 
			String sourceCodeAnalyzerType, String outputFileType, 
			String outputFilePath) throws IOException {
		SourceCodeAnalyzer analyzer = new SourceCodeAnalyzer();
		
		int loc = analyzer.calculateLOC(sourceFileLocation, filepath, sourceCodeAnalyzerType);
		int nom = analyzer.calculateNOM(sourceFileLocation, filepath, sourceCodeAnalyzerType);
		int noc = analyzer.calculateNOC(sourceFileLocation, filepath, sourceCodeAnalyzerType);
		
		Map<String, Integer> metrics = new HashMap<>();
		metrics.put("loc",loc);
		metrics.put("nom",nom);
		metrics.put("noc",noc);
		
		MetricsExporter exporter = new MetricsExporter();
		exporter.parseFile(outputFileType, metrics, outputFilePath);
	}

}
