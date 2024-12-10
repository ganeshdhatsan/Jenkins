package Runner;

import org.testng.annotations.Test;

import PageObjectManager.PageManager;
import Utilities.TestUtilities;

public class TestRunnerUsingPageObjectManager extends TestUtilities{
	
	
	@Test
	private void validateLoginType2() throws InterruptedException {
		browserLaunch();
		launchUrl("https://www.facebook.com/");
	    implicitWait();
	    PageManager.getInstance().loginPage2.performLogin("java", "selenium");
	}
	


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
