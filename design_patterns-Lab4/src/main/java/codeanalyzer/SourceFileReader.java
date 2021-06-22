package codeanalyzer;

import java.io.IOException;
import java.util.List;

/**
 * This class contains two reading file functions.
 * 
 * The first one (readFileIntoList) reads the file and
 * returns its content in the form of a List.
 * @return a List that contains the contents of the file 
 * or null if the type is neither <b>local</b> nor <b>web</b>
 * @throws IOException
 * 
 * The second one (readFileIntoString) reads the file and
 * returns it in the form of a single String.
 * @return a String that contains the contents of the file
 * or null if the type is neither <b>local</b> nor <b>web</b>
 * @throws IOException
 * 
 * @author sliakos
 *
 */

public class SourceFileReader {
	
	public List<String> readFileIntoList(String filepath) throws IOException {
		TypeFactory tfact = new TypeFactory();
		Type typ = tfact.type(type);
		
		return typ.readFileIntoList(filepath);
	}
	
	public String readFileIntoString(String filepath) throws IOException {
		TypeFactory tfact = new TypeFactory();
		Type typ = tfact.type(type);
		
		return typ.readFileIntoString(filepath);
	}
	
	private String type;
	
	public SourceFileReader(String _type) {
		this.type = _type;
	}

}
