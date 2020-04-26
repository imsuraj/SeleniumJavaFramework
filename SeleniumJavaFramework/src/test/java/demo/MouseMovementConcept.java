package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseMovementConcept {
	static WebDriver driver = null;
	
	public static void main(String[] args) {
		hoverableDropdownTest();

//		//		WebDriverManager.chromedriver().setup();
//		//		WebDriver driver = new ChromeDriver();
//		WebDriverManager.firefoxdriver().setup();
//
//		driver = new FirefoxDriver();
//
//		driver.get("https://www.spicejet.com/");
//
//		Actions action = new Actions(driver);
//
//		WebElement addons= driver.findElement(By.linkText("ADD-ONS"));
//
//		action.moveToElement(addons).build().perform();
//
//		WebDriverWait wait = new WebDriverWait(driver, 10);
//
//		//		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("//a[contains(text(),'SpiceMax')]")));
//		WebElement subMenu = driver.findElement(By.xpath("//a[contains(text(),'SpiceMax')]"));
//		subMenu.click();
//		System.out.println("Completed");

	}
	
	public static void hoverableDropdownTest() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("https://www.bootply.com/render/6FC76YQ4Nh");
		
		Actions action = new Actions(driver);
		
		action.moveToElement(driver.findElement(By.linkText("Dropdown")));
		
		
		action.moveToElement(driver.findElement(By.linkText("Dropdown Link 5")));

		
		action.moveToElement(driver.findElement(By.linkText("Dropdown Submenu Link 5.4")));

		
		action.moveToElement(driver.findElement(By.linkText("Dropdown Submenu Link 5.4.1")));

		
		
		
		
		
	}

}
