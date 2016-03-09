package com.angloinfo.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GlobalHomePage {
	WebDriver driver;
	
	public GlobalHomePage(WebDriver driver){
		this.driver = driver;	
	}

	public void clickSignIn () {
		driver.findElement(By.id("myangloDropdownToggle")).click();
	}

}
