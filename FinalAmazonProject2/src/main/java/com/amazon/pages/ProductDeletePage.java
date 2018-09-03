package com.amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ProductDeletePage {
	
	WebDriver driver;
	
	public ProductDeletePage(WebDriver localdriver) {
		this.driver = localdriver;
	}
	
	@FindBy(id="nav-cart")
	@CacheLookup
	WebElement cartbutton;
	
	@FindBy(xpath="//*[@id=\"activeCartViewForm\"]/div[2]/div[2]/div[4]/div[2]/div[1]/div/div/div[2]/div/span[1]/span/input")
	@CacheLookup
	WebElement deletebutton;
	
	@FindBy(xpath="//*[@id=\"nav-logo\"]/a[1]/span[1]")
	@CacheLookup
	WebElement icon;
	
	public void productdelete()
	{
		cartbutton.click();
		deletebutton.click();
		System.out.println("product deleted");
		icon.click();
	}
}
