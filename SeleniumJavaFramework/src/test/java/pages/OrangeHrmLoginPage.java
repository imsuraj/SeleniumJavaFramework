package pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrangeHrmLoginPage {
	
	WebDriver driver = null;
	
	By textbox_username = By.id("txtUsername");
	By textbox_password = By.id("txtPassword");
	By button_login 	= By.id("btnLogin");
	By message_welcome = By.xpath("//font[contains(text(),'Welcome Admin')]");
	By span_message = By.id("spanMessage");
	
	public OrangeHrmLoginPage(WebDriver driver) {
		this.driver = driver;
	}
	public void enterUsernameInTextbox(String username) {
		driver.findElement(textbox_username).sendKeys(username);
	}
	
	public void enterPasswordInTextbox(String password) {
		driver.findElement(textbox_password).sendKeys(password);
	}
	
	
	public void clickLoginButton() {
		driver.findElement(button_login).click();
		
//		String actualString = driver.findElement(message_welcome).getText();
//		System.out.println(actualString);
//		assertTrue(actualString.contains("Welcome Admin"));
	}
	
	public void verifyMessage() {
//		String text = driver.findElement(span_message).getText();
//		System.out.println("Text obtained is" + text);
		
		String actualString = driver.findElement(span_message).getText();
		//System.out.println(actualString);
		assertTrue(actualString.contains("Invalid credentials"));
	

		}
	}

