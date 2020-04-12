package demo;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGRetryFailedDemo {
	
	
	@Test
	public void test1() {
		System.out.println("I am inside test 1.");
	}
	
	
	@Test(retryAnalyzer = listeners.RetryAnalyzer.class)
	public void test2() {
		System.out.println("I am inside test 2.");
		//int i = 1/0;
	}
	
	@Test(retryAnalyzer = listeners.RetryAnalyzer.class)
	public void test3() {
		System.out.println("I am inside test 3.");
		AssertJUnit.assertTrue(0>1);
	}
	
	
	
}
