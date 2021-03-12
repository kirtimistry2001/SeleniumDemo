package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IFrameTest {

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
			driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_element_classname");
			driver.manage().window().maximize();
			//switch to the frame on right side
			driver.switchTo().frame("iframeResult");
			//by index
			//args.driver.switchTo().frame(0);
			//tryit button
			driver.findElement(By.xpath("/html/body/button")).click();
		}
	}

}
