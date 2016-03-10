package com.angloinfo.tools;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TimingTools {
	
	public static boolean isElementPresent(WebDriver driver,By by){
			try {
					driver.findElement(by);
					return true;
			} catch(org.openqa.selenium.NoSuchElementException e)	{
					return false;
				
			}
	}

}
