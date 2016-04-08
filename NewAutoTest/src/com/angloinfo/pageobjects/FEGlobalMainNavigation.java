package com.angloinfo.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FEGlobalMainNavigation {
	
	WebDriver driver;
	WebElement regionLink;
	WebElement franchisingLink;
	WebElement advertisingLink;
	WebElement aboutAngloInfoLink;
	WebElement blogsLink;
	
	public FEGlobalMainNavigation(WebDriver driver) {
	this.driver = driver;
	}
	
	public void clickregionsLink() {
		regionLink = driver.findElement(By.xpath("//a[contains(text(),'Regions')]"));
		regionLink.click();
		
	}
	
	public void clickFranchisingLink() {
		franchisingLink = driver.findElement(By.xpath("//a[contains(text(),'Franchising')]"));
		franchisingLink.click();
	}
	
	public void clickAdvertisingLink() {
		advertisingLink = driver.findElement(By.xpath("//a[contains(text(),'Advertising')]"));
		advertisingLink.click();
	}
	
	public void clickAboutAngloInfoLink() {
		aboutAngloInfoLink = driver.findElement(By.xpath("//a[contains(text(),'Advertising')]"));
		aboutAngloInfoLink.click();
	}
	
	public void clickBlogs() {
		blogsLink = driver.findElement(By.xpath("//a[contains(text(),'Blogs')]"));
		blogsLink.click();
	}
	

}
