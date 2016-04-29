package com.angloinfo.tools;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TimingTools {
	
	
	public static void defeatSpinner(WebDriver driver) {
		
		do{}
		while(!(TimingTools.isElementPresent(driver,By.className("blockUI"))));
		do{}
	    while(TimingTools.isElementPresent(driver,By.className("blockUI")));
		
	}
	
	public static boolean isElementPresent(WebDriver driver,By by){
			try {
					driver.findElement(by);
					return true;
			} catch(org.openqa.selenium.NoSuchElementException e)	{
					return false;
				
			}
			
	}
	
}
