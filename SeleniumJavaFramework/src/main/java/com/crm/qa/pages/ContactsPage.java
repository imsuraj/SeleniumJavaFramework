package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{

	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactsLabel;

	@FindBy(name="title")
	WebElement titleDropdown;

	@FindBy(id="first_name")
	WebElement firstNameTextbox;

	@FindBy(id="surname")
	WebElement lastNameTextbox;


	@FindBy(xpath="//input[@name='client_lookup']")
	WebElement companyTextbox;

	@FindBy(xpath="//*[@id=\"contactForm\"]/table/tbody/tr[1]/td/input[2]")
	WebElement saveButton;

	//Initializing page objects
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean verifyContactsLabel() {
		return contactsLabel.isDisplayed();
	}

	public void selectContactsByName(String name){
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']"
				+ "//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
	}


	public void createNewContact(String title, String firstName, String lastName, String companyName) {
		//Select select = new Select(titleDropdown);
		Select select = new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(title);

		firstNameTextbox.sendKeys(firstName);
		lastNameTextbox.sendKeys(lastName);
		companyTextbox.sendKeys(companyName);
		saveButton.click();
	}
}
