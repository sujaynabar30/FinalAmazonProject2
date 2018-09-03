package com.amazon.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.amazon.pages.ProductDeletePage;

/**
 * 
 * @author sujay_nabar This class is used for deleting the product from the
 *         class
 */
public class VerifyProductDelete {

	public void prodDelete(WebDriver driver) {
		
		ProductDeletePage productDelete_page = PageFactory.initElements(driver,ProductDeletePage.class);
		productDelete_page.productdelete();
	}
}
