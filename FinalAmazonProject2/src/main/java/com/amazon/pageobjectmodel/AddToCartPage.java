package com.amazon.pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class AddToCartPage {
	
	WebDriver driver;

	public AddToCartPage(WebDriver localdriver) {
		this.driver = localdriver;
	}

		@FindBy(id = "add-to-cart-button")
		@CacheLookup
		WebElement addtocartbutton;
		
		@FindBy(id="nav-cart")
		@CacheLookup
		WebElement cartbutton;
		
		@FindBy(xpath="//*[@id=\"huc-v2-order-row-confirm-text\"]/h1")
		@CacheLookup
		WebElement productadded;
		
		public void addtoCart() {
			
			System.out.println("\nTitle of current page :" + driver.getTitle());
			addtocartbutton.click();
			String prodtext = productadded.getText();
			//System.out.println(prodtext);
			
			Assert.assertEquals(prodtext, "Added to Cart");
			
			if(prodtext.equals("Added to Cart"))
			{
				System.out.println("\n----Product Added Successfully----");
			}
			else {
				System.out.println("!!!Adding Product to cart failed");
			}
			cartbutton.click();
			driver.close();
		}
}
