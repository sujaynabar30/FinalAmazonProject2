package com.amazon.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.amazon.browserinit.BrowserFactory;
import com.amazon.readfiles.ReadConfigfile;
import com.github.windpapi4j.InitializationFailedException;
import com.github.windpapi4j.WinAPICallFailedException;

/**
 * 
 * @author sujay_nabar This is a test case Class where all test cases are
 *         executed from this class
 */

public class AmazonMain extends VerifyProductPage {

	public WebDriver driver;
	ReadConfigfile r = new ReadConfigfile();
	
	@BeforeTest
	public void beforeTest() throws InitializationFailedException, WinAPICallFailedException, IOException, InterruptedException {		
		driver = BrowserFactory.startBrowser(r.getBrowser(), r.getUrl());
	}

	@Test
	public void verifylogin() {
		VerifyAmazonLogin login = new VerifyAmazonLogin(driver);
		login.verifyValidLogin(r.getEmailId(), r.getPassword());
	}

	@Test(dependsOnMethods = { "verifylogin" }, dataProvider = "SearchProvider", dataProviderClass = DataproviderClass.class)
	public void proudctPage(String key) throws InterruptedException {
		testProductPage(key, driver);
	}

	@Test(dependsOnMethods = { "proudctPage" })
	public void productDelete() {
		VerifyProductDelete proddelcart = new VerifyProductDelete();
		proddelcart.prodDelete(driver);
	}

	@Test(dependsOnMethods = { "productDelete" })
	public void mousehover() {
		FilteringMouseHover mouse = new FilteringMouseHover(driver);
		mouse.filterMouseHover();
	}

	@AfterTest()
	public void afterTest() {
		driver.quit();
	}

}
