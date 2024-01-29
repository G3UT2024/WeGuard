package com.weguard.WeGuardUI;

import static org.testng.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

public class PolicyGroupsPage {

	private static final int SEARCH_START_IDX = 0;
	private static final int SEARCH_END_IDX = 3;

	private static String[] POLICIES = { "Kiosk", "Work Managed", "Work Profile", "Non Play Kiosk",
			"Non Play Work Managed", "Non Play Work Profile" };

	private WebDriver driver;
	private ExtentTest test;
	private Logger logger;
	private WebDriverWait wait;

	// Policy Elements

	// General

	@FindBy(xpath = "//button[contains(., 'Edit')]")
	WebElement editBtn;

	@FindBy(xpath = "//*[contains(@id, 'cdk-overlay')]//app-qr-dialog/div/section/button")
	WebElement enrollEditBtn;

	@FindBy(xpath = "//*[@id='drop-mini']/mat-sidenav-content/div[1]/app-s-new-policies/div/mat-card/mat-card-content/app-android-policy/section/section[2]/section/app-spolicy-summary-view/section/div[4]/button[2]")
	WebElement summaryCloseBtn;

	@FindBy(xpath = "//*[@id='drop-mini']/mat-sidenav-content/div[1]/app-s-new-policies/div/mat-card/mat-card-content/app-android-policy/section/section[1]/div/div[2]/div/div/div/button[2]")
	WebElement policyCloseBtn;

	@FindBy(xpath = "/html/body/div[2]")
	WebElement chatEl;

	@FindBy(xpath = "//*[contains(@class, 'windows8')]")
	WebElement loadingSign;

	// Kiosk

	@FindBy(xpath = "//mat-row[.//span[contains(text(), 'Default Android Kiosk')]]//mat-cell[contains(@class, 'mat-column-Name')]")
	WebElement kioskPolicyBtn;

	@FindBy(xpath = "//mat-row[.//span[contains(text(), 'Default Android Kiosk')]]//mat-cell[contains(@class, 'mat-column-Actions')]//img[@src='assets/summary.svg']")
	WebElement kioskSummaryBtn;

	@FindBy(xpath = "//mat-row[.//span[contains(text(), 'Default Android Kiosk')]]//mat-cell[contains(@class, 'mat-column-Actions')]//img[@src='assets/qr-code2.svg']")
	WebElement kioskEnrollBtn;

	@FindBy(xpath = "//mat-row[.//span[contains(text(), 'Default Android Kiosk')]]//mat-cell[contains(@class, 'mat-column-Actions')]//button")
	WebElement kioskOptionsBtn;

	// Work Managed

	@FindBy(xpath = "//mat-row[.//span[contains(text(), 'Default Android Work Managed')]]//mat-cell[contains(@class, 'mat-column-Name')]")
	WebElement wmPolicyBtn;

	@FindBy(xpath = "//mat-row[.//span[contains(text(), 'Default Android Work Managed')]]//mat-cell[contains(@class, 'mat-column-Actions')]//img[@src='assets/summary.svg']")
	WebElement wmSummaryBtn;

	@FindBy(xpath = "//mat-row[.//span[contains(text(), 'Default Android Work Managed')]]//mat-cell[contains(@class, 'mat-column-Actions')]//img[@src='assets/qr-code2.svg']")
	WebElement wmEnrollBtn;

	@FindBy(xpath = "//mat-row[.//span[contains(text(), 'Default Android Work Managed')]]//mat-cell[contains(@class, 'mat-column-Actions')]//button")
	WebElement wmOptionsBtn;

	// Work Profile

	@FindBy(xpath = "//mat-row[.//span[contains(text(), 'Default Android Work Profile')]]//mat-cell[contains(@class, 'mat-column-Name')]")
	WebElement wpPolicyBtn;

	@FindBy(xpath = "//mat-row[.//span[contains(text(), 'Default Android Work Profile')]]//mat-cell[contains(@class, 'mat-column-Actions')]//img[@src='assets/summary.svg']")
	WebElement wpSummaryBtn;

	@FindBy(xpath = "//mat-row[.//span[contains(text(), 'Default Android Work Profile')]]//mat-cell[contains(@class, 'mat-column-Actions')]//img[@src='assets/qr-code2.svg']")
	WebElement wpEnrollBtn;

	@FindBy(xpath = "//mat-row[.//span[contains(text(), 'Default Android Work Profile')]]//mat-cell[contains(@class, 'mat-column-Actions')]//button")
	WebElement wpOptionsBtn;

	// Non Play Kiosk

	@FindBy(xpath = "//mat-row[.//span[contains(text(), 'Default Android Non Play Kiosk')]]//mat-cell[contains(@class, 'mat-column-Name')]")
	WebElement npKioskPolicyBtn;

	@FindBy(xpath = "//mat-row[.//span[contains(text(), 'Default Android Non Play Kiosk')]]//mat-cell[contains(@class, 'mat-column-Actions')]//img[@src='assets/summary.svg']")
	WebElement npKioskSummaryBtn;

	@FindBy(xpath = "//mat-row[.//span[contains(text(), 'Default Android Non Play Kiosk')]]//mat-cell[contains(@class, 'mat-column-Actions')]//img[@src='assets/qr-code2.svg']")
	WebElement npKioskEnrollBtn;

	@FindBy(xpath = "//mat-row[.//span[contains(text(), 'Default Android Non Play Kiosk')]]//mat-cell[contains(@class, 'mat-column-Actions')]//button")
	WebElement npKioskOptionsBtn;

	// Work Managed

	@FindBy(xpath = "//mat-row[.//span[contains(text(), 'Default Android Non Play Work Managed')]]//mat-cell[contains(@class, 'mat-column-Name')]")
	WebElement npWmPolicyBtn;

	@FindBy(xpath = "//mat-row[.//span[contains(text(), 'Default Android Non Play Work Managed')]]//mat-cell[contains(@class, 'mat-column-Actions')]//img[@src='assets/summary.svg']")
	WebElement npWmSummaryBtn;

	@FindBy(xpath = "//mat-row[.//span[contains(text(), 'Default Android Non Play Work Managed')]]//mat-cell[contains(@class, 'mat-column-Actions')]//img[@src='assets/qr-code2.svg']")
	WebElement npWmEnrollBtn;

	@FindBy(xpath = "//mat-row[.//span[contains(text(), 'Default Android Non Play Work Managed')]]//mat-cell[contains(@class, 'mat-column-Actions')]//button")
	WebElement npWmOptionsBtn;

	// Work Profile

	@FindBy(xpath = "//mat-row[.//span[contains(text(), 'Default Android Non Play Work Profile')]]//mat-cell[contains(@class, 'mat-column-Name')]")
	WebElement npWpPolicyBtn;

	@FindBy(xpath = "//mat-row[.//span[contains(text(), 'Default Android Non Play Work Profile')]]//mat-cell[contains(@class, 'mat-column-Actions')]//img[@src='assets/summary.svg']")
	WebElement npWpSummaryBtn;

	@FindBy(xpath = "//mat-row[.//span[contains(text(), 'Default Android Non Play Work Profile')]]//mat-cell[contains(@class, 'mat-column-Actions')]//img[@src='assets/qr-code2.svg']")
	WebElement npWpEnrollBtn;

	@FindBy(xpath = "//mat-row[.//span[contains(text(), 'Default Android Non Play Work Profile')]]//mat-cell[contains(@class, 'mat-column-Actions')]//button")
	WebElement npWpOptionsBtn;

	@FindBy(xpath = "//*[@id='mat-select-354']")
	WebElement columnsDisplay;

	@FindBy(xpath = "//*[@id='mat-option-4656']")
	WebElement columnName;

	@FindBy(xpath = "//*[@id='mat-option-4657']")
	WebElement columnVersion;

	@FindBy(xpath = "//*[@id='mat-option-4658']")
	WebElement columnPolicytype;

	@FindBy(xpath = "//*[@id='mat-option-4659']")
	WebElement wifiOption;

	@FindBy(xpath = "//*[@id='mat-option-4660']")
	WebElement messagesOption;

	@FindBy(xpath = "//*[@id='mat-option-4661']")
	WebElement deviceCountOption;

	@FindBy(xpath = "//*[@id='mat-option-4662']")
	WebElement actionsOption;

	// Kiosk clone

	@FindBy(xpath = "//*[@id='drop-mini']/mat-sidenav-content/div[1]/app-s-new-policies/mat-card/mat-card-content/div[1]/div/button/span[1]/mat-icon")
	WebElement cloneBtn;

	@FindBy(xpath = "//input[contains(@data-placeholder, 'Select group name')]")
	WebElement cloneGroupNameInput;

	@FindBy(xpath = "//button[.//span[text()='OK']]")
	WebElement cloneOKButton;

	@FindBy(xpath = "//input[contains(@data-placeholder, 'New group name')]")
	WebElement cloneNewInput;

	@FindBy(xpath = "//button[.//span[contains(text(), 'CLONE')]]")
	WebElement newCloneBtn;

	@FindBy(xpath = "//button[.//span[contains(text(), 'No')]]")
	WebElement cloneNoBtn;

	@FindBy(xpath = "//mat-option[.//span[text()='Default Android Kiosk']]")
	WebElement kioskCloneGroupName;

	@FindBy(xpath = "//mat-option[.//span[text()='Default Android Work Managed']]")
	WebElement wmCloneGroupName;

	@FindBy(xpath = "//mat-option[.//span[text()='Default Android Work Profile']]")
	WebElement wpCloneGroupName;

	@FindBy(xpath = "//mat-option[.//span[text()='Default Android Non Play Kiosk']]")
	WebElement npKioskCloneGroupName;

	@FindBy(xpath = "//mat-option[.//span[text()='Default Android Non Play Work Managed']]")
	WebElement npWmCloneGroupName;

	@FindBy(xpath = "//mat-option[.//span[text()='Default Android Non Play Work Profile']]")
	WebElement npWpCloneGroupName;

	WebElement[] cloneGroupNames;

	@FindBy(xpath = "//button[.//mat-icon[contains(text(), 'delete')]]")
	WebElement policyDeleteBtn;

	@FindBy(xpath = "//button[.//span[contains(text(), 'DELETE')]]")
	WebElement policyDeleteConfirmBtn;

	@FindBy(xpath = "//mat-row//span[contains(@class, 'p-name')]")
	List<WebElement> policyNames;

	@FindBy(xpath = "//mat-row//span[starts-with(normalize-space(text()), 'Clone')]")
	List<WebElement> clonedPolicyNames;

	@FindBy(xpath = "//mat-row[.//span[starts-with(normalize-space(text()), 'Clone')]]//button[.//mat-icon[contains(text(), 'more_vert')]]")
	List<WebElement> clonedPolicyOptionBtns;

	@FindBy(xpath = "//input[contains(@data-placeholder, 'Search')]")
	WebElement searchBar;

	public PolicyGroupsPage(WebDriver driver, ExtentTest test, Logger logger) {
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

		PageFactory.initElements(driver, this);

		WebElement[] cloneGroupsTemp = { kioskCloneGroupName, wmCloneGroupName, wpCloneGroupName, npKioskCloneGroupName,
				npWmCloneGroupName, npWpCloneGroupName };

		cloneGroupNames = cloneGroupsTemp;

		// Remove chat using js
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("return document.querySelector('body > div.zsiq_floatmain.zsiq_theme1.siq_bR').remove();");

		logger.info("Initiating Policy Group Test...");
	}

	public void testPolicyClick(WebElement policyBtn, ExtentTest node) {
		try {
			policyBtn.click();

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.invisibilityOf(loadingSign));

			// policy restrictions page close
			policyCloseBtn.click();
		} catch (Exception e) {
			ErrorHandler.handleException(driver, e, logger, "Policy Click Test Failed", node);
			return;
		}

		node.pass("Policy Click Passed");
		logger.info("Policy Click Passed");
	}

	// summary view
	public void testSummary(WebElement summaryBtn, ExtentTest node) {
		try {
			// click summary button
			Actions actions = new Actions(driver);
			actions.moveToElement(summaryBtn);

			try {
				Thread.sleep(Duration.ofSeconds(2));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			actions.click().perform();

			// wait for summary page to load
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.invisibilityOf(loadingSign));

			summaryCloseBtn.click();
		} catch (Exception e) {
			ErrorHandler.handleException(driver, e, logger, "Summary Test Failed", node);
			return;
		}

		node.pass("Summary Test Passed");
		logger.info("Summary Test Passed");
	}

	public void testEnrollBtn(WebElement enrollBtn, ExtentTest node) {
		try {
			// click summary button
			Actions actions = new Actions(driver);
			actions.moveToElement(enrollBtn);

			try {
				Thread.sleep(Duration.ofSeconds(1));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			actions.click().perform();

			// wait for summary page to load
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

			wait.until(ExpectedConditions.invisibilityOf(loadingSign));

			enrollEditBtn.click();

			wait.until(ExpectedConditions.invisibilityOf(loadingSign));

			policyCloseBtn.click();
		} catch (Exception e) {
			ErrorHandler.handleException(driver, e, logger, "Enroll Button Test Failed", node);
			return;
		}

		node.pass("Enroll Button Test Passed");
		logger.info("Enroll Button Test Passed");
	}

	public void testEditBtn(WebElement optionsBtn, ExtentTest node) {
		try {
			optionsBtn.click();
			editBtn.click();

			// wait for edit page to load
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.invisibilityOf(loadingSign));

			policyCloseBtn.click();
		} catch (Exception e) {
			ErrorHandler.handleException(driver, e, logger, "Edit Button Test Failed", node);
			return;
		}

		node.pass("Edit Button Test Passed");
		logger.info("Edit Button Test Passed");
	}

	public void testPolicy(String name, WebElement policyBtn, WebElement summaryBtn, WebElement enrollBtn,
			WebElement optionsBtn) {
		ExtentTest node = test.createNode(name);
		logger.info("Testing " + name + "...");

		testPolicyClick(policyBtn, node);
		testSummary(summaryBtn, node);
		testEnrollBtn(enrollBtn, node);
		testEditBtn(optionsBtn, node);
	}

	public void testKiosk() {
		testPolicy("Kiosk", kioskPolicyBtn, kioskSummaryBtn, kioskEnrollBtn, kioskOptionsBtn);
	}

	public void testWorkManaged() {
		testPolicy("Work Managed", wmPolicyBtn, wmSummaryBtn, wmEnrollBtn, wmOptionsBtn);
	}

	public void testWorkProfile() {
		testPolicy("Work Profile", wpPolicyBtn, wpSummaryBtn, wpEnrollBtn, wpOptionsBtn);
	}

	public void testNPKiosk() {
		testPolicy("Non Play Kiosk", npKioskPolicyBtn, npKioskSummaryBtn, npKioskEnrollBtn, npKioskOptionsBtn);
	}

	public void testNPWorkManaged() {
		testPolicy("Non Play Work Managed", npWmPolicyBtn, npWmSummaryBtn, npWmEnrollBtn, npWmOptionsBtn);
	}

	public void testNPWorkProfile() {
		testPolicy("Non Play Work Profile", npWpPolicyBtn, npWpSummaryBtn, npWpEnrollBtn, npWpOptionsBtn);
	}

	public void testClone(String policyName, WebElement cloneGroupName) {
		ExtentTest node = test.createNode(policyName + " Clone Test");
		logger.info("Testing " + policyName + " Clone...");

		try {

			cloneBtn.click();

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

			wait.until(ExpectedConditions.invisibilityOf(loadingSign));

			cloneGroupNameInput.click();

			cloneGroupName.click();

			cloneOKButton.click();

			String timestamp = new SimpleDateFormat("yyyy-MM-dd'T'HH-mm-ss").format(new Date());
//			String uuid = UUID.randomUUID().toString();

			// Entering cloned policy name

			String clonedPolicyName = "Clone " + timestamp;

			cloneNewInput.sendKeys(clonedPolicyName);

			newCloneBtn.click();

			wait.until(ExpectedConditions.invisibilityOf(loadingSign));

			cloneNoBtn.click();
		} catch (Exception e) {
			ErrorHandler.handleException(driver, e, logger, "Clone " + policyName + " Test Failed", node);
		}

		node.pass(policyName + " Clone Test Passed");
		logger.info(policyName + " Clone Test Passed");
	}

	public void testDelete(WebElement policyNameSpan, WebElement policyOptionsBtn) {
		String policyName = "'" + policyNameSpan.getText() + "'";

		ExtentTest node = test.createNode(policyName + " Delete Test");
		logger.info("Deleting " + policyName + "...");

		try {
			policyOptionsBtn.click();

			policyDeleteBtn.click();

			policyDeleteConfirmBtn.click();

			wait.until(ExpectedConditions.invisibilityOf(loadingSign));
		} catch (Exception e) {
			ErrorHandler.handleException(driver, e, logger, policyName + " Delete Test Failed", node);
		}

		node.pass(policyName + " Delete Test Passed");
		logger.info(policyName + " Delete Test Passed");
	}

	public void testDefaultCloning() {
		for (int i = 0; i < 6; i++) {
			testClone(POLICIES[i], cloneGroupNames[i]);
		}
	}

	public void testCloneDeletion() {
		while (clonedPolicyNames.size() > 0) {
			testDelete(clonedPolicyNames.get(0), clonedPolicyOptionBtns.get(0));
		}
	}

	public void testSearch() {
		ExtentTest node = test.createNode("Search Test");
		logger.info("Testing Search...");
		
		try {			
			for (int i = 0; i < policyNames.size(); i++) {
				String currPolicyName = policyNames.get(i).getText();
				
				String searchSubstr = currPolicyName.substring(SEARCH_START_IDX, SEARCH_END_IDX);
				
				searchBar.sendKeys(searchSubstr);
				
				for (WebElement policyNameEl : policyNames) {
					String policyName = policyNameEl.getText();
					
					assertEquals(policyName.substring(SEARCH_START_IDX, SEARCH_END_IDX), searchSubstr);
				}
				
				searchBar.clear();
			}
		} catch (Exception e) {
			ErrorHandler.handleException(driver, e, logger, "Search Test Failed", node);
		}
		
		node.pass("Search Test Passed");
		logger.info("Search Test Passed");
	}
}