package demo;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNGMultiBrowserDemo {
	
	WebDriver driver = null;
	
	
	@Parameters("browserName")
	@BeforeTest
	public void setup(String browserName) {
		
		System.out.println("Thread is:"+Thread.currentThread().getId());
		System.out.println("Browser Name is :"+browserName);
		
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
		}
//		else if (browserName.equalsIgnoreCase("safari")) {
//			WebDriverManager.edgedriver().setup();
//			driver = new EdgeDriver();
//		}
			
	}
	
	@Test
	public void test1() throws Exception {
		driver.get("https://www.google.com");
		Thread.sleep(5000);
		
	}
	
	
	@AfterTest
	public void tearDown() {
		driver.close();
		
	}

}
