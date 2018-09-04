package com.amazon.pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ProductPage {
	
	WebDriver driver;

	public ProductPage(WebDriver localdriver) {
		this.driver = localdriver;
	}
	
	@FindBy(xpath="//*[@id=\"twotabsearchtextbox\"]")
	@CacheLookup
	WebElement searchbar;
	
	@FindBy(className="nav-input")
	@CacheLookup
	WebElement searchbutton;
	
	@FindBy(xpath="//*[@id=\"productTitle\"]")
	@CacheLookup
	WebElement productTitle;
	
	public void searchproduct(String searchKey) {
		
		System.out.println("Data-Provided Key is :"+searchKey);
		searchbar.clear();
		searchbar.sendKeys(searchKey);
		searchbutton.click();
		
	}
	
	
}
