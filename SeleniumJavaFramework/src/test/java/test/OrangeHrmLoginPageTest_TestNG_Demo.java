package test;



import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import config.PropertiesFile;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.OrangeHrmLoginPage;

@SuppressWarnings("deprecation")
public class OrangeHrmLoginPageTest_TestNG_Demo {

	WebDriver driver = null;
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;
	public static String browserName=null;

	@BeforeSuite
	public void setUpTest () {


		htmlReporter = new ExtentHtmlReporter("eReports.html");

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);


	}

	@BeforeTest
	public void BeforeTest() throws InterruptedException {
		
		PropertiesFile.getProperties();
		
		if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
		else if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);


	}

	@Test
	public void orangeHRMLoginTest( ) throws Exception {


		// creates a toggle for the given test, adds all log events under it    
		ExtentTest test = extent.createTest("Orange HRM Login test", "This is a test to validate Orange hrm valid login functionality");


		OrangeHrmLoginPage loginPageObject = new OrangeHrmLoginPage(driver);

		loginPageObject.enterUsernameInTextbox("Admin");
		loginPageObject.enterPasswordInTextbox("admin123");
		loginPageObject.clickLoginButton();

		// log(Status, details)
		test.log(Status.INFO, "Logged in successfully");

		// info(details)
		test.info("This step shows usage of info(details)");

		// log with snapshot
		test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());

		// test with snapshot
		test.addScreenCaptureFromPath("screenshot.png");



	}

	@Test
	public void orangeHRMInvalidLoginTest() throws Exception {


		// creates a toggle for the given test, adds all log events under it    
		ExtentTest test = extent.createTest("Orange HRM Login test", "This is a test to validate Orange hrm invalid login functionality");
		OrangeHrmLoginPage loginPageObject = new OrangeHrmLoginPage(driver);
		loginPageObject.enterPasswordInTextbox("invalid");
		loginPageObject.enterUsernameInTextbox("invalid");
		loginPageObject.clickLoginButton();
		loginPageObject.verifyMessage();

		// log(Status, details)
		test.log(Status.INFO, "Invalid login test run successfully.");

		// info(details)
		test.info("This step shows usage of info(details)");

		// log with snapshot
		test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());

		// test with snapshot
		test.addScreenCaptureFromPath("screenshot1.png");

	}

	@AfterTest
	public void AfterTest () {
		PropertiesFile.getProperties();
		
		if(browserName.equalsIgnoreCase("firefox")) {
			driver.close();
			System.out.println("Test Completed successfully on Firefox.");
			PropertiesFile.setProperties();
		}
		
		else if(browserName.equalsIgnoreCase("chrome")) {
			driver.close();
			driver.quit();
			System.out.println("Test Completed successfully on Chrome.");
			PropertiesFile.setProperties();
		}
		
		
	}

	@AfterSuite
	public void tearDownTest() {


		extent.flush();

	}
}
