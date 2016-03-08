package com.angloinfo.tools;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {
	
	public static WebDriver getDriver() {
		WebDriver driver = new FirefoxDriver();
		return driver;
	}
}
