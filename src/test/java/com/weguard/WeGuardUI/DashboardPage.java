package com.weguard.WeGuardUI;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {
	public WebDriver driver;
	
	@FindBy(xpath = "//*[@id='drop-mini']/mat-sidenav-content/div[1]/ng-component/mat-card/div/div[1]/app-dashboard-header/div/div[1]/div[1]/div[2]")
	WebElement activeUsers;
	
	public DashboardPage(WebDriver driver) {
		this.driver = driver;

		String url = "https://qa-cloud.weguard.io/#/dashboard";

		// Navigate to page
		driver.get(url);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// wait for page to load
		wait.until(ExpectedConditions.urlContains(url));

		WebElement loadingEl = driver.findElement(By.xpath("//*[contains(@class, 'windows8')]"));

		// wait for loading sign to disappear
		wait.until(ExpectedConditions.invisibilityOf(loadingEl));

		PageFactory.initElements(driver, this);

		System.out.println("Started Dashboard Test");
	}

	public void visibilityTest() {

		// Active Users
		if (activeUsers.isDisplayed()) {
			System.out.println("ActiveUsers displayed");
		}

		// Chart
		boolean Chart = driver.findElement(By.xpath(
				"//*[@id='drop-mini']/mat-sidenav-content/div[1]/ng-component/mat-card/div/div[1]/app-dashboard-header/div/div[1]/div[2]/div[1]"))
				.isDisplayed();
		if (Chart) {
			System.out.println("Chart displayed");
		}

		// Graph
		boolean Graph = driver.findElement(By.cssSelector(
				"#drop-mini > mat-sidenav-content > div:nth-child(2) > ng-component > mat-card > div > div.w-75 > div.h-30.chart-area > section > p-chart:nth-child(2) > div > canvas"))
				.isDisplayed();
		if (Graph) {
			System.out.println("Graph displayed");
		}

		// OEMGraph
		// boolean OEMGraph = driver.findElement
		// (By.cssSelector("#SvgjsPath1421")).isDisplayed();
		// if(OEMGraph) {
		// System.out.println ("OEMGraph displayed");
		// }

		// ActiveDevices
		boolean ActiveDevices = driver.findElement(By.cssSelector(
				" #drop-mini > mat-sidenav-content > div:nth-child(2) > ng-component > mat-card > div > div.w-75 > app-dashboard-header > div > div:nth-child(1) > div:nth-child(2) > div.color-black"))
				.isDisplayed();
		if (ActiveDevices) {
			System.out.println("ActiveDevices displayed");
		}

		// NonCompliant
		boolean NonCompliant = driver.findElement(By.cssSelector(
				" #drop-mini > mat-sidenav-content > div:nth-child(2) > ng-component > mat-card > div > div.w-75 > app-dashboard-header > div > div:nth-child(1) > div:nth-child(3) > div.color-black"))
				.isDisplayed();
		if (NonCompliant) {
			System.out.println("NonCompliant displayed");
		}

		// Files
		boolean Files = driver.findElement(By.cssSelector(
				" #drop-mini > mat-sidenav-content > div:nth-child(2) > ng-component > mat-card > div > div.w-75 > app-dashboard-header > div > div.d-flex.d-flex.justify-content-start.ml-5 > div:nth-child(1) > div.color-black"))
				.isDisplayed();
		if (Files) {
			System.out.println("Files displayed");
		}

		// Messages
		boolean Messages = driver.findElement(By.cssSelector(
				"#drop-mini > mat-sidenav-content > div:nth-child(2) > ng-component > mat-card > div > div.w-75 > app-dashboard-header > div > div.d-flex.d-flex.justify-content-start.ml-5 > div:nth-child(2) > div.color-black "))
				.isDisplayed();
		if (Messages) {
			System.out.println("Messages displayed");
		}

		// Calls
		boolean Calls = driver.findElement(By.cssSelector(
				" #drop-mini > mat-sidenav-content > div:nth-child(2) > ng-component > mat-card > div > div.w-75 > app-dashboard-header > div > div.d-flex.d-flex.justify-content-start.ml-5 > div:nth-child(3)"))
				.isDisplayed();
		if (Calls) {
			System.out.println("Calls displayed");
		}

		// RecentActivity
		boolean RecentActivity = driver.findElement(By.cssSelector(
				"#drop-mini > mat-sidenav-content > div:nth-child(2) > ng-component > mat-card > div > div.rect-activity-container > app-recent-activity-alerts-table > div"))
				.isDisplayed();
		if (RecentActivity) {
			System.out.println("RecentActivity displayed");
		}

		// Devices Recently Enrolled
		boolean DevicesRecentlyEnrolled = driver.findElement(By.cssSelector(
				"#drop-mini > mat-sidenav-content > div:nth-child(2) > ng-component > mat-card > div > div.w-75 > div.d-flex > app-recently-enrolled-devices-table > div.table-header-color.p-2.bold.my-2.justify-content-center"))
				.isDisplayed();
		if (DevicesRecentlyEnrolled) {
			System.out.println("Devices Recently Enrolled displayed");
		}

		// Devices Consuming High Data
		boolean DevicesConsumingHighData = driver.findElement(By.cssSelector(
				"#drop-mini > mat-sidenav-content > div:nth-child(2) > ng-component > mat-card > div > div.w-75 > div.d-flex > app-recently-enrolled-devices-table > div.table-header-color.p-2.bold.my-2.justify-content-center"))
				.isDisplayed();

		if (DevicesConsumingHighData) {
			System.out.println("Devices Consuming HighData displayed");
		}

	}

}
