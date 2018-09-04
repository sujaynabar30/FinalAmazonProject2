package com.amazon.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.amazon.pageobjectmodel.GetCartProductDetails;


/**
 * 
 * @author sujay_nabar
 *	this class will get all the product list from the cart
 */

public class VerifyCartProducts {
	
	public void getDetails(WebDriver driver) {
		
		GetCartProductDetails test_cart_prod = PageFactory.initElements(driver, GetCartProductDetails.class);
		test_cart_prod.getDetailsFromCart();
	}
}
