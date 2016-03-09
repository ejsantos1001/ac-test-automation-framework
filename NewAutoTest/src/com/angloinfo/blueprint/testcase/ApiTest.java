package com.angloinfo.blueprint.testcase;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.angloinfo.tools.AuthManager;
import com.angloinfo.tools.UrlManager;

public abstract class ApiTest {
	String apibaseurl;
	String cmsbaseurl;
	String accesstoken;
	
	
	@Parameters({"environment"})
	@BeforeTest
	public void beforeTest(String env) {
		 apibaseurl =  UrlManager.getAPIbaseurl(env);
		 cmsbaseurl = UrlManager.getCMSbaseurl(env);
		 accesstoken = AuthManager.getAccessToken(apibaseurl);
		
	}
}
