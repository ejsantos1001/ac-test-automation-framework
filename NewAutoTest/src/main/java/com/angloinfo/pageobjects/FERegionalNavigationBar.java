package com.angloinfo.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FERegionalNavigationBar {
	WebDriver driver;
	WebElement directoryLink;
	WebElement classifiedsLink;
	WebElement discussionsLink;
	WebElement eventsLink;
	WebElement howToLink;
	WebElement jobsLink;
	WebElement propertyLink;
	WebElement blogsLink;
	
	
	public FERegionalNavigationBar(WebDriver driver) {
		this.driver = driver;
		
	}
	
	public void clickDirectoryLink() {
		directoryLink = driver.findElement(By.xpath("//a[contains(text(),'Directory')]"));
		directoryLink.click();
	}
	
	public void clickClassifiedsLink() {
		classifiedsLink = driver.findElement(By.xpath("//a[contains(text(),'Classifieds')]"));
		classifiedsLink.click();
	}
	public void clickDiscussionsLink() {
		discussionsLink = driver.findElement(By.xpath("//a[contains(text(),'Discussions')]"));
		discussionsLink.click();
	}
	
	public void clickEventsLink() {
		eventsLink = driver.findElement(By.xpath("//a[contains(text(),'Events')]"));
		eventsLink.click();
	}
	
	public void clickHowToLink() {
		howToLink = driver.findElement(By.xpath("//a[contains(text(),'How To')]"));
		howToLink.click();
		
	}
	
	public void clickJobsLink() {
		jobsLink = driver.findElement(By.xpath("//a[contains(text(),'Events')]"));
		jobsLink.click();
	}
	public void clickPropertyLink() {
		propertyLink = driver.findElement(By.xpath("xpath=(//a[contains(text(),'Property')])[6]"));
		propertyLink.click();
	}
	public void clickBlogs() {
		blogsLink = driver.findElement(By.xpath("xpath=(//a[contains(text(),'Blogs')])[2]"));
		blogsLink.click();
	}
	
	
}
