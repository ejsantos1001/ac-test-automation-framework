package com.angloinfo.pageobjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class CmsManageDirectoryPage {
	String route = "/directory" ;
	WebElement  locationswitcher;
	WebElement  locationselection;
	WebDriver driver;

	
		public CmsManageDirectoryPage(WebDriver driver) {	
			this.driver = driver;
		}
		
		public void  goToPage(String baseurl) {
			driver.get(baseurl + route);
		}
	
		
	
}
