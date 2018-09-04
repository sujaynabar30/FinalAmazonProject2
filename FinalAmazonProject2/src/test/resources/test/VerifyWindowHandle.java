package com.amazon.windowhandle;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

/**
 * 
 * @author sujay_nabar
 * This page is used for Window Handling
 */

public class VerifyWindowHandle {

	public void windowHandle(WebDriver driver, String searchKey) {
		
		
		String MainWindow = driver.getWindowHandle();								//get current id of window
		System.out.println("\nMainwindow :"+MainWindow);
		
		driver.findElement(By.linkText(searchKey)).click();			                //finding the product and clicking
		
		System.out.println("\nTitle of main page :"+driver.getTitle());
		
		Assert.assertEquals(driver.getTitle(), "Amazon.in: "+searchKey);
		
		Set<String> allWindowsHandle = driver.getWindowHandles();				     //get the id's of all windows
		System.out.println("\nAllwindows :"+allWindowsHandle);
		
		for(String childWindow : allWindowsHandle) {							     //iterating over the all windows 
													       //child-window stores the starting id of the window from set
			if(!MainWindow.equalsIgnoreCase(childWindow)) {
				
				  driver.switchTo().window(childWindow);
				  
				 /* AddToCartPage addto_cart = PageFactory.initElements(driver, AddToCartPage.class);
				  addto_cart.addtoCart();										//goes to add-to cart button	
*/
			}
		}
			driver.switchTo().window(MainWindow);								//switch to main window
	}

}
