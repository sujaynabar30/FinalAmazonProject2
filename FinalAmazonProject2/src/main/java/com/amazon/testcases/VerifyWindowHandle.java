package com.amazon.testcases;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.amazon.pages.ProductCartPage;

/**
 * 
 * @author sujay_nabar
 * This page is used for Window Handling
 */

public class VerifyWindowHandle {

	public void windowHandle(WebDriver driver, String searchKey) {
		
		
		String MainWindow = driver.getWindowHandle();								//get current id of window
		System.out.println("Mainwindow :"+MainWindow);
		
		driver.findElement(By.linkText(searchKey)).click();			//finding the product and clicking
		
		System.out.println("Title of main page :"+driver.getTitle());
		
		Assert.assertEquals(driver.getTitle(), "Amazon.in: "+searchKey);
		
		Set<String> allWindowsHandle = driver.getWindowHandles();				//get the id's of all windows
		System.out.println("Allwindows :"+allWindowsHandle);
		
		for(String childWindow : allWindowsHandle) {							//iterating over the all windows 
																				//childwindow stores the starting id of the window from set
			if(!MainWindow.equalsIgnoreCase(childWindow)) {
				
				  driver.switchTo().window(childWindow);
				  
				  ProductCartPage win_handle = PageFactory.initElements(driver, ProductCartPage.class);
				  win_handle.testCart(searchKey);		

			}
		}
			driver.switchTo().window(MainWindow);
	}

}
