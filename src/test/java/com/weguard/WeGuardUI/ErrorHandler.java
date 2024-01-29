package com.weguard.WeGuardUI;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import com.aventstack.extentreports.ExtentTest;

public class ErrorHandler {
	
	public static void handleException(WebDriver driver, Exception e, Logger logger, String message) {
		logger.error(message);
		captureScreenshot(driver, logger);
		e.printStackTrace();
	}
	
	public static void handleException(WebDriver driver, Exception e, Logger logger, String message, ExtentTest test) {
		test.fail(message);
		handleException(driver, e, logger, message);
	}
	
    public static void captureScreenshot(WebDriver driver, Logger logger) {
    	// Set screenshot name to current date and time
        String timestamp = new SimpleDateFormat("yyyy-MM-dd'T'HH-mm-ss").format(new Date());
        String screenshotName = timestamp + ".png";
    	
        // Convert WebDriver object to TakesScreenshot
        TakesScreenshot ts = (TakesScreenshot) driver;
        
        // Capture the screenshot as a file
        File source = ts.getScreenshotAs(OutputType.FILE);
        
        // Define the destination path for the screenshot
        File destination = new File("C:\\Users\\gayatri.tadeparti_we\\eclipse-workspace\\WeGuardUI\\screenshots\\exceptions\\" + screenshotName);
        
        try {
            // Copy the screenshot file to the destination
            FileHandler.copy(source, destination);
            logger.info("Screenshot captured: " + screenshotName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
}
