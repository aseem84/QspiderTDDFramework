package practice;

import org.testng.Assert;
import org.testng.annotations.Test;


public class RetryAnalyserPractice {
	
	@Test(retryAnalyzer = genericUtilities.RetryAnalyserImplementation.class)
	public void sample()
	{
		Assert.fail();
		System.out.println("Hi");
	}

}
