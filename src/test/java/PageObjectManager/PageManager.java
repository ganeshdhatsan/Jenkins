package PageObjectManager;

import PageObjects.LoginPageType2;

public class PageManager {
	// define a page object manager class as Singleton class
	
	// rule -01 - private static variable
	private static PageManager pageManager;
	
	
	public LoginPageType2 loginPage2;
	
	
	// rule-02 -private constructor for current class
	private PageManager() {
		loginPage2= new LoginPageType2();
	}
	
	// rule-03-public static method 
     public static PageManager getInstance() {
		if(pageManager==null) {
			 pageManager= new PageManager();
		}
       return pageManager;
	}
	
	
}
