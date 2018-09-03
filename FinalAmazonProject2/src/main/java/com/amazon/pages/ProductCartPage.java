package com.amazon.pages;

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
		
		public void testCart(String searchKey) {

		System.out.println("Title of current page :" + driver.getTitle());
		addtocartbutton.click();
		System.out.println("product added to cart");
		cartbutton.click();

		Assert.assertEquals(driver.getTitle(), "Amazon.in Shopping Cart");

		String statement = driver.findElement(By.linkText(searchKey)).getText();

		Assert.assertEquals(statement, searchKey); // asserting for cart if prod is not there in cart it will fail

		if (statement.equals(searchKey)) {
			System.out.println("Assert is successful");
		}

		driver.close();

	}
}
