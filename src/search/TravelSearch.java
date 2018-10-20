package search;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageobjects.Check24;
import pageobjects.TravelPage;
import utility.UtilFunctions;

public class TravelSearch {
	 public static WebDriver driver =null;
	 public static UtilFunctions util = new UtilFunctions();
	 
	 @Test(priority = 0,groups= {"Smoke Testing"})
	 @Parameters({"browserType"})
	 public void selectBrowser(String browserType) throws MalformedURLException {
		 //call utility function to select the browser
		 driver = util.selectBrowser(browserType);
		 
	  }
	 
	 @Test(priority = 1, dependsOnMethods = {"selectBrowser"}, groups= {"Smoke Testing"})
	 public void userRegistration() {
		 //call utility function to open the url
		 util._openBrowser(driver);
		 
		 //Navigate to travel page
		 Actions action = new Actions(driver);
		 action.moveToElement(Check24.mainMenu(driver)).build().perform();
		 
		 Check24.travel(driver).click();
		 
		 //Enter the travel details
		 TravelPage.travelDestination(driver).click();
		 TravelPage.travelListItem(driver).click();
		 
		 TravelPage.travelAirport(driver).click();
		 TravelPage.travelListItem(driver).click();
		 
		 TravelPage.travelDeparture(driver).click(); 
		 TravelPage.travelArrival(driver).click();
		 
		 TravelPage.travelDuration(driver).click();
		 TravelPage.travelDurationValue(driver).click();
		 
		 TravelPage.travelSearch(driver).click();
		 
		 //Call utility function to close the browser
		 //util._closeBrowser(driver); 
	 }
	  @BeforeClass
	  public void beforeClass() {
		  Reporter.log("Start of TravelSearch Class");
	  }

	  @AfterClass
	  public void afterClass() {
		  Reporter.log("End of TravelSearch Class");
	  }

	  @BeforeSuite
	  public void beforeSuite() {
		  Reporter.log("-------- Start of Test Scenario 3: TS_Search_001 -----------");
	  }

	  @AfterSuite
	  public void afterSuite() {
		  Reporter.log("--------- End of Test Scenario 3: TS_Search_001 ------------");
	  }


}
