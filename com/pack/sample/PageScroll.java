package com.pack.sample;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pack.common.commonActions;
import com.pack.common.commonMethods;
import com.pack.utils.TakeScreenshot;

public class PageScroll {
	
	private WebDriver driver;
	private String url ="https://www.linkedin.com/";
	public commonMethods common;
	public TakeScreenshot shot= new TakeScreenshot();
	
	
	@BeforeMethod
	public void setUp(){
		  common = new commonMethods(driver);
		  driver =common.openBrowser("chrome");
		  common.goToUrl(url);
		
	}
	@AfterMethod
	public void tearDown(){
		   common.closeBrowser();
	}
	
/*	@Test
	public void testcaseofScrolling() throws IOException{
		          commonActions.scrollToBottom(driver);
		          shot.take_Screenshot(driver);     
	}*/
	@Test
	public void scrollingToElementofAPage() throws IOException{
		driver.navigate().to(url+"directory/companies/?trk=uno-reg-guest-home-companies-directory");
		WebElement ele =common.getElement("linkText", "Import/Export");
		shot.take_Screenshot(driver);  
		commonActions.scrollTo(driver, ele);
		 
	}
}
