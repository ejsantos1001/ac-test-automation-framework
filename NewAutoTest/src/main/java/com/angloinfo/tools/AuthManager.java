package com.angloinfo.tools;

import static com.jayway.restassured.RestAssured.given;

public class AuthManager {

		public static String getAccessToken(String apibaseurl) {
			
			String  accesstoken =
					  given().
							queryParam("grant_type","client_credentials").
							queryParam("client_id",1).
							queryParam("client_secret","coapp").
					  when().
							post(apibaseurl+"/oauth/access_token").
					  then().
					  		statusCode(200).
					  extract().
					  		path("access_token");
			return accesstoken;
		}
}
