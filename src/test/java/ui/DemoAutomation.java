package ui;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoAutomation {

	public static void main(String[] args) {
		//run your test in chrom dirver
		//chrome driver: webdriver.chrome.driver
//		System.setProperty("webdriver.chrome.driver", "D:\\Kirti\\Selenium\\Browser_Drivers\\chromedriver.exe");
		//using webdriver manager NO NEED FOR DOWNLOADING  driver for browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		//edge driver: webdriver.edge.driver
//		System.setProperty("webdriver.edge.driver", "D:\\Kirti\\Selenium\\Browser_Drivers\\msedgedriver.exe");
//		EdgeDriver driver = new EdgeDriver();

//		driver.get("http://www.google.com");
		driver.get("http://www.amazon.ca");
		driver.manage().window().maximize();
		// id for text box twotabsearchtextbox
		driver.findElementById("twotabsearchtextbox").sendKeys("flowers");
		//submit button nav-search-submit-button
		driver.findElementById("nav-search-submit-button").click();

		
	}

}
