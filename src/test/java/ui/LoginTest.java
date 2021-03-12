package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {

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
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
//		driver.findElement(By.id("login-button")).click();
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div[1]/div/form/input[3]")).click();
		driver.close();
		}


		
	}

}
