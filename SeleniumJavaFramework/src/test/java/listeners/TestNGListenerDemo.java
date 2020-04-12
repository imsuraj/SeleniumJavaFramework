package listeners;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners(listeners.TestNGListeners.class)
public class TestNGListenerDemo {
	
	WebDriver driver = null;
	@Test
	public void test1() {

		System.out.println("I am inside test1.");
	}
	   
	@Test
	public void test2() {

		System.out.println("I am inside test2.");
		//AssertJUnit.assertTrue(false);
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://www.google.com/");
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("abc");
		driver.findElement(By.xpath("//input[@name='qdsf']")).sendKeys("abc");
		driver.close();	
	}
	
	@Test
	public void test3() {

		System.out.println("I am inside test3.");
		throw new SkipException("This test is skipped.");
	}
}
