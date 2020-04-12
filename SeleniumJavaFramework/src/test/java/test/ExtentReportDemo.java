package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

@SuppressWarnings("deprecation")
public class ExtentReportDemo {

	static WebDriver driver = null;
	public static void main(String[] args) {
		
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extentReports.html");
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		
		ExtentTest test1 = extent.createTest("OrageHRM Test", "This is a test to validate ORange HRM functionality");
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		test1.log(Status.INFO, "Starting Test case..");
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		test1.pass("Navigated to Orange HRM login page..");
		
		
		driver.close();
		driver.quit();
		test1.pass("Closed the browser");
		
		test1.info("Test Completed..");
		
		extent.flush();
	}

}
