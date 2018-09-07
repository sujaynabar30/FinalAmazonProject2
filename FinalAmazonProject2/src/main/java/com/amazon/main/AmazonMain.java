package com.amazon.main;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.amazon.browserinit.BrowserFactory;
import com.amazon.readfiles.ReadConfigfile;
import com.amazon.testcases.DataproviderClass;
import com.amazon.testcases.FilteringMouseHover;
import com.amazon.testcases.VerifyAmazonLogin;
import com.amazon.testcases.VerifyCartPage;
import com.amazon.testcases.VerifyCartProducts;
import com.amazon.testcases.VerifyProductDelete;
import com.amazon.testcases.VerifyProductPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.github.windpapi4j.InitializationFailedException;
import com.github.windpapi4j.WinAPICallFailedException;
import com.psl.screenshot.Utility;

/**
 * 
 * @author sujay_nabar This is a test case Class where all test cases are
 *         executed from this class
 */

public class AmazonMain {
	
	ExtentReports extent;
	ExtentTest logger;
	public WebDriver driver;
	ReadConfigfile r = new ReadConfigfile();
	
	@BeforeMethod											//before each test-method this is executed 
	public void beforeMethod(){
		
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("./Reports/AmazonReport.html");
	    extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		logger = extent.createTest("AmazonTest");
		
	}
	
	@BeforeTest													//this is initializing the browser 
	public void beforeTest() throws InitializationFailedException, WinAPICallFailedException, IOException, InterruptedException {		
		driver = BrowserFactory.startBrowser(r.getBrowser(), r.getUrl());
	}

	@Test
	public void verifylogin() {		//this function is used to login into amazon
		VerifyAmazonLogin login = new VerifyAmazonLogin(driver);
		login.verifyValidLogin(r.getEmailId(), r.getPassword());
	}
									//this function is used to search the product and add it into the cart
	@Test(dependsOnMethods= {"verifylogin"}, dataProvider = "SearchProvider", dataProviderClass = DataproviderClass.class)
	public void searchproudctPage(String key) throws InterruptedException {
		 VerifyProductPage testprodpage = new VerifyProductPage(driver);
		 testprodpage.testProductPage(key);
	}
									//this function will verify if the added prod is in cart or not
	@Test(dependsOnMethods= {"searchproudctPage"} ,dataProvider = "SearchProvider", dataProviderClass = DataproviderClass.class)
	public void cartPage(String key) {
		
		VerifyCartPage cart = new VerifyCartPage(driver);
		cart.testCartPage(key);	
	}
									//this function will get the list of prods from the cart
	@Test(dependsOnMethods= {"cartPage"})
	public void getcartDetails() {
		VerifyCartProducts cartprod = new VerifyCartProducts(driver);
		cartprod.getDetails();
	}
									//this function will delete the product from the cart
	@Test(dependsOnMethods = { "getcartDetails" })
	public void productDelete() {
		VerifyProductDelete proddelcart = new VerifyProductDelete(driver);
		proddelcart.prodDelete();
	}
	
			//this function search any prod and filter them, get list of prod and mouseHover the categories button 
	@Test(dependsOnMethods = {"productDelete"}, dataProvider = "ValueProvider", dataProviderClass = DataproviderClass.class)
	public void mousehover(String min, String max, String searchkey, String Title) {
		
		FilteringMouseHover mouse = new FilteringMouseHover(driver);
		mouse.filterMouseHover(min,max,searchkey,Title);
	}
	

	@AfterTest()			               //this function will end the session/close the page
	public void afterTest() {
		driver.quit();
	}
	
	@AfterMethod								//after each testmethod this is executed 
	public void afterMethod(ITestResult result) throws IOException {
		
		if(result.getStatus()==ITestResult.FAILURE) {
			
			String temp = Utility.getScrrenshot(driver);
			logger.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
		}
		
		extent.flush();

	}
}
