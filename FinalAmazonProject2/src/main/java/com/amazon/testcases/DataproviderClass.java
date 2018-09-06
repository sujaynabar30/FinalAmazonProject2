package com.amazon.testcases;

import org.testng.annotations.DataProvider;

/**
 * 
 * @author sujay_nabar This is a data provider class used for sending the data
 *         to the verifylogin class and mousehover class
 */
public class DataproviderClass {

	@DataProvider(name = "SearchProvider")
	public static Object[] getDataFromDataprovider() {

		return new Object[] { "Three Thousand Stitches: Ordinary People, Extraordinary Lives",
				"The Dhoni Touch: Unravelling the Enigma That Is Mahendra Singh Dhoni" };
	}
	
	@DataProvider(name = "ValueProvider")
	public Object[][] getValuesFromDataprovider() {
		
	   //return new Object[][]{{5, "min"}, {6, "max"}};
		return new Object[][]{{"10000", "20000","mobiles","Mobile Accessories: Buy Mobile Accessories online at best prices in India - Amazon.in"}};
		
	}

}
