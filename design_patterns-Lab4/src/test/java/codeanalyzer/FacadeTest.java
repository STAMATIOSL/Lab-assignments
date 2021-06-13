package codeanalyzer;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

/**
* The FacadeTest provides tests for the Facade class.
*
* @author  Stamatis Liakos
* @version 1.0
* @since   2021-06-13
*/

public class FacadeTest {
	
	Facade facade = new Facade();
	SourceCodeAnalyzer analyzer = new SourceCodeAnalyzer();
	MetricsExporter mex = new MetricsExporter();
	
	private final static String sourceFileLocation = "local";
	private final static String filepath = "src/test/resources/TestClass.java";
	private final static String sourceCodeAnalyzerTypeRegex = "regex";
	private final static String sourceCodeAnalyzerTypeStrcomp = "strcomp";
	
	@Test
	public void testcalculateLOCRegex() throws IOException {
		int loc = analyzer.calculateLOC(sourceFileLocation, filepath, sourceCodeAnalyzerTypeRegex);
		Assert.assertEquals(loc, 21);
	}
	
	@Test
	public void testcalculateNOMRegex() throws IOException {
		int nom = analyzer.calculateNOM(sourceFileLocation, filepath, sourceCodeAnalyzerTypeRegex);
		Assert.assertEquals(nom, 3);
	}
	
	@Test
	public void testcalculateNOCRegex() throws IOException {
		int noc = analyzer.calculateNOC(sourceFileLocation, filepath, sourceCodeAnalyzerTypeRegex);
		Assert.assertEquals(noc, 3);
	}
	
	@Test
	public void testcalculateLOCStrcomp() throws IOException {
		int loc = analyzer.calculateLOC(sourceFileLocation, filepath, sourceCodeAnalyzerTypeStrcomp);
		Assert.assertEquals(loc, 7);
	}
	
	@Test
	public void testcalculateNOMStrcomp() throws IOException {
		int nom = analyzer.calculateNOM(sourceFileLocation, filepath, sourceCodeAnalyzerTypeStrcomp);
		Assert.assertEquals(nom, 3);
	}
	
	@Test
	public void testcalculateNOCStrcomp() throws IOException {
		int noc = analyzer.calculateNOC(sourceFileLocation, filepath, sourceCodeAnalyzerTypeStrcomp);
		Assert.assertEquals(noc, 3);
	}
	
	@Test
	public void testWriteCsv() {
		// create the metrics content
		Map<String, Integer> metrics = new HashMap<>();
		metrics.put("loc",30);
		metrics.put("nom",5);
		metrics.put("noc",2);
		
		// generate and write the output file
		String outputFilepath = "src/test/resources/output_metrics";
		mex.parseFile("csv", metrics, outputFilepath);
		
		// evaluate that the file exists
		File outputFile = new File(outputFilepath + ".csv");
		Assert.assertTrue(outputFile.exists());
		
		// delete the generated file
		outputFile.delete();
	}
}
