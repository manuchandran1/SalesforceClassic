package com.qa.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class AssetChangeDate 

{
	@Test
	public static void AssetDateTest() throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().fullscreen();
		
		//driver.manage().timeouts().implicitlyWait(6000, TimeUnit.SECONDS);
		
		driver.get("https://login.salesforce.com");
		driver.findElement(By.id("username")).sendKeys("chandran.manu85@gmail.com");
		driver.findElement(By.id("password")).sendKeys("1313Man.");
		driver.findElement(By.id("Login")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@class='allTabsArrow']"))).click();
		//driver.findElement(By.xpath("//img[@class='allTabsArrow']")).click();
		
		driver.findElement(By.xpath("//img[@alt='Assets']")).click();
		
		driver.findElement(By.id("tryLexDialogX")).click();
		
		driver.findElement(By.xpath("//th[text()='Asset Name']//parent::tr//following-sibling::tr//th//a")).click();
		
		driver.findElement(By.xpath("//td[@id='topButtonRow']//input[@value=' Edit ']")).click();
		
		driver.findElement(By.id("PurchaseDate")).click();
		
		driver.findElement(By.id("PurchaseDate")).clear();
		driver.findElement(By.id("PurchaseDate")).sendKeys("8/11/1996");
		
		driver.findElement(By.xpath("//td[@id='topButtonRow']//input[@name='save']")).click();
		
		
		Thread.sleep(3000);
		

	}
	

}
