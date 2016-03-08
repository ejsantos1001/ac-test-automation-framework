package com.angloinfo.blueprint.testcase;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.angloinfo.tools.AuthManager;
import com.angloinfo.tools.urlManager;

public abstract class ApiTest {
	String apibaseurl;
	String accesstoken;
	
	
	@Parameters({"environment"})
	@BeforeTest
	public void beforeTest(String env) {
		 apibaseurl =  urlManager.getAPIbaseurl(env);
		 accesstoken = AuthManager.getAccessToken(apibaseurl);
		
	}
}
