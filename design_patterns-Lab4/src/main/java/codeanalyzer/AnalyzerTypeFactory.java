package codeanalyzer;

/**
* This class contains the if statements which check if the
* given expression is regex, strcomp or something wrong which
* is referred to null.
* @param sourceFileLocation the location of a file 
* (<b>local</b> for locally stored files, 
* <b>web</b> for files stored on the web). 
* @param analyzerType the type of the expression (regex, strcomp or null)
* @return an analyzertype which will be regex, strcomp or null
*/

public class AnalyzerTypeFactory {
	
	public AnalyzerType analyzerType(String sourceFileLocation, String analyzerType) {
		AnalyzerType analyzertype;
		if (analyzerType.equals("regex")) {
			analyzertype = new Regex(sourceFileLocation);
		} else if (analyzerType.equals("strcomp")) {
			analyzertype = new Strcomp(sourceFileLocation);
		} else {
			analyzertype = new NullAnalyzerType();
		}
		
		return analyzertype;
	}

}
