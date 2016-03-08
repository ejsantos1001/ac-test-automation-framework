package com.angloinfo.blueprint.testcase;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import com.angloinfo.tools.*;


public  abstract class   WebTest {
	private String baseurl;
	private String accesstoken;
	private WebDriver driver;
	
	
	@Parameters({"environment"})
	@BeforeTest
	public void beforeTest(String env) {
		setBaseurl(urlManager.getFEbaseurl(env));
		setDriver(DriverManager.getDriver());
		
	}

	
	
	public WebDriver getDriver() {
		return driver;
	}

	void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public String getBaseurl() {
		return baseurl;
	}

	void setBaseurl(String baseurl) {
		this.baseurl = baseurl;
	}

	public String getAccesstoken() {
		return accesstoken;
	}

	void setAccesstoken(String accesstoken) {
		this.accesstoken = accesstoken;
	}
}
