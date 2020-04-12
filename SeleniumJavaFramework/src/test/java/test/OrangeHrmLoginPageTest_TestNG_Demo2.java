package test;



import org.testng.annotations.Test;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.OrangeHrmLoginPage;

@SuppressWarnings("deprecation")
public class OrangeHrmLoginPageTest_TestNG_Demo2 {

	WebDriver driver = null;
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;

	@BeforeSuite
	public void setUpTest () {
		
		
		htmlReporter = new ExtentHtmlReporter("eReports.html");

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		
	}
	
	@BeforeTest
	public void BeforeTest() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		Thread.sleep(5000);

		
	}

	@Test
	public void orangeHRMLoginTest2( ) throws Exception {


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
	public void orangeHRMInvalidLoginTest2() throws Exception {


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
		
		driver.close();
		driver.quit();
		System.out.println("Test Completed successfully");
	}

	@AfterSuite
	public void tearDownTest() {
		
		
		extent.flush();
		
	}
}
