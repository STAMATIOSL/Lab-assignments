package math;

/**
* The MyMath provides simple file input/output operations
* that serve as hands-on practice on Unit Testing.
*
* @author  Stamatis Liakos
* @version 1.0
* @since   2021-05-05
*/

public class MyMath {
	
	/**
	 * Performs the basic operations in order to return the factorial of a given number.
	 * @param x int x is the given number
	 * @return the factorial of the given number x
	 * @exception IllegalArgumentException when <b>x</b> is negative or very big(>12)
	 */
	
	public int factorial(int x) {
		
		if (x < 0 || x > 12) {
			throw new IllegalArgumentException("Input number is out of bounds (negative or very big).");
		}
		else if (x == 0) {
			return 1;
		} else {
			return (x*factorial(x-1));
		}
	}
	
	/**
	 * Performs the basic operations in order to identify if the given number is prime or not.
	 * @param n int n is the given number
	 * @return true if the given number is prime and false if it is not
	 * @exception IllegalArgumentException when <b>x</b> is smaller than 2.
	 */
	
	public boolean isPrime(int n) {
		
		if (n >= 2) {
			
			int a = 0;
			boolean isPrime = true;
			
			for(int i = 2; i <= n/2; i++) {
				a = n % i;
				if (a == 0) {
					isPrime = false;
					break;
				}
			}
			
			return isPrime;
			
		} else {
			throw new IllegalArgumentException("The given number is <2");
		}
	}
}
