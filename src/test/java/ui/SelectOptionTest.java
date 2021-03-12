package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectOptionTest {

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
			driver.get("https://developer.salesforce.com/signup/");
			//xpath format for function start with
			//XPath= //tagname[start-with(@attribute,'Value')]
			// example ID = session12345 or ID =  session567890
			//where session is common(static) and the number next to it is dynamic
			// so if want tofind element whose id start with sesion+some dynamic number then we can use this xpathfunction
			driver.findElement(By.xpath("//input[starts-with(@id,\"last\")]")).sendKeys("Mistry");
		}
	}

}
