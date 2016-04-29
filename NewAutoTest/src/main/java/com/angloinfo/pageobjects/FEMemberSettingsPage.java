package com.angloinfo.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FEMemberSettingsPage {
WebDriver driver;
WebElement firstNameField;
WebElement lastNameField;
WebElement updateProfile;
	
	public FEMemberSettingsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void goToPage(String baseurl) {
		
	}
	
	public void updateProfileName(String firstname,String lastname) {
		firstNameField = driver.findElement(By.xpath("//input[@id='firstName']"));
		firstNameField.clear();
		firstNameField.sendKeys(firstname);
		lastNameField = driver.findElement(By.xpath("//input[@id='lastName']"));
		lastNameField.clear();
		lastNameField.sendKeys(lastname);
		updateProfile = driver.findElement(By.xpath("//button[@type='submit']"));
		updateProfile.click();
		
	}
	
	public String getFirstName(){
		return firstNameField.getText();
	}
	
	public String getLastName() {
		return lastNameField.getText();
	}
	
	
	
}
