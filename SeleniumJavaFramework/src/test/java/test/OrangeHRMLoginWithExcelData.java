package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.OrangeHrmLoginPage;
import utils.ExcelUtils;

public class OrangeHRMLoginWithExcelData {
	
	WebDriver driver = null;
	
	
	
//	@Test(dataProvider="test1data")
//	public void test1(String username, String password) {
//		
//		//System.out.println(username + " | " + password);
//	}
	
	
	@DataProvider (name="test1data")
	public  Object[][] getData() {
		
		String projectPath = System.getProperty("user.dir");
		Object data [][] = testData(projectPath+"/excel/SeleniumJava.xlsx", "Sheet1");
		return data; 
	}
	
	public  Object[][] testData(String excelPath, String sheetName) {
		ExcelUtils excel = new ExcelUtils(excelPath, sheetName); 
		int rowCount = excel.getRowCount();
		int colCount = excel.getColCount();
		
		Object data[][] = new Object[rowCount-1][colCount];
		
		for (int i = 1; i < rowCount; i++) {
			for (int j = 0; j < colCount; j++) {
				
				String cellData = excel.getCellDataString(i, j);
				//System.out.print(cellData+" | ");
				data[i-1][j] = cellData;
				
			}
			//System.out.println();
			
		}
		return data;
	}
	
	@BeforeTest
	public void BeforeTest() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
	}
	
	
	@Test(dataProvider="test1data")
	public void OrangeHRMLoginTest(String username, String password) {
		
		OrangeHrmLoginPage LoginPageObject = new OrangeHrmLoginPage(driver);
		LoginPageObject.enterUsernameInTextbox(username);
		LoginPageObject.enterPasswordInTextbox(password);
		LoginPageObject.clickLoginButton();
	}
	
	@AfterTest
	public void  AfterTest( ) {
		driver.close();
		driver.quit();
		System.out.println("Test Completed.");
	}
	
	

}
