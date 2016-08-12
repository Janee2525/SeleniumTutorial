package com.pack.common;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class commonActions {
	
	 public static void scrollToBottom(WebDriver driver){
		      ((JavascriptExecutor)driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		        System.out.println("I am scrolling down to the bottom of the page");
	 }
	  public static void scrollTo(WebDriver driver, WebElement element){
		            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",  element);
		            
	  }

}
