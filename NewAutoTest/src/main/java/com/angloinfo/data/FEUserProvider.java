package com.angloinfo.data;

import org.testng.annotations.DataProvider;

public class FEUserProvider {

	@DataProvider(name = "userCredentials")
	public static Object[][] createData() {
		return new Object [][] {
			{"ainfo1001+stg7@gmail.com","Anglo123"}
		};
	}
	
}
