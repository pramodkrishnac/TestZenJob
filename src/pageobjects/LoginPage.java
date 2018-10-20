package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	private static WebElement element = null;
	
	public static WebElement newCustomer(WebDriver driver){
		element = driver.findElement(By.id("new_customer"));
		return element;
	}
	public static WebElement email(WebDriver driver){
		element = driver.findElement(By.id("email"));
		return element;
	}
	public static WebElement password(WebDriver driver){
		element = driver.findElement(By.id("password"));
		return element;
	}
	public static WebElement register(WebDriver driver){
		element = driver.findElement(By.id("c24-kb-register-btn"));
		return element;
	}

}
