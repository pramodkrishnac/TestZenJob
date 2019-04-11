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
		

}
