package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {
	private static WebElement element = null;
	
	public static WebElement firstSearch(WebDriver driver){
		element = driver.findElement(By.id("c24-search-header"));
		return element;
	}
	
	public static WebElement secondSearch(WebDriver driver){
		element = driver.findElement(By.id("query"));
		return element;
	}
}
