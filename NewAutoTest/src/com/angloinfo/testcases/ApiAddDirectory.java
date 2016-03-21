package com.angloinfo.testcases;

import static com.jayway.restassured.RestAssured.given;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.angloinfo.data.DirectoryListing;
import com.angloinfo.tools.AuthManager;
import com.angloinfo.tools.UrlManager;

public class ApiAddDirectory {
	 String apibaseurl;
	 String accesstoken;
	
	  @Parameters({"environment"})
	  @BeforeTest
	  public void BeforeTest(String environment) {
		 apibaseurl =  UrlManager.getAPIbaseurl(environment);
		 accesstoken = AuthManager.getAccessToken(apibaseurl);
	  }
	    
	  @Test(dataProvider= "dp2" )
	  public void addDirectory(DirectoryListing DirListing) {
		given().
	  		auth().oauth2(accesstoken).
	  		queryParam("location",DirListing.getLocation()).
	 		queryParam("category_id",DirListing.getCategory_id()).
	 		queryParam("name",DirListing.getName()).
	 		queryParam("description",DirListing.getDescription()).
	 		queryParam("address",DirListing.getAddress()).
	 		queryParam("longtitude",DirListing.getLongtitude()).
	 		queryParam("latitude",DirListing.getLatitude()).
	 		queryParam("contact_number",DirListing.getContact_number()).
	 		queryParam("contact_email",DirListing.getContact_email()).
	 		queryParam("contact_website",DirListing.getContact_website()).
	 	when().
	 		post(apibaseurl+"/directory/listing/add").
	 	then().
	 		statusCode(200);
	    	
	    	
	  }
	    
	  @DataProvider
	  public Object[][] dp2() {
	     return new Object[][] {
	       new Object[] {new DirectoryListing()},
	     
	   }; 
	    
	    
	  }
	  
}
