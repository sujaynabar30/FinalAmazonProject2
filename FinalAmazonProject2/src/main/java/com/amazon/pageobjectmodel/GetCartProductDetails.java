package com.amazon.pageobjectmodel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class GetCartProductDetails {

	WebDriver driver;

	public GetCartProductDetails(WebDriver localdriver) {
		this.driver = localdriver;
	}
	
	@FindBy(id="nav-cart")
	@CacheLookup
	WebElement cartbutton;
	
	@FindBy(xpath="//*[@id=\"nav-logo\"]/a[1]/span[1]")
	@CacheLookup
	WebElement icon;

	public void getDetailsFromCart() {
		
		cartbutton.click();
		
		List<WebElement> links = driver.findElements(By.className("a-size-medium sc-product-title a-text-bold"));
		//System.out.println(links);
		
		//System.out.println("\nTotal number of product found in cart are :" + links.size() + "\n"); // get the count

		for (int i = 1; i < links.size(); i = i + 1) {
			System.out.println(links.get(i).getText());            // get the product link names till the count
		}
		
		//icon.click();
	}

}
