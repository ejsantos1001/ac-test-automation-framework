package com.angloinfo.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FELoginPage {
	String route = "/member/signin";
	WebDriver driver;
	WebElement emailfield;
	WebElement passwordfield;
	WebElement loginbutton;
	WebElement forgotdetailsbutton;
	
	public FELoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void goToPage(String baseurl) {
		driver.get(baseurl+route);
	}
	
	public void inputEmail(String email) {
		emailfield = driver.findElement(By.id("formEmail"));
		emailfield.sendKeys(email);
	}
	
	public void inputPassword(String password) {
		passwordfield = driver.findElement(By.id("formPassword"));
		passwordfield.sendKeys(password);
	}
	
	public void clickLogin() {
		loginbutton = driver.findElement(By.xpath("//button[@type='submit']"));
		loginbutton.click();
		
	}
	
	public  String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
	
	public void clickForgotDetails() {
		forgotdetailsbutton = driver.findElement(By.xpath(".//*[@id='form-signin']/div[5]/span/a"));
		forgotdetailsbutton.click();
	}

}