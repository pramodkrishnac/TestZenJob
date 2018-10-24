package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TravelSearchResult {
	private static WebElement element = null;
	public static WebElement searchList(WebDriver driver){
		int i=0;
		List<WebElement> elements = driver.findElements(By.linkText("zu den Angeboten »"));
		for (WebElement we : elements) {
			if(i==0) {
				element = we;
				break;
			}
			i++;
		}
		return element;
				
	}

}
