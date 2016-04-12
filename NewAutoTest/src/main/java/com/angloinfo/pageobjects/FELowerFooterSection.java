package com.angloinfo.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FELowerFooterSection {
WebDriver driver;


	public FELowerFooterSection(WebDriver driver) {
		this.driver = driver;	
	}
	
	public void clickPrivacyPolicyLink() {
		driver.findElement(By.xpath("//div[@id='footer-bottom']/div/div/a")).click();
	}
	
	public void clickTermsOfUserLink() {
		driver.findElement(By.xpath("//div[@id='footer-bottom']/div/div/a[2]")).click();
	}
	
	public void clickSafeInternetPolicyLink() {
		driver.findElement(By.xpath("//div[@id='footer-bottom']/div/div/a[3]")).click();
	}
	
	public void clickCookiesLink() {
		driver.findElement(By.xpath("//div[@id='footer-bottom']/div/div/a[4]")).click();
	}
	
	public void clickSiteMapLink() {
		driver.findElement(By.xpath("//div[@id='footer-bottom']/div/div/a[5]")).click();
	}
	
}



