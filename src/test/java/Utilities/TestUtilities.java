package Utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestUtilities {

	public static WebDriver driver;

	public void browserLaunch() {
		driver = new ChromeDriver();
	}

	public void launchUrl(String url) {
		driver.get(url);
	}

	public void implicitWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	public String getDomValue(WebElement element) {
		String domAttribute = element.getDomAttribute("value");
		return domAttribute;
	}

	public void quit() {
		driver.quit();
	}

	public void close() {
		driver.close();
	}

	// Create driver using Thread local instance
	public static WebDriver createWebDriver() {
		String webdriver = System.getProperty("browser", "firefox"); // Use "browser" system property
		switch (webdriver) {
		case "firefox":
			return new FirefoxDriver();
		case "chrome":
			return new ChromeDriver();
		default:
			throw new RuntimeException("Unsupported webdriver: " + webdriver);
		}
	}

	public static WebDriver createWebDriver1(String driver) {
		switch (driver) {
		case "firefox":
			return new FirefoxDriver();
		case "chrome":
			return new ChromeDriver();
		default:
			throw new RuntimeException("Unsupported webdriver: " + driver);
		}
	}

	public static void launchBrowser() {
		System.setProperty("browser", "chrome"); // Choose browser dynamically
		WebDriver driver = createWebDriver(); // Returns the specified driver
		driver.get("https://www.example.com");
		driver.quit();
	}

	// Generic method to locate elements dynamically
	public WebElement getElement(String locatorType, String locatorValue) {
		switch (locatorType.toLowerCase()) {
		case "id":
			return driver.findElement(By.id(locatorValue));
		case "name":
			return driver.findElement(By.name(locatorValue));
		case "xpath":
			return driver.findElement(By.xpath(locatorValue));
		case "css":
			return driver.findElement(By.cssSelector(locatorValue));
		case "class":
			return driver.findElement(By.className(locatorValue));
		case "tag":
			return driver.findElement(By.tagName(locatorValue));
		case "linktext":
			return driver.findElement(By.linkText(locatorValue));
		case "partiallinktext":
			return driver.findElement(By.partialLinkText(locatorValue));
		default:
			throw new IllegalArgumentException("Invalid locator type: " + locatorType);
		}
	}

	public WebElement getElementBy(String locatorType, By locatorValue) {
		switch (locatorType.toLowerCase()) {
		case "id":
			return driver.findElement(locatorValue);
		case "name":
			return driver.findElement(locatorValue);
		case "xpath":
			return driver.findElement(locatorValue);
		case "css":
			return driver.findElement(locatorValue);
		case "class":
			return driver.findElement(locatorValue);
		case "tag":
			return driver.findElement(locatorValue);
		case "linktext":
			return driver.findElement(locatorValue);
		case "partiallinktext":
			return driver.findElement(locatorValue);
		default:
			throw new IllegalArgumentException("Invalid locator type: " + locatorType);
		}
	}

//    // Example method to interact with dynamic elements
//    public void clickElement(String locatorType, String locatorValue) {
//        getElementByDynamicLocator(locatorType, locatorValue).click();
//    }
//
//    public void enterText(String locatorType, String locatorValue, String text) {
//        getElementByDynamicLocator(locatorType, locatorValue).sendKeys(text);
//    }
//
//    public String getElementText(String locatorType, String locatorValue) {
//        return getElementByDynamicLocator(locatorType, locatorValue).getText();
//    }

}
