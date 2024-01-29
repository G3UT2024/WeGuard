package com.weguard.WeGuardUI;

import java.time.Duration;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

public class PolicyRestrictionsPage {

	private WebDriver driver;
	private ExtentTest test;
	private Logger logger;
	private WebDriverWait wait;

	@FindBy(css = "div[class= 'bg-settings ng-star-inserted']")
	WebElement generalBtn;

	public PolicyRestrictionsPage(WebDriver driver, ExtentTest test, Logger logger) {
		this.driver = driver;
		this.test = test;
		this.logger = logger;

		String url = TestNGBase.BASE_URL + "#/groups";

		// Navigate to page
		driver.get(url);

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// wait for page to load
		wait.until(ExpectedConditions.urlContains(url));

		// wait for loading sign to disappear
		WebElement loadingEl = driver.findElement(By.xpath("//*[contains(@class, 'windows8')]"));
		wait.until(ExpectedConditions.invisibilityOf(loadingEl));
		
//		defaultAndroidKiosk.calick();
		
		wait.until(ExpectedConditions.invisibilityOf(loadingEl));

		PageFactory.initElements(driver, this);

		// Remove chat using js
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("return document.querySelector('body > div.zsiq_floatmain.zsiq_theme1.siq_bR').remove();");

		logger.info("Initiating Policy Group Test...");
	}
	
	

}
