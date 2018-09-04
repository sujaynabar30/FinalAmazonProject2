package com.amazon.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.amazon.pageobjectmodel.FilteringMouseHoverPage;

/**
 * 
 * @author sujay_nabar This class is used for filtering the products and using
 *         mouseHover using action builder
 */

public class FilteringMouseHover {

	WebDriver driver;

	public FilteringMouseHover(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public void filterMouseHover() {

		FilteringMouseHoverPage filtermousehover_page = PageFactory.initElements(driver, FilteringMouseHoverPage.class);
		filtermousehover_page.sortMouseHover();

	}
}
