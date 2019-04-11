package utility;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Reporter;

public class UtilFunctions {
	        //1. Function to select the web browser to run the test case
			public WebDriver selectBrowser(String browserType) {
				if(browserType.equals("Firefox")) {
					  //Set the system property to point to gecko driver
					  System.setProperty("webdriver.gecko.driver", "C:\\mozilladriver\\geckodriver.exe");	
					  
					  //Create a new instance of the Firefox driver
					  WebDriver driver = new FirefoxDriver();
					  return driver;
				  }
				return null;
			}
			
			//2. Function to open the webpage in the web browser
			public void _openBrowser(WebDriver driver) {
				  //Put a Implicit wait, this means that any search for elements on the page could take the time the implicit wait is set for before throwing exception
			      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			      
			      //Maximize the window
				  driver.manage().window().maximize();
				  
			      //Launch collaborator
			      driver.get("https://www.check24.de/");
			      
			}
			//3. Function to close the web browser
			public void _closeBrowser(WebDriver driver) {
				  // Close the driver
				  driver.quit();
				  Reporter.log("Browser closed");
				  
			}
			//4. Function to generate Random Number
			public int generateRandomNumber() {
				  Random rand = new Random();
				  int randomNum = rand.nextInt(100000);
				  return randomNum;
		    }
			

}
