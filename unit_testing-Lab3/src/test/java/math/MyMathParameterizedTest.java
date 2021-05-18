package math;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

/**
 * A test class that implements a Parameterized test
 * for the MyAdvancedMath powerOfTwo method, 
 * for demonstrating Unit Testing.
 * 
 * @author Stamatis Liakos
 * @version 1.0
 * @since   2021-05-05
 */

@RunWith(Parameterized.class)
public class MyMathParameterizedTest {
	
	// the value is the id of each parameter
	@Parameter (value = 0)
	public int fact1;
	@Parameter (value = 1) 
	public int result1;
	
	MyMath mm = new MyMath();
	
	@Parameters
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][]{{0,1},{1,1},{2,2},{12,479001600}};
		
		return Arrays.asList(data);
	}
	
	/*
	 * A unit test that is executed for each pair of 
	 * parameters. 
	 */
	@Test
	public void testFactorialWithNormalCases() {
		Assert.assertEquals(result1, mm.factorial(fact1));
	}
}
