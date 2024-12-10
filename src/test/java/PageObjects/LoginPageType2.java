package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Utilities.TestUtilities;

public class LoginPageType2 extends TestUtilities{

	/**
	 * without page factory
	 *
	 */

	
	By usernameLocator = By.xpath("//input[@id='email']");
	By passwordLocator = By.xpath("//input[@id='pass']");
	By loginButtonLocator = By.xpath("//button[@name='login']");
	By forgetPassLocator = By.linkText("Forgotten password?");
	By fingUserLocator = By.id("identify_email");
	By cancelLocator = By.xpath("//a[text()='Cancel']");
	By searchLocator = By.xpath("//button[@id='did_submit']");


	/////////////////////////////////////////////////

	public void performLogin(String user,String pass) {
		driver.findElement(usernameLocator).sendKeys(user);
		driver.findElement(passwordLocator).sendKeys(pass);
		driver.findElement(loginButtonLocator).click();

	}

	
}
