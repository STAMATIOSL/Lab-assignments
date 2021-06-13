package codeanalyzer;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
* This interface contains 3 classes, one for each expression.
* @param fileReaderType the location of a file 
* (<b>local</b> for locally stored files, 
* <b>web</b> for files stored on the web). 
* @param filepath the url of the file
* @return an integer which will be the LOC, the NOM
* or the NOC
* @throws IOException
*/

public interface AnalyzerType {
	public int LOC(String filepath) throws IOException;
	public int NOM(String filepath) throws IOException;
	public int NOC(String filepath) throws IOException;
}

class Regex implements AnalyzerType {
	
	private SourceFileReader fileReader;
	
	public Regex(String fileReaderType) {
		this.fileReader = new SourceFileReader(fileReaderType);
	}
	
	@Override
	public int LOC(String filepath) throws IOException {
		String sourceCode = fileReader.readFileIntoString(filepath);
		Pattern pattern = Pattern.compile("((//.*)|(/\\*.*)|(\\*+.*))");
        Matcher nonCodeLinesMatcher = pattern.matcher(sourceCode);

        int nonCodeLinesCounter = 0;
        while (nonCodeLinesMatcher.find()) {
        	nonCodeLinesCounter++;
        }
		
        int sourceFileLength = sourceCode.split("\n").length;
        int loc =  sourceFileLength - nonCodeLinesCounter;
        
		return loc;
	}
	
	@Override
	public int NOM(String filepath) throws IOException {
		String sourceCode = fileReader.readFileIntoString(filepath);
		Pattern pattern = Pattern.compile(".*(public |protected |private |static )?[\\w\\<\\>\\[\\]]+\\s+(\\w+) *\\([^\\)]*\\) *(\\{?|[^;]).*"); 
        Matcher methodSignatures = pattern.matcher(sourceCode);

        int methodCounter = 0;
        while (methodSignatures.find()) {
        	methodCounter++;
        }
		return methodCounter;
	}
	
	@Override
	public int NOC(String filepath) throws IOException {
		String sourceCode = fileReader.readFileIntoString(filepath);
		Pattern pattern = Pattern.compile(".*\\s*class\\s+.*"); 
        Matcher classSignatures = pattern.matcher(sourceCode);

        int classCounter = 0;
        while (classSignatures.find()) {
        	classCounter++;
        }
		return classCounter;
	}
}

class Strcomp implements AnalyzerType {
	
	private SourceFileReader fileReader;
	
	public Strcomp(String fileReaderType) {
		this.fileReader = new SourceFileReader(fileReaderType);
	}
	
	@Override
	public int LOC(String filepath) throws IOException {
		List<String> sourceCodeList = fileReader.readFileIntoList(filepath);
		int nonCodeLinesCounter = 0;
		for (String line : sourceCodeList) {
			line = line.stripLeading().stripTrailing(); //clear all leading and trailing white spaces
			if (line.startsWith("//") || line.startsWith("/*") || line.startsWith("*") || line.equals("{") || line.equals("}") || line.equals(""))
				nonCodeLinesCounter++;
		}
		int loc = sourceCodeList.size() - nonCodeLinesCounter;
		return loc;
	}
	
	@Override
	public int NOM(String filepath) throws IOException {
		List<String> sourceCodeList = fileReader.readFileIntoList(filepath);
		int methodCounter = 0;
		for (String line : sourceCodeList) {
			line = line.stripLeading().stripTrailing(); //clear all leading and trailing white spaces
			if ( ((line.contains("public") || line.contains("private") || line.contains("protected"))
					|| line.contains("void") || line.contains("int") || line.contains("String"))
				&& line.contains("(") && line.contains(")") && line.contains("{") )
				methodCounter++;
		}
		return methodCounter;
	}
	
	@Override
	public int NOC(String filepath) throws IOException {
		List<String> sourceCodeList = fileReader.readFileIntoList(filepath);
		int classCounter = 0;
		for (String line : sourceCodeList) {
			line = line.strip(); //remove leading and trailing white spaces
			if ((line.startsWith("class ") || line.contains(" class ")) && line.contains("{")) {
				classCounter++;
			}
		}
		return classCounter;
	}
}

class NullAnalyzerType implements AnalyzerType {
	
	@Override
	public int LOC(String filepath) throws IOException {
		return -1;
	}
	
	@Override
	public int NOM(String filepath) throws IOException {
		return -1;
	}
	
	@Override
	public int NOC(String filepath) throws IOException {
		return -1;
	}
}