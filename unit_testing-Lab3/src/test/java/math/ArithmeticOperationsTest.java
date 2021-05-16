package math;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

/**
* The ArithmeticOperationsTest provides tests for the ArithmeticOperations class
* that serve as hands-on practice on Unit Testing.
*
* @author  Stamatis Liakos
* @version 1.0
* @since   2021-05-05
*/

public class ArithmeticOperationsTest {
	
	ArithmeticOperations ao = new ArithmeticOperations();
	
	@Test
	public void test_divide1() {
		Assert.assertEquals(2.0, ao.divide(10.5, 5.25), 0.0001);
	}
	
	@Test
	public void test_divide2() {
		Assert.assertEquals(0.0, ao.divide(0.0, 2.35), 0.0001);
	}
	
	@Test
	public void test_divide3() {
		Assert.assertEquals(Double.MAX_VALUE, ao.divide(Double.MAX_VALUE, 1.00), 0.0001);
	}
	
	@Test
	public void test_divide4() {
		Assert.assertEquals(Double.MIN_VALUE, ao.divide(Double.MIN_VALUE, 1.00), 0.0001);
	}
	
	@Test
	public void test_divide5() {
		Assert.assertEquals(0.0, ao.divide(10.2, Double.MAX_VALUE), 0.0001);
	}
	
	@Test
	public void test_divide6() {
		Assert.assertEquals(-5.00, ao.divide(10.00, -2.00), 0.0001);
	}
	
	@Test
	public void test_divide7() {
		Assert.assertEquals(5.00, ao.divide(-10.00, -2.00), 0.0001);
	}
	
    /*
	 * A unit test that checks an invalid zero input
	 * that causes an IllegalArgumentException
	 */
    @Test (expected = ArithmeticException.class)
    public void testDivideShouldCauseAnException() {
    	double zero = 0.0;
    	ao.divide(7.35, zero);
    }
	
	@Test
	public void test_mutliply1() {
		Assert.assertEquals(10, ao.multiply(5, 2));
	}
	
	@Test
	public void test_multiply2() {
		Assert.assertEquals(700, ao.multiply(20, 35));
	}
	
	@Test
	public void test_multiply3() {
		Assert.assertEquals(0, ao.multiply(0, 35));
	}
	
	@Test
	public void test_multiply4() {
		Assert.assertEquals(0, ao.multiply(8, 0));
	}
	
	@Test
	public void test_multiply5() {
		Assert.assertEquals(0, ao.multiply(Integer.MAX_VALUE, 0));
	}
	
	@Test
	public void test_multiply6() {
		Assert.assertEquals(0, ao.multiply(0, Integer.MAX_VALUE));
	}
	
	@Rule
	public ExpectedException th1 = ExpectedException.none();
	
	@Test
	public void test_multiply_RuleException1() {
		th1.expect(IllegalArgumentException.class);
		th1.expectMessage("x & y should be >= 0");
		ao.multiply(-1, 5);
	}
	
	@Rule
	public ExpectedException th2 = ExpectedException.none();
	
	@Test
	public void test_multiply_RuleException2() {
		th2.expect(IllegalArgumentException.class);
		th2.expectMessage("x & y should be >= 0");
		ao.multiply(2, -7);
	}
	
	@Rule
	public ExpectedException th3 = ExpectedException.none();
	
	@Test
	public void test_multiply_RuleException3() {
		th3.expect(IllegalArgumentException.class);
		th3.expectMessage("The product does not fit in an Integer variable");
		ao.multiply(Integer.MAX_VALUE, 10);
	}
	
	@Rule
	public ExpectedException th4 = ExpectedException.none();
	
	@Test
	public void test_multiply_RuleException4() {
		th4.expect(IllegalArgumentException.class);
		th4.expectMessage("The product does not fit in an Integer variable");
		ao.multiply(9, Integer.MAX_VALUE);
	}
	
}
