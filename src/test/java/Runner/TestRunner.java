package Runner;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import TestReporter.ExtentReporter;
import Utilities.TestUtilities;

public class TestRunner extends TestUtilities {

	ExtentReporter report = new ExtentReporter();

	@BeforeClass
	public void setUp() {
		// Initialize WebDriver
		driver = new ChromeDriver();
//		Utilities.driver = driver; // Assign the driver to the Screenshot class
//		report.testName("validate Login with Valid Credentials");

	}

	@Test
	public void validateLoginwithValidCredentials() throws IOException, InterruptedException {
		report.testName("validate Login with Valid Credentials");
		driver.get("https://www.facebook.com/");
		Thread.sleep(1000);
		report.addScreenShot("Navigated to Facebook", "pass");
		driver.findElement(By.id("email")).sendKeys("ganesh");
		Thread.sleep(1000);
		report.addScreenShot("Entered email", "pass");
		driver.findElement(By.id("pass")).sendKeys("kumar");
		Thread.sleep(1000);
		report.addScreenShot("Entered password", "pass");

	}

	@AfterMethod
	private void method() throws IOException {
		report.flushReport();
	}

	@AfterClass
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

}
