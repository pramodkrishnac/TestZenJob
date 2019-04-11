package search;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageobjects.SearchPage;
import utility.UtilFunctions;

public class SearchItem {
	public static WebDriver driver =null;
	 public static UtilFunctions util = new UtilFunctions();
	 
	 @Test(priority = 0,groups= {"Smoke Testing"})
	 @Parameters({"browserType"})
	 public void selectBrowser(String browserType) throws MalformedURLException {
		 //call utility function to select the browser
		 driver = util.selectBrowser(browserType);
		 }

@Test(priority = 1, dependsOnMethods = {"selectBrowser"}, groups= {"Smoke Testing"})
public void searchItems() throws InterruptedException {
	 //call utility function to open the url
	 util._openBrowser(driver);
	 
	 	 
	 //Search for an available item
	 SearchPage.firstSearch(driver).sendKeys("logitech g29");
	 SearchPage.firstSearch(driver).submit();
	 
	 Assert.assertFalse(driver.getPageSource().contains("Keine Ergebnisse"),"Item not found!");
	 
	 //Clear the text from search field
	 Thread.sleep(5000);
	 SearchPage.secondSearch(driver).sendKeys(Keys.CONTROL,"a");
	 Thread.sleep(2000);
	 SearchPage.secondSearch(driver).sendKeys(Keys.BACK_SPACE);
	 Thread.sleep(5000);
	 
	//Search for an non-available item
	 SearchPage.secondSearch(driver).sendKeys("lllbl");
	 Thread.sleep(2000);
	 SearchPage.secondSearch(driver).sendKeys(Keys.ENTER);
	 Thread.sleep(5000);
	 WebElement element = driver.findElement(By.xpath("//div[@id='search-page']//h1"));
	 String sTxt = element.getText();
	 System.out.println(sTxt);
	 
	 Assert.assertTrue(sTxt.contains("Keine Ergebnisse für \"lllbl\""),"Item not found as expected!");
	 //Call utility function to close the browser
	 util._closeBrowser(driver); 
}
 @BeforeClass
 public void beforeClass() {
	  Reporter.log("Start of SearchItem Class");
 }

 @AfterClass
 public void afterClass() {
	  Reporter.log("End of SearchItem Class");
 }

 @BeforeSuite
 public void beforeSuite() {
	  Reporter.log("-------- Start of Test Scenario 2: TS_Search_1 -----------");
 }

 @AfterSuite
 public void afterSuite() {
	  Reporter.log("--------- End of Test Scenario 2: TS_Search_1 ------------");
 }
}
