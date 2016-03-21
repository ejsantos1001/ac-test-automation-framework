package com.angloinfo.testcases;



import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.angloinfo.data.DirectoryListing;
import com.angloinfo.pageobjects.CMSLoginPage;
import com.angloinfo.pageobjects.CmsManageDirectoryPage;
import com.angloinfo.tools.WebDriverManager;
import com.angloinfo.tools.UrlManager;


public class GuidAddDirectory {
	
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
	
	@Test(dataProvider = "dp")
	public void addDirectoryViaCMS(DirectoryListing dl) {
		
		CMSLoginPage CMSLoginPage1 = new CMSLoginPage(driver);
		CMSLoginPage1.goToPage(cmsbaseurl);
		CMSLoginPage1.typeEmail("dev@angloinfo.com");
		CMSLoginPage1.typePassword("penguin");
		CMSLoginPage1.clickLogin();
		CMSLoginPage1.switchLocation();
		CmsManageDirectoryPage CmsManageDirectoryPage1 = new CmsManageDirectoryPage(driver);
		CmsManageDirectoryPage1.goToPage(cmsbaseurl);
		CmsManageDirectoryPage1.addDirectoryListing(dl);
		
	}
	
	
	 @DataProvider
	  public Object[][] dp() {
	     return new Object[][] {
	    	 
	       new Object[] {new DirectoryListing()}
	     
	   }; 
	  }
	
	
	@AfterTest
	public void afterTest () {
		driver.close();
		driver.quit();
	}
}
