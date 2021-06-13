package codeanalyzer;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import codeanalyzer.SourceCodeAnalyzer;

import static org.junit.Assert.*;

/**
* The SourceCodeAnalyzerTest provides tests for the SourceCodeAnalyzer class.
*
* @author  Stamatis Liakos
* @version 1.0
* @since   2021-06-13
*/

public class SourceCodeAnalyzerTest {
	private static List<String> testSourceCode;
	private final static String TYPE_REGEX = "regex";
	private final static String TYPE_STRCOMP = "strcomp";
	private final static String TEST_CLASS = "src/test/resources/TestClass.java";
	private final static String TEST_LOCAL = "local";
	SourceCodeAnalyzer analyzer = new SourceCodeAnalyzer();
	
	
	@Test
	public void testCalculateRegexLOC() throws IOException {
		assertEquals(21, analyzer.calculateLOC(TEST_LOCAL, TEST_CLASS, TYPE_REGEX));
	}
	
	@Test
	public void testCalculateStrCompLOC() throws IOException {
		assertEquals(7, analyzer.calculateLOC(TEST_LOCAL, TEST_CLASS, TYPE_STRCOMP));
	}
	
	@Test
	public void testCalculateRegexNOM() throws IOException {
		assertEquals(3, analyzer.calculateNOM(TEST_LOCAL, TEST_CLASS, TYPE_REGEX));
	}
	
	@Test
	public void testCalculateStrCompNOM() throws IOException {
		assertEquals(3, analyzer.calculateNOM(TEST_LOCAL, TEST_CLASS, TYPE_STRCOMP));
	}
	
	@Test
	public void testCalculateRegexNOC() throws IOException {
		assertEquals(3, analyzer.calculateNOC(TEST_LOCAL, TEST_CLASS, TYPE_REGEX));
	}
	
	@Test
	public void testCalculateStrCompNOC() throws IOException {
		assertEquals(3, analyzer.calculateNOC(TEST_LOCAL, TEST_CLASS, TYPE_STRCOMP));
	}
	
	@Test
	public void testNullLOC() throws IOException {
		assertEquals(-1, analyzer.calculateLOC(TEST_LOCAL, TEST_CLASS, "non-existing"));
	}
	
	@Test
	public void testNullNOM() throws IOException {
		assertEquals(-1, analyzer.calculateNOM(TEST_LOCAL, TEST_CLASS, "non-existing"));
	}
	
	@Test
	public void testNullNOC() throws IOException {
		assertEquals(-1, analyzer.calculateNOC(TEST_LOCAL, TEST_CLASS, "non-existing"));
	}
	
}
