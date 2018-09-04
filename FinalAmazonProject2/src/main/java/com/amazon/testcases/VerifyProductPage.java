package com.amazon.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.amazon.pageobjectmodel.AddToCartPage;
import com.amazon.pageobjectmodel.ProductPage;
import com.amazon.windowhandle.VerifyWindowHandling;

/**
 * 
 * @author sujay_nabar
 * This class is used to search the product and call the window handling class
 */
public class VerifyProductPage {
	
	public void testProductPage(String searchKey,WebDriver driver) {
					
			ProductPage product_page = PageFactory.initElements(driver, ProductPage.class); //goes to search prod page
			product_page.searchproduct(searchKey);
		
			String MainWindow = driver.getWindowHandle();								//get current id of window
			System.out.println("\nMainwindow :"+MainWindow);
			
			driver.findElement(By.linkText(searchKey)).click();	
			
			System.out.println("\nTitle of main page :"+driver.getTitle());
			
			VerifyWindowHandling win_handle = new VerifyWindowHandling();
			win_handle.windowHandle(driver, searchKey, MainWindow);
			
			AddToCartPage addto_cart = PageFactory.initElements(driver, AddToCartPage.class);
			addto_cart.addtoCart();										//goes to add-to cart button
			
			driver.switchTo().window(MainWindow);
			
	}
}
