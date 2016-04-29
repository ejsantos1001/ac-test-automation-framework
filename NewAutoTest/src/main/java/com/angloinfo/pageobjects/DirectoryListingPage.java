package com.angloinfo.pageobjects;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class DirectoryListingPage {
	WebDriver driver;
	WebElement listingTitle;

	
		public DirectoryListingPage(WebDriver driver) {
			this.driver = driver;
		}
		
		public void goToListing(String url) {
			driver.get(url);
			
		}
		
		public String getListingTitle() {
			listingTitle = driver.findElement(By.xpath("//div[@id='list-result']/h1"));
			return listingTitle.getText();
		}
		
		
}
