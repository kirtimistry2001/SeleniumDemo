package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.netty.util.internal.SystemPropertyUtil;

public class BasicWebDriverMethodsTest {

	public static String browser = "Chrome"; // TODO to read from some CSV file
	public static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		if (browser.equals("Chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("edge")) {
			driver = new EdgeDriver();
		}
		if (driver != null) {
			//get(url) basic webdriver method
			driver.get("https://www.saucedemo.com/");
			//manage method 
			driver.manage().window().maximize();
			//getcurrentutl() method
			String currentURL = driver.getCurrentUrl();
			System.out.println(currentURL);
			
			//getTitle() mrthod
			String title = driver.getTitle();
			System.out.println(title);
			
			//pageSource
			String source = driver.getPageSource();
			System.out.println(source);
			
			//navigate
			driver.navigate().to("http://google.com");
			
			//close current window
			driver.close();
			//close multiple window
			//driver.quit();
		}
	}

}
