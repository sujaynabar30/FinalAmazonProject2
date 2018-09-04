package com.amazon.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.amazon.pageobjectmodel.ProductCartPage;

public class VerifyCartPage {
	
	public void testCartPage(WebDriver driver, String searchKey) {
		
		ProductCartPage test_cart = PageFactory.initElements(driver, ProductCartPage.class);
		test_cart.testCart(searchKey);
	}
	
}
