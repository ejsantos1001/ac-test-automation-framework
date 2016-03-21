package com.angloinfo.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import static com.jayway.restassured.RestAssured.*;
import com.angloinfo.data.Member;
import com.angloinfo.tools.*;

public class ApiRegister {
 
  private static String accesstoken;	
  private String apibaseurl;
  
  @Parameters({"environment"})
  @BeforeTest
  public void BeforeTest(String environment) {
	 apibaseurl =  UrlManager.getAPIbaseurl(environment);
	 accesstoken = AuthManager.getAccessToken(apibaseurl);
  }
  

  @Test(dataProvider = "dp" , threadPoolSize=1 , invocationCount = 1 , timeOut=10000)
  public void registerUserViaApi(Member regMember) {
	   given().
	   		auth().oauth2(accesstoken).
	   		queryParam("firstname",regMember.getFirstname()).
	  		queryParam("lastname",regMember.getLastname()).
	  		queryParam("email",regMember.getEmail()).
	  		queryParam("password",regMember.getPassword()).
	  		queryParam("username",regMember.getUsername()).
	  		queryParam("gender",regMember.getGender()).
	  		queryParam("location",regMember.getLocation()).
	  	when().
	  		post(apibaseurl+"/member/register").
	  	then().
	  		statusCode(200);
	  	
	  	
	  	System.out.println(regMember.getEmail());
	  	System.out.println(regMember.getUsername());
	  
  }
  
 

  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] {new Member()},
    
    };
  } 
  
}




