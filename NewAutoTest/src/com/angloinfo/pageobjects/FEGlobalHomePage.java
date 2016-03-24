package com.angloinfo.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FEGlobalHomePage {
	WebDriver driver;
	
	public FEGlobalHomePage(WebDriver driver){
		this.driver = driver;	
	}

	public void clickSignIn () {
		driver.findElement(By.id("myangloDropdownToggle")).click();
	}
	
	public void goToPage(String baseUrl) {
		driver.get(baseUrl + "/");
	}
	
	public void switchLocation() {
		
		driver.findElement(By.id("location_search_input")).sendKeys("zurich");
	    driver.findElement(By.linkText("Zurich, Switzerland")).click();
	    driver.findElement(By.id("location_switcher")).click();
	}
	
}
