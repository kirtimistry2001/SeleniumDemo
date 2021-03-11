package ui;

import static org.openqa.selenium.support.locators.RelativeLocator.withTagName;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RelativeLocaterTest {

	
	public static String browser ="Chrome"; // TODO to read from some CSV  file
	public static WebDriver driver;
	public static void main(String[] args) {
	
		WebDriverManager.chromedriver().setup();
		if(browser.equals("Chrome")) {
			driver = new ChromeDriver();
		} else if(browser.equals("edge")) {
			driver = new EdgeDriver();
		} 
		if (driver != null) {
			driver.get("https://www.saucedemo.com/");
			//by relative above locator
		
			WebElement passwordField= driver.findElement(By.id("password"));
			WebElement userNameField = driver.findElement(withTagName("input")
			                                                  .above(passwordField));
			WebElement loginBtnField = driver.findElement(withTagName("input")
																.below(passwordField));
			userNameField.sendKeys("standard_user");
			passwordField.sendKeys("secret_sauce");
			loginBtnField.click();
			//	driver.close();
		}

		
		
		
	}

}
