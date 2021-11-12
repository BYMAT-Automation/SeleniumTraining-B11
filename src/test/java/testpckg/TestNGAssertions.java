package testpckg;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGAssertions {
	
	@Test
	public void testNGAssertions() {
		
		
		Assert.assertEquals("SeleniumTraining", "SeleniumTraining");
		
		System.out.println("I am in TestNG Assertion class - for char value validation" );
		
		Assert.assertEquals(true, true);
		
		System.out.println("I am in TestNG Assertion class - for boolean value validation" );
		
		Assert.assertTrue(false, "I am in TestNG Assertion class - for boolean value validation" );
		
	}

}
