package com.angloinfo.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GlobalHomePage {
	
	
	public GlobalHomePage(WebDriver driver){
		this.driver = driver;	
	}
	
	WebDriver driver;
	
	
	 public void clickSignIn () {
		driver.findElement(By.id("myangloDropdownToggle")).click();
	}

}
