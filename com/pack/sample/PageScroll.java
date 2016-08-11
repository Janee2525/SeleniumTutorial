package com.pack.sample;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pack.common.commonActions;
import com.pack.common.commonMethods;
import com.pack.utils.TakeScreenshot;

public class PageScroll {
	
	private WebDriver driver;
	public commonMethods common;
	public TakeScreenshot shot= new TakeScreenshot();
	
	
	@BeforeMethod
	public void setUp(){
		  common = new commonMethods(driver);
		  driver =common.openBrowser("chrome");
		  common.goToUrl("https://www.linkedin.com/");
		
	}
	@AfterMethod
	public void tearDown(){
		   common.closeBrowser();
	}
	
	@Test
	public void testcaseofScrolling() throws IOException{
		        
		          commonActions.scrollToBottom(driver);
		          shot.take_Screenshot(driver);
		       
	}

}
