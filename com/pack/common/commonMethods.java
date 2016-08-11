package com.pack.common;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.MarionetteDriver;



public class commonMethods {
	
	private WebDriver driver ;
	
	public commonMethods(WebDriver driver){
		     this.driver = driver;
	}
	public WebDriver openBrowser(String browser){
		     
		   if (browser.equalsIgnoreCase("Chrome")){
			     System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
			     driver = new ChromeDriver();
			     System.out.println("Open Chrome browser");
		   }
		   else if  (browser.equalsIgnoreCase("Firefox")){
			     System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
			     driver = new MarionetteDriver();
			     System.out.println("Open Firefox browser");
		   }
		return driver;
	}
	
	public void goToUrl(String baseUrl){
		     driver.get(baseUrl);
		     System.out.println("Go to URL");
	}
	
	public void closeBrowser(){
		    driver.quit();
		    System.out.println("Close a browser");
		    System.out.println("***********************************");
	}	
	public void verifyText(String expectedText){
		       String actualText =  driver.findElement(By.xpath("//*[contains(text(),'"+ expectedText.trim() +"')]")).getText();
		       Assert.assertEquals(expectedText, actualText);
		       System.out.println("Verify text - "+ expectedText);
	}
	
}
