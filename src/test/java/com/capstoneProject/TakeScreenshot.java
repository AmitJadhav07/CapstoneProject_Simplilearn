package com.capstoneProject;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakeScreenshot {

	public static void getScreenshot(WebDriver driver) throws IOException {

		TakesScreenshot takeScreenshot = (TakesScreenshot) driver;
		File srcFile = takeScreenshot.getScreenshotAs(OutputType.FILE);
		String destStr = String.valueOf(System.getProperty("user.dir")) + "/Screenshots/" + PageObjects.timestamp
				+ ".png";
		File destFile = new File(destStr);
		FileUtils.copyFile(srcFile, destFile);
//		return destStr;	
	}
}