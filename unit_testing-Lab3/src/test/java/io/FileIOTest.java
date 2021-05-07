package io;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
* The FileIOTest provides tests for the FileIO class
* that serve as hands-on practice on Unit Testing.
*
* @author  Stamatis Liakos
* @version 1.0
* @since   2021-05-05
*/

public class FileIOTest {
	
	FileIO fileio = new FileIO();
	public static String resourcesPath = "src/test/resources/";
	
	@Test
	public void testReadFileValidInput() {
		int[] expectedNumbers = new int[] {4, 9, 10, 7, 3, 6};
		String validInputFilepath = resourcesPath.concat("grades.txt");
		
		Assert.assertArrayEquals(expectedNumbers, fileio.readFile(validInputFilepath));
	}
	
	@Rule
	public ExpectedException th1 = ExpectedException.none();
	
	@Test
	public void test_fileio_not_existing() {
		th1.expect(IllegalArgumentException.class);
		th1.expectMessage("Input file does not exist");
		String validInputFilepath = resourcesPath.concat("grades1.txt");
		fileio.readFile(validInputFilepath);
	}
	
	@Rule
	public ExpectedException th2 = ExpectedException.none();
	
	@Test
	public void test_fileio_emptiness() {
		th2.expect(IllegalArgumentException.class);
		th2.expectMessage("Given file is empty");
		String validInputFilepath = resourcesPath.concat("gradesempty.txt");
		fileio.readFile(validInputFilepath);
	}
	
	@Test
	public void testReadFileContainsInvalidEntries() {
		int[] expectedObjects = new int[] {4, 9, 10};
		String validInputFilepath = resourcesPath.concat("gradesexample.txt");
		
		Assert.assertArrayEquals(expectedObjects, fileio.readFile(validInputFilepath));
	}
}
