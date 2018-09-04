package com.amazon.pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * 
 * @author sujay_nabar
 * This class will store all the locators and methods of login page
 *
 */

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver localdriver) {
		this.driver = localdriver;
	}
	
	@FindBy(id="ap_email")
	@CacheLookup
	WebElement email;
	
	@FindBy(id="ap_password")
	@CacheLookup
	WebElement password;
	
	@FindBy(id="signInSubmit")
	@CacheLookup
	WebElement signin;
	
	@FindBy(id="nav-link-yourAccount")
	@CacheLookup
	WebElement AmazonCart;
	
	@FindBy(id="continue")
	@CacheLookup
	WebElement ContinueButton;
	
	public void loginToAmazon(String emailid, String pass)
	{
		AmazonCart.click();
		email.sendKeys(emailid);
		ContinueButton.click();
		password.sendKeys(pass);
		signin.click();
	}
	
	
}
