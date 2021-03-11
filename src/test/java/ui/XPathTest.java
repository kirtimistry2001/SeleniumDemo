package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XPathTest {

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
			// relative xpath statys with double '//'
			driver.findElement(By.xpath("//input[@id=\"first_name\"]")).sendKeys("standard_user");

			// absolut xpath starts with single '/'
			// you can right clik on element and inspect and right click and copy > copyfull
			// xpath
			// this is the absolut/full xpath for 'first_name' input box on webpage
			driver.findElement(
					By.xpath("/html/body/div[1]/div[5]/div[1]/div[2]/div/div/div[2]/form/div[2]/div[1]/input"))
					.sendKeys("standard_user2");
		}
	}

}
