package com.angloinfo.tools;

public class urlManager {
	
	
	public static String getFEbaseurl(String env)    {
		String baseurl = null;
			switch(env) {
			case "prod":
				baseurl ="https://prd.angloinfo.com";
				break;
			case "stg":
				baseurl ="https://stg.angloinfo.com";
				break;
			}
		return	baseurl;		
	}			
					
					
	public static String getCMSbaseurl(String env)	 {
		String baseurl=null;
			switch(env) {
			case "prod":
				baseurl ="https://cms.angloinfo.com";
			break;
				case "stg":
				baseurl ="https://stgcms.angloinfo.com";
			break;
		}
		return baseurl;
	}
	
	public static String getAPIbaseurl (String env)	 {
		String baseurl=null;
		switch(env) {
			case "prod":
			baseurl ="https://api.angloinfo.com";
		break;
			case "stg":
			baseurl ="https://stgapi.angloinfo.com";
		break;
	}
	return baseurl;		
	}				
					
				
		
	
	

	
	
}
