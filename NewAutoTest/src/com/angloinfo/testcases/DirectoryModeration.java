package com.angloinfo.testcases;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.angloinfo.pageobjects.CMSLoginPage;
import com.angloinfo.pageobjects.CmsManageDirectoryPage;
import com.angloinfo.tools.WebDriverManager;
import com.angloinfo.tools.UrlManager;


public class DirectoryModeration {
	
	 String febaseurl;
	 String cmsbaseurl;
	 String accesstoken;
	 WebDriver driver;
	 WebDriverWait wait ;
	
	
	@Parameters({"environment"})
	@BeforeTest
	public void beforeTest(String env) {
		driver = WebDriverManager.getDriver();
		driver.manage().window().maximize();
		febaseurl = UrlManager.getFEbaseurl(env);
		cmsbaseurl = UrlManager.getCMSbaseurl(env);
	}
	
	@Test
	public void cmsDirectoryModeration() {
		
		CMSLoginPage CMSLoginPage1 = new CMSLoginPage(driver);
		CMSLoginPage1.goToPage(cmsbaseurl);
		CMSLoginPage1.typeEmail("dev@angloinfo.com");
		CMSLoginPage1.typePassword("penguin");
		CMSLoginPage1.clickLogin();
		
		
		CMSLoginPage1.switchLocation();
		
		
		CmsManageDirectoryPage CmsManageDirectoryPage1 = new CmsManageDirectoryPage(driver);
		
		CmsManageDirectoryPage1.goToPage(cmsbaseurl);
		
	}
	
	
	
	

}
