package math;

import org.junit.Test;
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
	
    /*
	 * A unit test that checks an invalid zero input
	 * that causes an IllegalArgumentException
	 */
    @Test (expected = ArithmeticException.class)
    public void testDivideShouldCauseAnException() {
    	ao.divide(5, 0);
    }
	
	@Test
	public void test_mutliply1() {
		Assert.assertEquals(10, ao.multiply(2, 5));
	}
	
	@Test
	public void test_multiply2() {
		Assert.assertEquals(700, ao.multiply(20, 35));
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
		th2.expectMessage("The product does not fit in an Integer variable");
		ao.multiply(Integer.MAX_VALUE, 10);
	}
}
