package codeanalyzer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
* This interface contains 3 classes, one for each type of the output file.
* It exports the metrics to a given output.
* The output can be CSV or JSON files.
* In the case of a wrong output file, it throws an Illegal Argument Exception
* with the message "Operation aborted due to unknown file parser".
* @author sliakos
*/

public interface FileParser {
	public void parseFile(Map<String, Integer> metrics, String filepath);
}

class writeCsv implements FileParser {
	
	@Override
	public void parseFile(Map<String, Integer> metrics, String filepath) {
		File outputFile = new File(filepath + ".csv");
		StringBuilder metricsNames = new StringBuilder();
		StringBuilder metricsValues = new StringBuilder();
		
		for (Map.Entry<String, Integer> entry : metrics.entrySet()) {
			metricsNames.append(entry.getKey() + ",");
			metricsValues.append(entry.getValue()+",");
		}
		
		try {
			FileWriter writer = new FileWriter(outputFile);
			writer.append(metricsNames + "\n");
			writer.append(metricsValues + "\n");
			writer.close();
			System.out.println("Metrics saved in " + outputFile.getAbsolutePath());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class writeJson implements FileParser {
	
	@Override
	public void parseFile(Map<String, Integer> metrics, String filepath) {
		// Functionality not implemented yet
		// No need to implement it for the assignment
	}
}

class writeNull implements FileParser {
	
	@Override
	public void parseFile(Map<String, Integer> metrics, String filepath) {
		throw new IllegalArgumentException("Operation aborted due to unknown file parser");
	}
}