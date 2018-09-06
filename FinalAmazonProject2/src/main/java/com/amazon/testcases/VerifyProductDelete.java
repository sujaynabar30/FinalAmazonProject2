package com.amazon.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.amazon.pageobjectmodel.ProductDeletePage;

/**
 * 
 * @author sujay_nabar This class is used for deleting the product from the
 *         class
 */
public class VerifyProductDelete {
	
	WebDriver driver;	

	public VerifyProductDelete(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public void prodDelete() {
		
		ProductDeletePage productDelete_page = PageFactory.initElements(driver,ProductDeletePage.class);
		productDelete_page.productdelete();
	}
}
