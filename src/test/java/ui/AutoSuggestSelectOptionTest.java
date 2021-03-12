package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoSuggestSelectOptionTest {

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
			driver.get("https://www.etsy.com/ca");
			String wdHandle = driver.getWindowHandle();
			System.out.println(wdHandle);
			//finding using serch 
			WebElement serchKeyword = driver.findElement(By.xpath("//*[@id=\"global-enhancements-search-query\"]"));
			serchKeyword.sendKeys("flowers");
			try {
				//put the thread to sleep just to see
				Thread.sleep(2000);
				//now use down arrow key rto select fromthe dropdown list
				serchKeyword.sendKeys(Keys.ARROW_DOWN);
				serchKeyword.sendKeys(Keys.ARROW_DOWN);
				Thread.sleep(2000);
				serchKeyword.sendKeys(Keys.ENTER);

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
