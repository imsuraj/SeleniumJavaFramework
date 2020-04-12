package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.OrangeHrmLoginPage;

public class OrangeHrmLoginPageTest {
	
	private static WebDriver driver = null;
	
	public static void main(String[] args) {
		orangeHRMLoginTest();
	}
	
	public static void orangeHRMLoginTest( ) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		
		OrangeHrmLoginPage loginPageObject = new OrangeHrmLoginPage(driver);
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		loginPageObject.enterUsernameInTextbox("Admin");
		loginPageObject.enterPasswordInTextbox("admin123");
		loginPageObject.clickLoginButton();
		
		driver.close();
		
		System.out.println("Test Completed successfully");
	}
}
