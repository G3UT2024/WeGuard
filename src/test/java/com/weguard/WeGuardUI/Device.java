package com.weguard.WeGuardUI;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
public class Device {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		//setting the driver executable
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\gayatri.tadeparti_we\\Documents\\chromedriver\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();

		options.addArguments("--remote-allow-origins=*");
		
		
		WebDriver driver=new ChromeDriver(options);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.manage().window().maximize();

		
		driver.get("https://qa-cloud.weguard.ai/#/login");
		
		WebElement usernameInput = driver.findElement(By.xpath("//input[contains(@placeholder, 'Email')]"));
		
		WebElement passwordInput = driver.findElement(By.xpath("//input[contains(@placeholder, 'Password')]"));
		
		WebElement loginBtn = driver.findElement(By.xpath("//button[.//span[contains(text(), 'Submit')]]"));

		usernameInput.sendKeys("gayatri.tadeparti@wenable.com");
           
		passwordInput.sendKeys("Testing@1");

		loginBtn.click();
	
	    driver.close();

		}
		
		
	}


