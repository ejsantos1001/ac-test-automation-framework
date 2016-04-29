package com.angloinfo.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class FEMyAngloInfoNavi {
WebDriver driver;
WebElement myAngloInfoNavi;
WebElement settingsLink;
	
	public FEMyAngloInfoNavi(WebDriver driver) {
		this.driver = driver;
	}
	
	public	void navigateToSettings() {
		myAngloInfoNavi = driver.findElement(By.xpath("//a[@id='myangloDropdownToggle']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(myAngloInfoNavi).perform();
		settingsLink = driver.findElement(By.xpath("//a[contains(text(),'Settings')]"));
		settingsLink.click();
		
	}
	
}
