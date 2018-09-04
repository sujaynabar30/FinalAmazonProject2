package com.amazon.windowhandle;

import java.util.Set;

import org.openqa.selenium.WebDriver;

public class VerifyWindowHandling {
	
	public void windowHandle(WebDriver driver, String searchKey,String MainWindow) {
		
		Set<String> allWindowsHandle = driver.getWindowHandles();				     //get the id's of all windows
		System.out.println("\nAllwindows :"+allWindowsHandle);
		
		for(String childWindow : allWindowsHandle) {							     //iterating over the all windows 
													       //child-window stores the starting id of the window from set
			if(!MainWindow.equalsIgnoreCase(childWindow)) {
				
				  driver.switchTo().window(childWindow);
			}
	   }		
   }
}
