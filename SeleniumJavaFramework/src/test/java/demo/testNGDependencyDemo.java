package demo;

import org.testng.annotations.Test;

public class testNGDependencyDemo {
	
	@Test(dependsOnGroups = {"sanity.*"})
	public void test1() {
		System.out.println("This is test one.");
	}
	
	@Test(groups = {"sanity1"})
	public void test2() {
		System.out.println("This is test two.");
	}
	
	@Test(groups = {"sanity2"})
	public void test3() {
		System.out.println("This is test three.");
	}
}
