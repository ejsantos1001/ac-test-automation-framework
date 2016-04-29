package com.angloinfo.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ClassifiedsListingPage {

		WebDriver driver;
		WebElement enquirebutton;
		WebElement messagebox;
		WebElement firstnamefield;
		WebElement lastnamefield;
		WebElement sendbutton;
		
		public ClassifiedsListingPage(WebDriver driver) {
			this.driver = driver;
		}
		
		public void goToListing(String febaseurl,String listingurl) {
			this.driver.get(febaseurl+listingurl);
			
		}
		
		public void enquire(String message) {
			enquirebutton = driver.findElement(By.xpath("//a[contains(text(),'Enquire Now')]"));
			enquirebutton.click();
			messagebox = driver.findElement(By.xpath("//textarea[@name='message']"));
			messagebox.sendKeys(message);
			sendbutton = driver.findElement(By.xpath("//button[@type='submit']"));
			sendbutton.click();
			
		}
		
		
		
}
