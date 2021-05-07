package math;

import java.util.ArrayList;
import java.util.List;

import io.FileIO;

/**
* The ArrayOperations provides simple file input/output operations
* that serve as hands-on practice on Unit Testing.
*
* @author  Stamatis Liakos
* @version 1.0
* @since   2021-05-05
*/

public class ArrayOperations {
	
	/**
	 * Performs the basic operations in order to identify the prime numbers of a given file.
	 * @param fileIo the file that has all the numbers
	 * @param filepath the path of the file that has all the numbers
	 * @param myMath an object of the myMath class in order to call the isPrime method
	 * @return the numbers that are in the given file and are prime
	 */
	
	public int[] findPrimesInFile(FileIO fileIo, String filepath, MyMath myMath) {
		
		int[] b = fileIo.readFile(filepath);
		
		List<Integer> numbers = new ArrayList<>();
		
		// Check all numbers of the given file and add in the list numbers only
		//the numbers that are prime
		for (int i = 0; i < b.length; i++) {
			if (myMath.isPrime(b[i])) {
				numbers.add(b[i]);
			}
		}
		
		// Convert a List to an array using 
		return numbers.stream().mapToInt(i -> i).toArray();
	}

}
