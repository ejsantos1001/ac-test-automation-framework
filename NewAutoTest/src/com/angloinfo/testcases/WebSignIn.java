package com.angloinfo.testcases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.angloinfo.blueprint.testcase.WebTest;
import com.angloinfo.pageobjects.LoginPage;

public class WebSignIn extends WebTest{

		@Test
		public void signInViaEmail() {
			LoginPage LoginPage1 = new LoginPage(getDriver());
			LoginPage1.goToPage(getBaseurl());
			LoginPage1.inputEmail("ainfo1001+7@gmail.com");
			LoginPage1.inputPassword("Anglo123");
			LoginPage1.clickLogin();	
			Assert.assertEquals(LoginPage1.getCurrentUrl(), getBaseurl() + "/buenos-aires/member/dashboard");
			Reporter.log("succesfull login");
		}
	
}
