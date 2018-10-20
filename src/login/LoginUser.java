package login;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
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
import utility.UtilFunctions;

public class LoginUser {
	 public static WebDriver driver =null;
	 public UtilFunctions util = new UtilFunctions();
	 
	 @DataProvider(name = "Credentials")
	 public static Object[][] credentials() {
		 //The test will run 4 times with 1 Success and 3 Failure cases
		 return new Object[][] { { "user1234@example.com", "user1234" },{"user1234","user"},{"user1234","user1234"},{"user1234@example.com","user"}};
	}
	 
	 @Test(priority = 0,groups= {"Smoke Testing"})
	 @Parameters({"browserType"})
	 public void selectBrowser(String browserType) throws MalformedURLException {
		 //call utility function to select the browser
		 driver = util.selectBrowser(browserType);
		 
	  }
	 
	 @Test(priority = 1, dependsOnMethods = {"selectBrowser"}, groups= {"Smoke Testing"},dataProvider = "Credentials")
	 public void userLogin(String sEmail, String sPassword) {
		 //Call the utility function to open the url
		 util._openBrowser(driver);
		 
		 //Navigate to the login page and login
		 Check24.register(driver).click();
		 LoginPage.email(driver).sendKeys(sEmail);
		 LoginPage.password(driver).sendKeys(sPassword);
		 LoginPage.register(driver).click();
		 
		 //Call the utility function to close the browser
		 util._closeBrowser(driver); 

	 }
	  @BeforeClass
	  public void beforeClass() {
		  Reporter.log("Start of LoginUser Class");
	  }

	  @AfterClass
	  public void afterClass() {
		  Reporter.log("End of LoginUser Class");
	  }

	  @BeforeSuite
	  public void beforeSuite() {
		  Reporter.log("-------- Start of Test Scenario 2: TS_Check_002 -----------");
	  }

	  @AfterSuite
	  public void afterSuite() {
		  Reporter.log("--------- End of Test Scenario 2: TS_Check_002 ------------");
	  }


}
