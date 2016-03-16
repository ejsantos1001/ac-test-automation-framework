package com.angloinfo.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


import com.angloinfo.tools.TimingTools;


public class CMSLoginPage {
	
	WebDriver driver;
	WebElement emailfield; 
	WebElement passwordfield;
	WebElement loginbutton;
	WebElement locationswitcher; 
	WebElement locationselection;
	
	public CMSLoginPage(WebDriver driver){
		this.driver = driver;	
	}
	
	public void goToPage(String baseurl) {
		this.driver.get(baseurl);
	}
	
	public void typeEmail(String cmsuseremail) {
		emailfield = driver.findElement(By.id("email"));
		emailfield.sendKeys(cmsuseremail);
	}
	
	public void typePassword(String cmspassword) {
		passwordfield = driver.findElement(By.id("password"));
		passwordfield.sendKeys(cmspassword);
	}
	
	public void clickLogin() {
		loginbutton = driver.findElement(By.xpath("//button[@type='submit']"));
		loginbutton.click();
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

