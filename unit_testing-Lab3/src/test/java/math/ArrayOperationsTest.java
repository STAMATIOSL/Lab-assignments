package math;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Test;

import io.FileIO;

/**
* The ArrayOperationsTest provides tests for the ArrayOperations class
* that serve as hands-on practice on Unit Testing.
*
* @author  Stamatis Liakos
* @version 1.0
* @since   2021-05-05
*/

public class ArrayOperationsTest {
	
	ArrayOperations ao = new ArrayOperations();
	public static String resourcesPath = "src/test/resources/";
	
	@Test
	public void test_findPrimesInFile_Mocking() {
		
		//Mock the MyMath dependency
		FileIO io2 = mock(FileIO.class);
		MyMath mm2 = mock(MyMath.class);
		
		String validInputFilepath = resourcesPath.concat("grades.txt");
		
		int[] a = new int[2];
		a[0] = 7;
		a[1] = 3;
		
		boolean t = true;
		boolean f = false;
		
		when(mm2.isPrime(4)).thenReturn(f);
		when(mm2.isPrime(9)).thenReturn(f);
		when(mm2.isPrime(10)).thenReturn(f);
		when(mm2.isPrime(7)).thenReturn(t);
		when(mm2.isPrime(3)).thenReturn(t);
		when(mm2.isPrime(6)).thenReturn(f);
		when(io2.readFile(validInputFilepath)).thenReturn(a);
		
		Assert.assertArrayEquals(a, ao.findPrimesInFile(io2, validInputFilepath, mm2));
	}
}
