package register;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageobjects.Check24;
import pageobjects.LoginPage;
import pageobjects.RegisterPage;
import utility.UtilFunctions;

public class RegisterUser {
	 public static WebDriver driver =null;
	 public static UtilFunctions util = new UtilFunctions();
	 
	 
	 @DataProvider(name = "Datainput")
	 public static Object[][] dataInput() {
		 //generate random number to create a random user name and password
		 int randomNumber1 = util.generateRandomNumber();
		 String email = "user"+randomNumber1+"@example.com";
		 String password = "user"+randomNumber1;
		 
		 //The test will run 4 times with 1 Success and 3 Failure cases
		 return new Object[][] { { email, password,"OK" },{"user1234","user1234","NOK"},{"user1234@example.com","user","NOK"},{email,password,"NOK"}};
	}
	 
	 @Test(priority = 0,groups= {"Smoke Testing"})
	 @Parameters({"browserType"})
	 public void selectBrowser(String browserType) throws MalformedURLException {
		 //call utility function to select the browser
		 driver = util.selectBrowser(browserType);
		 
	  }
	 
	 @Test(priority = 1, dependsOnMethods = {"selectBrowser"}, groups= {"Smoke Testing"},dataProvider = "Datainput")
	 public void userRegistration(String sEmail, String sPassword, String Status) throws InterruptedException {
		 //call utility function to open the url
		 util._openBrowser(driver); 
		 Thread.sleep(10000);
		 try
		 {
			 driver.findElement(By.xpath("//a[@class='c24-cookie-button']")).click();
			 System.out.println("handled accept cookies notification");
		 }
		 catch (Exception E1)
		 {
			 System.out.println(E1);
		 }
		 
		 
		 //Navigate to registration page
		 Check24.register(driver).click();
		 LoginPage.newCustomer(driver).click();
		  
		 //Register the user
		 RegisterPage.email(driver).sendKeys(sEmail);
		 RegisterPage.password(driver).sendKeys(sPassword);
		 RegisterPage.passwordRepetition(driver).sendKeys(sPassword);
		 RegisterPage.register(driver).click();
		 Thread.sleep(5000);
		 
		 if(Status=="OK")
		 {
			 WebElement element = driver.findElement(By.xpath("//*[@id='c24-meinkonto-anmelden']"));
			 String sTxt = element.getText();
			 System.out.println(sTxt);
			 driver.findElement(By.xpath("//div[@class='c24-customer-check']//a")).click();
			 System.out.println("Signed out");
		 }
		 
		 //Call utility function to close the browser
		 util._closeBrowser(driver); 
	 }
	  @BeforeClass
	  public void beforeClass() {
		  Reporter.log("Start of RegisterUser Class");
	  }

	  @AfterClass
	  public void afterClass() {
		  Reporter.log("End of RegisterUser Class");
	  }

	  @BeforeSuite
	  public void beforeSuite() {
		  Reporter.log("-------- Start of Test Scenario 1: TS_Check_001 -----------");
	  }

	  @AfterSuite
	  public void afterSuite() {
		  Reporter.log("--------- End of Test Scenario 1: TS_Check_001 ------------");
	  }

}
