package com.psl.screenshot;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utility {
	
	public static String getScrrenshot(WebDriver driver) {
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		
		File src = ts.getScreenshotAs(OutputType.FILE);
		
		String path = System.getProperty("user.dir")+"/Screenshots/"+System.currentTimeMillis()+".png";
		File destination = new File(path);
		
		try {
			FileUtils.copyFile(src, destination);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Capture Failed "+e.getMessage());
		}
		
		return path;
		
	}
	
}
