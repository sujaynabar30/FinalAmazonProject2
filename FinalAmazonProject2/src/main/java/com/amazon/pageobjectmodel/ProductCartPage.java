package com.amazon.pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ProductCartPage {

	WebDriver driver;

	public ProductCartPage(WebDriver localdriver) {
		this.driver = localdriver;
	}

		@FindBy(id = "add-to-cart-button")
		@CacheLookup
		WebElement addtocartbutton;
		
		@FindBy(id="nav-cart")
		@CacheLookup
		WebElement cartbutton;
		
		@FindBy(xpath="//*[@id=\"nav-logo\"]/a[1]/span[1]")
		@CacheLookup
		WebElement icon;
		
		//@FindBy(id="a-autoid-0-announce")
		@FindBy(className="a-dropdown-prompt")
		@CacheLookup
		WebElement quantitybutton;
		
		public void testCart(String searchKey) {
			
		//icon.click();
		System.out.println("\n----Testing Cart----\n");
		cartbutton.click();
		
		Assert.assertEquals(driver.getTitle(), "Amazon.in Shopping Cart");

		String statement = driver.findElement(By.linkText(searchKey)).getText();

		Assert.assertEquals(statement, searchKey);    // asserting for cart if prod is not there in cart it will fail

		if (statement.equals(searchKey)) {
			System.out.println("\nTest cart is successful\n");
		}
		
		String b = quantitybutton.getText();
		int button = Integer.parseInt(b);
		
		if(button>1) {
			
			System.out.println("\nProduct Added and quanity is increased to "+button);
		}
		else {
			System.out.println("\nCart Prod is verified");
		}

		//driver.close();

	}
}
