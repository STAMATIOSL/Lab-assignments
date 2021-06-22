package codeanalyzer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * This interface contains 3 classes, one for each source of the code location.
 * 
 * The first class (Local) reads the file and
 * returns its content in the form of a List or
 * in the form of a single String.
 * @return a List or a String
 * @throws IOException
 * 
 * The second class (Web) reads the file and
 * returns its content in the form of a List or
 * in the form of a single String.
 * @return a List or a String
 * @throws IOException
 * 
 * The third class (NullType) reads the file and
 * returns a null object because the source of the code location is
 * neither local nor web.
 * @return null
 * @throws IOException
 * 
 * @author sliakos
 *
 */

public interface Type {
	public List<String> readFileIntoList(String filepath) throws IOException;
	public String readFileIntoString(String filepath) throws IOException;
}

class Local implements Type {
	
	@Override
	public List<String> readFileIntoList(String filepath) throws IOException {
		List<String> lines = new ArrayList<>();
		File file = new File(filepath);
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line = null;
		while ((line = reader.readLine()) != null) {
			lines.add(line);
		}
		reader.close();
		return lines;
	}
	
	@Override
	public String readFileIntoString(String filepath) throws IOException {
		StringBuilder sb = new StringBuilder();
		File file = new File(filepath);
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line = null;
		while ((line = reader.readLine()) != null) {
			sb.append(line + "\n");
		}
		reader.close();
		return sb.toString();
	}
}

class Web implements Type {
	
	@Override
	public List<String> readFileIntoList(String filepath) throws IOException {
		List<String> lines = new ArrayList<>();
        URL url = new URL(filepath);
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
        String line = null;
        while ((line = reader.readLine()) != null) {
        	lines.add(line);
        }
        reader.close();
		return lines;
	}
	
	@Override
	public String readFileIntoString(String filepath) throws IOException {
		StringBuilder sb = new StringBuilder();
        URL url = new URL(filepath);
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
        String line = null;
        while ((line = reader.readLine()) != null) {
        	sb.append(line + "\n");
        }
        reader.close();
		return sb.toString();
	}
}

class NullType implements Type {
	
	@Override
	public List<String> readFileIntoList(String filepath) throws IOException {
		return null;
	}
	
	@Override
	public String readFileIntoString(String filepath) throws IOException {
		return null;
	}
}
