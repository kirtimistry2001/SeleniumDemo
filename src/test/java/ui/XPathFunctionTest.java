package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XPathFunctionTest {

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
			driver.get("https://www.sugarcrm.com/request-demo");
			WebElement coutryDropDown = driver.findElement(By.name("employees_c"));
			Select select = new Select(coutryDropDown);
			select.selectByValue("level4");
			//just to see put the thread to sleep
			try {
				Thread.sleep(2000);
				select.selectByVisibleText("51 - 100 employees");
				Thread.sleep(2000);
				select.selectByIndex(5);
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
