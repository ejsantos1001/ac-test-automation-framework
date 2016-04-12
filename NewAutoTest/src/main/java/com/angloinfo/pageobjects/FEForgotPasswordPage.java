package com.angloinfo.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FEForgotPasswordPage {
	
	WebDriver driver;
	WebElement emailaddressfield;
	WebElement sendpasswordresetlink;
	
	public FEForgotPasswordPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void sendResetPasswordLink(String email) {
		emailaddressfield = driver.findElement(By.xpath("//input[@id='formEmail']"));
		emailaddressfield.sendKeys(email);
		sendpasswordresetlink = driver.findElement(By.xpath("//button[@type='submit']"));
		sendpasswordresetlink.click();
	}
}
