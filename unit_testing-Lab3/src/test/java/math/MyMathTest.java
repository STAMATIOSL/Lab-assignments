package math;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
* The MyMathTest provides tests for the MyMath class
* that serve as hands-on practice on Unit Testing.
*
* @author  Stamatis Liakos
* @version 1.0
* @since   2021-05-05
*/

public class MyMathTest {
	
	MyMath mm = new MyMath();
	ArrayOperations ao = new ArrayOperations();
	
	@Test
	public void test_factorial1() {
		Assert.assertEquals(1,  mm.factorial(0));
	}
	
	@Test
	public void test_factorial2() {
		Assert.assertEquals(1,  mm.factorial(1));
	}
	
	@Test
	public void test_factorial3() {
		Assert.assertEquals(2,  mm.factorial(2));
	}
	
	@Test
	public void test_factorial4() {
		Assert.assertEquals(479001600,  mm.factorial(12));
	}
    
	/*
	 * A test case for the exceptions caused when
	 * one or more input values are negative. Testing
	 * the exception is performed with a @Rule
	 */
	@Rule 
	public ExpectedException th1 = ExpectedException.none(); //initialize it to .none()
	
	@Test 
	public void testfactorialCauseAnException1() {
		// With @Rules you can perform more sophisticated checks
		th1.expect(IllegalArgumentException.class);
		th1.expectMessage("Input number is out of bounds (negative or very big).");
		mm.factorial(15);
	}
	
	@Rule 
	public ExpectedException th2 = ExpectedException.none(); //initialize it to .none()
	
	@Test 
	public void testfactorialCauseAnException2() {
		// With @Rules you can perform more sophisticated checks
		th2.expect(IllegalArgumentException.class);
		th2.expectMessage("Input number is out of bounds (negative or very big).");
		mm.factorial(-5);
	}
	
	@Test
	public void test_isPrime1() {
		Assert.assertEquals(true, mm.isPrime(7));
	}
	
	@Test
	public void test_isPrime2() {
		Assert.assertEquals(false, mm.isPrime(10));
	}
	
	@Test
	public void test_isPrime3() {
		Assert.assertEquals(true, mm.isPrime(2));
	}
	
	@Rule 
	public ExpectedException th3 = ExpectedException.none(); //initialize it to .none()
	
	@Test
	public void testisPrimeCauseAnException1() {
		th3.expect(IllegalArgumentException.class);
		th3.expectMessage("The given number is <2");
		mm.isPrime(-2);
	}
	
	@Rule 
	public ExpectedException th4 = ExpectedException.none(); //initialize it to .none()
	
	@Test
	public void testisPrimeCauseAnException2() {
		th4.expect(IllegalArgumentException.class);
		th4.expectMessage("The given number is <2");
		mm.isPrime(0);
	}
	
}
