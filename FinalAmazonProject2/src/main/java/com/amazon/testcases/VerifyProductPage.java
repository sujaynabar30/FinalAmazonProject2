package com.amazon.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.amazon.pages.ProductPage;

/**
 * 
 * @author sujay_nabar
 * This class is used to search the product and call the window handling class
 */
public class VerifyProductPage {
	
	public void testProductPage(String searchKey,WebDriver driver) {
					
			ProductPage product_page = PageFactory.initElements(driver, ProductPage.class); 
			product_page.searchproduct(searchKey);
		
			VerifyWindowHandle window = new VerifyWindowHandle();				//go to windowhandling class
			window.windowHandle(driver,searchKey);
	}
}
