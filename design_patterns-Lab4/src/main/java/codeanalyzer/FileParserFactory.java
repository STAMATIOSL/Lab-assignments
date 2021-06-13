package codeanalyzer;

/**
* This class contains the if statements which check if the
* output file is CSV, JSON or something wrong which
* is referred to null.
* @param outputType the type of the output file (CSV, JSON or null)
* @return a fileparser which will be CSV, JSON or null
*/

public class FileParserFactory {
	
	public FileParser writeFile(String outputType) {
		FileParser fileparser;
		if (outputType.equals("csv")) {
			fileparser = new writeCsv();
		} else if (outputType.equals("json")) {
			fileparser = new writeJson();
		} else {
			fileparser = new writeNull();
		}
		
		return fileparser;
	}

}
