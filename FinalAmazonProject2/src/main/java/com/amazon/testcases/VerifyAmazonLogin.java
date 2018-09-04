package com.amazon.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.amazon.pageobjectmodel.LoginPage;

/**
 * 
 * @author sujay_nabar
 * 
 *         This is a class used for the logging-in of the user
 */

public class VerifyAmazonLogin {

	WebDriver driver;

	public VerifyAmazonLogin(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public void verifyValidLogin(String username, String pass) {

		Assert.assertEquals(driver.getTitle(),"Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
		// verify the main page

		LoginPage login_page = PageFactory.initElements(driver, LoginPage.class); // created page object using page factory
																					
		login_page.loginToAmazon(username, pass); 				  // call the method (this will call all the login elements)

		WebElement verify = driver.findElement(By.xpath("//*[@id=\"nav-link-yourAccount\"]/span[1]"));
		String check = verify.getText();											//get text of the sign in username
		
		Assert.assertEquals(check, "Hello, NABAR");
		
		if (check.equals("Hello, NABAR")) {							//if cond. is true it will print
			System.out.println("----Logged in Sucessfully----");
		} else {
			System.out.println("!!!!Login failed.....Closing Browser");
			driver.close();
		}
	}

}
