package com.angloinfo.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.angloinfo.tools.WebDriverManager;
import com.angloinfo.pageobjects.LoginPage;
import com.angloinfo.tools.UrlManager;

public class GUIWebSignIn {
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
	public void signInViaEmail() {
			
			LoginPage LoginPage1 = new LoginPage(driver);
			LoginPage1.goToPage(febaseurl);
			LoginPage1.inputEmail("ainfo1001+7@gmail.com");
			LoginPage1.inputPassword("Anglo123");
			LoginPage1.clickLogin();	
			Assert.assertEquals(LoginPage1.getCurrentUrl(), febaseurl + "/buenos-aires/member/dashboard");
			Reporter.log("succesfull login");
		}
	
}
