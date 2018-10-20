package pageobjects;




import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Check24 {
	private static WebElement element = null;
	
	public static WebElement register(WebDriver driver){
		element = driver.findElement(By.className("c24-meinkonto-reflink"));
		return element;
	}
	public static WebElement mainMenu(WebDriver driver){
		element = driver.findElement(By.className("c24-nav-button"));
		return element;
	}
	
	public static WebElement travel(WebDriver driver){
		List<WebElement> elements = driver.findElements(By.className("c24-mainnav-ele-title"));
		for (WebElement we : elements) {
		    if (we.getAttribute("title") != null) {
		            if (we.getAttribute("title").equals("Reise & Flug")) {
		            	    element = we;
		                    break;
		            }
		    }

		}
		return element;
				
	}
	

}
