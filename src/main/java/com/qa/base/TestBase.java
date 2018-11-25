package com.qa.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase 
{
	public static WebDriver driver;
	
	@BeforeMethod
	public void salesforceLogin() 
	{
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://login.salesforce.com");
		driver.manage().window().fullscreen();
		
		driver.findElement(By.id("username")).sendKeys("chandran.manu85@gmail.com");
		driver.findElement(By.id("password")).sendKeys("1313Man.");
		driver.findElement(By.id("Login")).click();
		
		
		//Implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void tearDown() 
	{
		driver.quit();
	}

}
