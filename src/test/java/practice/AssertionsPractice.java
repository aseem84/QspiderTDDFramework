package practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionsPractice {
	
	@Test
	public void sample()
	{
		String a = "hi";
		
		System.out.println("Step 1");
		System.out.println("Step 2");
		System.out.println("Step 3");
	
		
		Assert.assertEquals(2, 1);//pass
		
		Assert.assertTrue(a.contains("i"));
		
		System.out.println("Step 4");
		System.out.println("Step 5");
			
	}
	
	@Test
	public void sample1()
	{
		SoftAssert sa = new SoftAssert();
		
		String a = "hi";
		
		System.out.println("Step 1");
		System.out.println("Step 2");
		System.out.println("Step 3");
		
		sa.assertEquals(0, 1);//fail
		
		sa.assertTrue(a.contains("e"));

		System.out.println("Step 4");
		System.out.println("Step 5");
		
		sa.assertAll();//log all assertions fails
			
	}

}
