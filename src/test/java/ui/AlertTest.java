package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertTest {

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
			driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_prompt");
			driver.manage().window().maximize();
			//switch to the frame on right side
			driver.switchTo().frame("iframeResult");
			//tryit button  --- This will oprn alrt boc
			driver.findElement(By.xpath("/html/body/button")).click();
			
			//handle Alert
			//get the test
			String alertText = driver.switchTo().alert().getText();
			driver.switchTo().alert().sendKeys("Kirti"); //This will type the value in a text box of popup altert 
			try {
				Thread.sleep(2000);
				//accet the alert (similar as ' OK' button
				driver.switchTo().alert().accept();
				
				//to dismis/cancel the alertbox
				//driver.switchTo().alert().dismiss();
				System.out.println("AlertText"+alertText);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
		}
	}

}
