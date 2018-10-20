package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TravelPage {
private static WebElement element = null;
	
	public static WebElement travelDestination(WebDriver driver){
		element = driver.findElement(By.id("c24-travel-destination-element"));
		return element;
	}
	public static WebElement travelListItem(WebDriver driver){
		int i=0;
		List<WebElement> elements = driver.findElements(By.className("c24-travel-list-item"));
		for (WebElement we : elements) {
			if(i==1) {
				element = we;
				break;
			}
			i++;
		}
		return element;
				
	}
	public static WebElement travelAirport(WebDriver driver){
		element = driver.findElement(By.id("c24-travel-airport-element"));
		return element;
	}
	public static WebElement travelDeparture(WebDriver driver){
		element = driver.findElement(By.cssSelector("div.c24-travel-tablet-input-overlay.c24-travel-empty"));
		return element;
	}
	public static WebElement travelArrival(WebDriver driver){
		element = driver.findElement(By.cssSelector(".c24-travel-end-date-field .c24-travel-tablet-input-overlay"));
		return element;
	}
	public static WebElement travelDuration(WebDriver driver){
		element = driver.findElement(By.cssSelector("div.c24-travel-duration-overlay.c24-travel-js-open-duration-layer"));
		return element;
	}
	
	public static WebElement travelDurationValue(WebDriver driver){
		element = driver.findElement(By.cssSelector("span.c24-travel-radio-wrapper.c24-travel-spacer-wrapper > label"));
		return element;
	}
	public static WebElement travelSearch(WebDriver driver){
		element = driver.findElement(By.id("c24-travel-search-button-element"));
		return element;
	}
	

}
