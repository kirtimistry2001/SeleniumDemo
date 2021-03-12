package ui;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

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
			// get(url) basic webdriver method
			driver.get("https://www.saucedemo.com/");
			// manage method
			driver.manage().window().maximize();
			// getcurrentutl() method
			String currentURL = driver.getCurrentUrl();
			//System.out.println(currentURL);

			// getTitle() mrthod
			String title = driver.getTitle();
			//System.out.println(title);

			// pageSource
			String source = driver.getPageSource();
			//System.out.println(source);

			// findElement(By by) method to select
			WebElement uname = driver.findElement(By.id("user-name"));
			uname.sendKeys("standard_user");

			driver.findElement(By.id("password")).sendKeys("secret_sauce");
			driver.findElement(By.id("login-button")).click();

			// get all element in the list
			List<WebElement> webElements = driver.findElements(By.xpath("//*[@class=\'inventory_list\']/div"));
			System.out.println(webElements);
			// require to handle for the window. it issued when you want to switch between
			// window and get handle for switched window
			// getWindowHandles

			// navigate
			driver.navigate().to("http://etsy.com");
			String wdHandle = driver.getWindowHandle();
			System.out.println(wdHandle);
			//finding using serch 
			driver.findElement(By.xpath("//*[@id=\"global-enhancements-search-query\"]")).sendKeys("flowers");
			//click on serch icon  //*[@id="gnav-search"]/div/div[1]/button/span/svg
			driver.findElement(By.xpath("//*[@id=\"gnav-search\"]/div/div[1]/button")).click();
			//find element and click (this link open in a new tab as site is configured to oprn the link in a new tab)
			driver.findElement(
					By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/div[3]/div[2]/div[4]/div/div[1]/div/li[2]/div/a"))
					.click();
			Set<String> wdHandles = driver.getWindowHandles();
			System.out.println(wdHandles);
			// close current window
			// driver.close();
			// close multiple window
			 driver.quit();
		}
	}

}
