import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserTest {
	public static void main(String[] args) {
		
//		String projectPath = System.getProperty("user.dir");
//		System.out.println("Project Path :" + projectPath);
		
		//System.setProperty("webdriver.gecko.driver", projectPath+"//drivers/geckoDriver/geckodriver");
		//WebDriver driver =  new FirefoxDriver();
		
		
		//System.setProperty("webdriver.chrome.driver", projectPath+"//drivers/chromedriver/chromedriver");
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.gogole.com/");
		
		driver.findElement(By.name("q"));
		WebElement textBox = driver.findElement(By.name("q"));
		textBox.sendKeys("Automation Step by step");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();
		
	}

}
