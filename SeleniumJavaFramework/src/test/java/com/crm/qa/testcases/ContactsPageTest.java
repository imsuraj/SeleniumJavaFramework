package com.crm.qa.testcases;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	String sheetName = "contacts";

	public ContactsPageTest() {
		super();
	}




	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		contactsPage = new ContactsPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
		contactsPage = homePage.clickOnContactsLink();
		
	}


	@Test(priority = 1)
	public void verifyContactsPageLabelTest() {

		//contactsPage.verifyContactsLabel();
		Assert.assertTrue(contactsPage.verifyContactsLabel(),"contacts label is missing on this page.");
	}

	
	@Test(priority = 2)
	public void selectSingleContactsTest() {
		contactsPage.selectContactsByName("Aksh Yadav");
	}
	
	@Test(priority = 3)
	public void selectMultipleContactsTest() {
		contactsPage.selectContactsByName("Aksh Yadav");
		contactsPage.selectContactsByName("Amul Cobbler");
	}
	
	@DataProvider
	public Object[][] getCRMTestData() throws Exception {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority = 4, dataProvider = "getCRMTestData")
	public void validateCreateNewContact(String title, String firstName, String lastName, String company)  {
		homePage.clickOnNewContactLink();
		//contactsPage.createNewContact("Mr.", "Suraj", "Suraj", "Google");
		contactsPage.createNewContact(title, firstName, lastName, company);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
