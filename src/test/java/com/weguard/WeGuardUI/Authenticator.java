
package com.weguard.WeGuardUI;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

public class Authenticator {
	
	private WebDriver driver;

	@FindBy(xpath = "//input[contains(@placeholder, 'Email')]")
	WebElement usernameInput;

	@FindBy(xpath = "//input[contains(@placeholder, 'Password')]")
	WebElement passwordInput;

	@FindBy(xpath = "//button[.//span[contains(text(), 'Submit')]]")
	WebElement loginBtn;

	@FindBy(xpath = "//*[contains(@class, 'windows8')]")
	WebElement loadingEl;
	
	@FindBy(xpath = "//*[@id='mat-tab-content-0-0']/div/div/p")
	WebElement errorMsg;
	
	public Authenticator(WebDriver driver) {
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}

	public void login(ExtentTest extentTest) {
		Logger logger = LogManager.getRootLogger();

		logger.info("Logging In...");

		try {
			driver.get(TestNGBase.BASE_URL + "#/login");

			usernameInput.sendKeys(TestNGBase.USERNAME);

			passwordInput.sendKeys(TestNGBase.PASSWORD);

			loginBtn.click();

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

			// wait for page to load
			wait.until(ExpectedConditions.urlContains(TestNGBase.BASE_URL + "#/dashboard"));

			// wait for loading sign to disappear
			wait.until(ExpectedConditions.invisibilityOf(loadingEl));
		} catch (Exception e) {
			ErrorHandler.handleException(driver, e, logger, "Failed to Login!", extentTest);
		}
	}

	public void testLoginUsername(ExtentTest extentTest, Logger logger) {
		ExtentTest extentNode = extentTest.createNode("Login Username Test");

		try {
			driver.get(TestNGBase.BASE_URL + "#/login");

			usernameInput.sendKeys(TestNGBase.USERNAME);

			passwordInput.sendKeys(TestNGBase.PASSWORD);

			loginBtn.click();

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

			// wait for loading sign to disappear
			wait.until(ExpectedConditions.invisibilityOf(loadingEl));

			assertEquals(errorMsg.isDisplayed(), true);

			extentNode.pass("Login Username Test Passed");
		} catch (Exception e) {
			ErrorHandler.handleException(driver, e, logger, "Login Username Test Failed", extentNode);
		}
	}

	public void testLoginPassword(ExtentTest extentTest, Logger logger) {
		ExtentTest extentNode = extentTest.createNode("Login Password Test");

		try {
			driver.get(TestNGBase.BASE_URL + "#/login");

			usernameInput.sendKeys(TestNGBase.USERNAME);

			passwordInput.sendKeys(TestNGBase.PASSWORD);

			loginBtn.click();

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

			// wait for loading sign to disappear
			wait.until(ExpectedConditions.invisibilityOf(loadingEl));

			assertEquals(errorMsg.isDisplayed(), true);

			extentNode.pass("Login Password Test Passed");
		} catch (Exception e) {
			ErrorHandler.handleException(driver, e, logger, "Login Password Test Failed", extentTest);
		}
	}

	public void testLogin(ExtentTest extentTest) {
		Logger logger = LogManager.getRootLogger();

		logger.info("Initiating Login Test...");

		testLoginUsername(extentTest, logger);
		testLoginPassword(extentTest, logger);
	}
}
