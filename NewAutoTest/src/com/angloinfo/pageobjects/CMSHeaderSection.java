package com.angloinfo.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import com.angloinfo.tools.TimingTools;

public class CMSHeaderSection {

	WebDriver driver;
	WebElement locationswitcher; 
	WebElement locationselection;
	
	public CMSHeaderSection(WebDriver driver){
		this.driver = driver;	
	}
	
	public void switchLocation() {
		
		TimingTools.defeatSpinner(driver);
		Actions actions = new Actions(driver);
		locationswitcher = driver.findElement(By.xpath("//a[contains(text(),'global')]"));
		actions.moveToElement(locationswitcher).click().perform();
		locationselection = driver.findElement(By.xpath("//a[contains(text(),'Algarve')]"));
		locationselection.click();
		TimingTools.defeatSpinner(driver);
		
	}
}
