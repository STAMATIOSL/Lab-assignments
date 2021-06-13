package codeanalyzer;

import java.util.Map;

/**
 * Exports (writes) the metrics to a given output.
 * The output can be CSV or JSON files.
 * This class deliberately contains code smells and violations of design principles. 
 * @author sliakos
 *
 */

public class MetricsExporter {
	
	public void parseFile(String outputType, Map<String, Integer> metrics, String filepath) {
		FileParserFactory fpfact = new FileParserFactory();
		FileParser flpars = fpfact.writeFile(outputType);
		
		flpars.parseFile(metrics, filepath);
	}

}
