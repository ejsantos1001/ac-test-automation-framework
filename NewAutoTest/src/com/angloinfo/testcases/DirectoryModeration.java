package com.angloinfo.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.angloinfo.pageobjects.CMSLoginPage;
import com.angloinfo.tools.WebDriverManager;
import com.angloinfo.tools.UrlManager;


public class DirectoryModeration {
	
	 String febaseurl;
	 String cmsbaseurl;
	 String accesstoken;
	 WebDriver driver;
	
	
	@Parameters({"environment"})
	@BeforeTest
	public void beforeTest(String env) {
		driver = WebDriverManager.getDriver();
		driver.manage().window().maximize();
		febaseurl = UrlManager.getFEbaseurl(env);
		cmsbaseurl =UrlManager.getCMSbaseurl(env);
	}
	
	@Test
	public void cmsLogin() {
		
		CMSLoginPage CMSLoginPage1 = new CMSLoginPage(driver);
		CMSLoginPage1.goToPage(cmsbaseurl);
		CMSLoginPage1.typeEmail("dev@angloinfo.com");
		CMSLoginPage1.typePassword("penguin");
		CMSLoginPage1.clickLogin();
	}
	
	

}
