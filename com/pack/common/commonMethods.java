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
		     System.out.println("Go to " +baseUrl);
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
	public WebElement getElement( String locator,String value ){
        WebElement element = null;                     
        switch (locator){
        case "id":  
        	       element =driver.findElement(By.id(value));
                   break;
        case "linkText": 
        	       element =driver.findElement(By.linkText(value));
                    break;
        case "name":
        	        element=driver.findElement(By.name(value));
                    break;
        case "partialLink": 
        	        element =driver.findElement(By.partialLinkText(value));
                    break;
        case "tagName":  
        	       element=driver.findElement(By.tagName(value));
                    break;
        case "xpath":
        	       element=driver.findElement(By.xpath(value));
                   break;
        case "className": 
        	       element= driver.findElement(By.className(value));
                   break;
        case "cssSelector": 
        	       element =driver.findElement(By.cssSelector(value));
                   break;
}
        return element;
	
}
}