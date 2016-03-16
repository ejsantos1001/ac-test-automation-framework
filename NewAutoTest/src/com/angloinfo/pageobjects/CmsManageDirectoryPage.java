package com.angloinfo.pageobjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.angloinfo.data.DirectoryListing;
import com.angloinfo.tools.TimingTools;


public class CmsManageDirectoryPage {
	String route = "/directory" ;
	WebElement  locationswitcher;
	WebElement  locationselection;
	WebElement  contentbutton;
	WebElement  directoryselection;
	WebElement  category;
	WebElement  subcategory;
	WebElement  addlistingbutton;
	WebElement  directorynamefield;
	WebElement  slugbutton;
	WebElement  contentfield1;
	WebElement  savechangesbutton;
	WebDriver driver;

	
		public CmsManageDirectoryPage(WebDriver driver) {	
			this.driver = driver;
		}
		
		public void  goToPage(String baseurl) {
			driver.get(baseurl + route);
		}
	
		public void addDirectoryListing(DirectoryListing dl) {

			TimingTools.defeatSpinner(driver);
			category = driver.findElement(By.xpath("//ul[@id='children-of-0']/li/a/span[2]"));
			category.click();
			subcategory = driver.findElement(By.xpath("//ul[@id='children-of-14927']/li/a/span[3]"));
			subcategory.click();
			TimingTools.defeatSpinner(driver);
			addlistingbutton = driver.findElement(By.xpath("//th[6]/span/button"));
			addlistingbutton.click();
			directorynamefield = driver.findElement(By.xpath(".//*[@id='name']"));
			directorynamefield.clear();
			directorynamefield.sendKeys(dl.getName());
			slugbutton = driver.findElement(By.xpath(".//*[@id='listing-detail-form']/div[2]/div/div[1]/span[2]/button"));
			slugbutton.click();
			contentfield1 = driver.findElement(By.xpath(".//*[@id='listing_html_editor']/div[2]/div[4]/div[4]"));
			contentfield1.sendKeys(dl.getDescription());
			savechangesbutton = driver.findElement(By.xpath(".//*[@id='ai-content']/div/div[1]/div/div/div/div[2]/div/div/div[1]/div[1]/div[2]/div[2]/center/button"));
			savechangesbutton.click();
		}
	
}
