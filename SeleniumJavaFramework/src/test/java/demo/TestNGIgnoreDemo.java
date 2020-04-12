package demo;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;



public class TestNGIgnoreDemo {
	
	
	@Test
	public void test1() {
		System.out.println("I am inside test 1.");
	}
	
	
	@Test
	public void test2() {
		System.out.println("I am inside test 2.");
	}
	
}
