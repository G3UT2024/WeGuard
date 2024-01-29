package com.weguard.WeGuardUI;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class TestNGBase {

	public static final String BASE_URL = System.getenv("BASE_URL");
	public static final String USERNAME = System.getenv("USER_NAME");
	public static final String PASSWORD = System.getenv("PASSWORD");
//	public static final String USERNAME = "gayatri.tadeparti+CA1@wenable.com";
//	public static final String PASSWORD = "Testing@1";

	public static Logger logger;

	private WebDriver driver;
	private ExtentReports extent;
	private Authenticator authenticator;

	@BeforeTest
	public void init() {
		// Log4j2 Configuration
		System.setProperty("log4j.configurationFile",
				"C:\\Users\\gayatri.tadeparti_we\\eclipse-workspace\\WeGuardUI\\log4j2.xml");

		logger = LogManager.getRootLogger();

		logger.info("Initializing...");

		// Chrome Configuration
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\gayatri.tadeparti_we\\Documents\\chromedriver\\chromedriver.exe");

		ChromeOptions options = new ChromeOptions();

		options.addArguments("--remote-allow-origins=*");

		// Create Driver
		driver = new ChromeDriver(options);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		extent = new ExtentReports();

        String timestamp = new SimpleDateFormat("yyyy-MM-dd'T'HH-mm-ss").format(new Date());
		ExtentSparkReporter spark = new ExtentSparkReporter("reports/" + timestamp + ".html");

		extent.attachReporter(spark);
		
		authenticator = new Authenticator(driver);
	}

	@AfterTest
	public void terminate() {
		driver.quit();
		extent.flush();
	}
	
	@Test
	public void loginTest() {
		ExtentTest extentTest = extent.createTest("Login Test");
		
		authenticator.testLogin(extentTest);
	}
	
	@Test
	public void  policyRestrictions() {
		ExtentTest extentTest = extent.createTest("Policy Restrictions Test");

		authenticator.login(extentTest);

		PolicyRestrictionsPage policyRestrictionsTest = new PolicyRestrictionsPage(driver, extentTest, logger);
	}

	@Test
	public void policyGroups() {	
		ExtentTest extentTest = extent.createTest("Policy Group Test");

		authenticator.login(extentTest);

		PolicyGroupsPage policyGroupsTest = new PolicyGroupsPage(driver, extentTest, logger);

	    policyGroupsTest.testKiosk();
	    policyGroupsTest.testWorkManaged();
		policyGroupsTest.testWorkProfile();
		policyGroupsTest.testNPKiosk();
		policyGroupsTest.testNPWorkManaged();
		policyGroupsTest.testNPWorkProfile();	
		
//	    policyGroupsTest.testDefaultCloning();
		//policyGroupsTest.testCloneDeletion();
		
//		policyGroupsTest.KiosktestClone();
//		policyGroupsTest.WMtestClone();
//		policyGroupsTest.WPtestClone();
//	    policyGroupsTest.NonplayKiosktestClone();
		policyGroupsTest.testSearch();
		
		
	}
}
