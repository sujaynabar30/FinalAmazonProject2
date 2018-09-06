package com.amazon.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.amazon.pageobjectmodel.ProductCartPage;

/**
 * 
 * @author sujay_nabar
 * this page will verify if the added prod is in cart or not
 */

public class VerifyCartPage {
	
	WebDriver driver;
	
	public VerifyCartPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public void testCartPage(String searchKey) {
		
		ProductCartPage test_cart = PageFactory.initElements(driver, ProductCartPage.class);
		test_cart.testCart(searchKey);
	}
	
}
