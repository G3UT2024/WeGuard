
package com.weguard.WeGuardUI;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

 /* Description:
 * This is used for testing Navigation Links in Admin Console
 */

public class Navigation {
	
	public static void testNavLink(WebDriver driver, String name, By selector, String expectedUrl) {
		// create explicit wait object, with max wait time of 20 seconds
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		// wait for loading sign to disappear
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".windows8"))));
		
		// find nav link element
		WebElement navLinkEl = driver.findElement(selector);
		
		// wait for the nav link to be clickable
        // wait.until(ExpectedConditions.elementToBeClickable(navLinkEl));
		
		// click the nav link element
		navLinkEl.click();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// wait for loading sign to disappear
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".windows8"))));
		
		// get url of page
		String url = driver.getCurrentUrl();

		// check if it is equal to the expected url
		if (url.equals(expectedUrl)) {
			System.out.println("Navigated to " + name + " page successfully");
		} else {
			System.out.println("Navigation to " + name + " page failed");
			System.out.println("URL: " + url);
		}
	}

	public static void main(String args[]) {

		//Chrome
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\gayatri.tadeparti_we\\Documents\\chromedriver\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		
		// Login
//		Authenticator auth = new Authenticator(driver);

		try {
//			auth.login();
			System.out.println("Login Successful");
		} catch (Exception e) {
			System.out.println("Not able to login");
			return;
		}

		// Wait for main page to load
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.urlContains("https://qa-cloud.weguard.io/#/dashboard"));
		
		// Devices
		testNavLink(driver, "Devices", By.xpath("//*[@href='#/devices']"), "https://qa-cloud.weguard.io/#/devices2");
		
		// PolicyGroups
		testNavLink(driver, "Policy Groups", By.xpath("//*[@href='#/groups']"), "https://qa-cloud.weguard.io/#/groups");
		
		// Reports
		testNavLink(driver, "Reports", By.xpath("//*[@href='#/reports']"), "https://qa-cloud.weguard.io/#/reports");

		// DataUsage
		testNavLink(driver, "Data Usage", By.xpath("//*[@href='#/devicedatausage']"), "https://qa-cloud.weguard.io/#/devicedatausage");

		// WeTrack
		testNavLink(driver, "WeTrack", By.xpath("//*[@href='#/geocoordinates']"), "https://qa-cloud.weguard.io/#/geocoordinates");

		// WeBox
		testNavLink(driver, "WeBox", By.xpath("//*[@href='#/webox']"), "https://qa-cloud.weguard.io/#/webox");

		// Broadcast
		testNavLink(driver, "Broadcast", By.xpath("//*[@href='#/broadcast']"), "https://qa-cloud.weguard.io/#/broadcast");

		// AuditLogs
		testNavLink(driver, "Audit Logs", By.xpath("//*[@href='#/logs']"), "https://qa-cloud.weguard.io/#/logs");

		// Alerts
		testNavLink(driver, "Alerts", By.xpath("//*[@href='#/alerts']"), "https://qa-cloud.weguard.io/#/alerts");

		// WeTalk
		testNavLink(driver, "WeTalk", By.xpath("//*[@href='#/wetalk']"), "https://qa-cloud.weguard.io/#/wetalk");

		// Bulk Actions
		testNavLink(driver, "Bulk Actions", By.xpath("//*[@href='#/bulkactions']"), "https://qa-cloud.weguard.io/#/bulkactions");

		// WeShield:
		testNavLink(driver, "WeShield", By.xpath("//*[@href='#/weshield']"), "https://qa-cloud.weguard.io/#/weshield");

		// Roles &Permissions:
		testNavLink(driver, "Roles & Permissions", By.xpath("//*[@href='#/roles']"), "https://qa-cloud.weguard.io/#/roles");
		
		driver.close();
		
	}
	
}