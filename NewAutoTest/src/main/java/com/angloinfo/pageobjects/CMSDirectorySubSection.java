package com.angloinfo.pageobjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.angloinfo.data.DirectoryListing;
import com.angloinfo.tools.TimingTools;


public class CMSDirectorySubSection {
	
	String route = "/directory" ;
	WebDriver driver;
	WebElement  locationswitcher;
	WebElement  locationselection;
	WebElement  contentbutton;
	WebElement  directoryselection;
	WebElement  category; 
	WebElement  subcategory; 
	WebElement  addlistingbutton; 
	WebElement  directorynamefield ;
	WebElement  contentfield1;
	WebElement  savechangesbutton ;
	WebElement  slugbutton;
	WebElement  pageUrl;
	String pageUrlText;
	
	

	
	
		public CMSDirectorySubSection(WebDriver driver) {	
			this.driver = driver;
			
		}
		
		public void  goToPage(String baseurl) {
			driver.get(baseurl + route);
		}
	
		public void addDirectoryListing(DirectoryListing dl) {

			
			TimingTools.defeatSpinner(driver);
			this.category = driver.findElement(By.xpath("//ul[@id='children-of-0']/li/a/span[2]"));
			this.category.click();
			this.subcategory = driver.findElement(By.xpath("//ul[@id='children-of-14927']/li/a/span[3]"));
			this.subcategory.click();
			TimingTools.defeatSpinner(driver);
			this.addlistingbutton = driver.findElement(By.xpath("//th[6]/span/button"));
			this.addlistingbutton.click();
			this.directorynamefield = driver.findElement(By.xpath(".//*[@id='name']"));
			this.directorynamefield.clear();
			this.directorynamefield.sendKeys(dl.getName());
			this.slugbutton = driver.findElement(By.xpath("//form[@id='listing-detail-form']/div[2]/div/div/span[2]/button"));
			this.slugbutton.click();
			this.contentfield1 = driver.findElement(By.xpath(".//*[@id='listing_html_editor']/div[2]/div[4]/div[4]"));
			this.contentfield1.sendKeys(dl.getDescription());
			this.savechangesbutton = driver.findElement(By.xpath(".//*[@id='ai-content']/div/div[1]/div/div/div/div[2]/div/div/div[1]/div[1]/div[2]/div[2]/center/button"));
			this.savechangesbutton.click();
			pageUrl = driver.findElement(By.xpath("//div[@id='ai-content']/div/div/div/div/div/div[2]/div/div/div/div/div[2]/div[2]/div/small[2]/a"));
			pageUrlText= pageUrl.getAttribute("href");
			
			
		}
		
		public String getDirectorypageUrlTest() {
			return pageUrlText;
		}
	
}
