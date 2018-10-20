package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage {
	private static WebElement element = null;
	
	public static WebElement email(WebDriver driver){
		element = driver.findElement(By.id("email"));
		return element;
	}
	public static WebElement password(WebDriver driver){
		element = driver.findElement(By.id("password"));
		return element;
	}
	public static WebElement passwordRepetition(WebDriver driver){
		element = driver.findElement(By.id("passwordrepetition"));
		return element;
	}
	public static WebElement register(WebDriver driver){
		element = driver.findElement(By.id("c24-kb-btn"));
		return element;
	}

}
