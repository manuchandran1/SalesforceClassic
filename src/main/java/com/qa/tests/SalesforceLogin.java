package com.qa.tests;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

@Test
public class SalesforceLogin 
{
	public void LoginTest() throws InterruptedException, IOException 
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
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='phSearchButton']//parent::div//preceding-sibling::div//input")));
		driver.findElement(By.xpath("//input[@id='phSearchButton']//parent::div//preceding-sibling::div//input")).sendKeys("Test");
		
		//driver.findElement(By.xpath("//input[@id='phSearchButton']//parent::div//preceding-sibling::div//input")).sendKeys("Test");
		
		
		//driver.findElement(By.xpath("//input[@id='phSearchButton']")).click();

		WebElement allTAbsButton = driver.findElement(By.xpath("//img[@class='allTabsArrow']"));
		allTAbsButton.click();
		
		driver.findElement(By.xpath("//img[@alt='Accounts']")).click();
		driver.findElement(By.xpath("//a[@id='tryLexDialogX']")).click();
		driver.findElement(By.xpath("//th[@class=' dataCell  ']/a")).click();

		WebElement Accoungt_Link = driver.findElement(By.xpath("//td[text()='Account Owner']//following-sibling::td//a//following-sibling::a"));
		System.out.println(Accoungt_Link.getText());
		Actions act = new Actions (driver);
		act.moveToElement(Accoungt_Link).perform();
		
		Date currentDate = new Date();
		SimpleDateFormat sf_date = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
		String DateString = sf_date.format(currentDate)+".png";
		
		
		//String mobile = driver.findElement(By.xpath("//span[@class='phoneNumberCategory']//parent::div")).getText();
		
		//System.out.println("Mobie Number is "+mobile);
		TakesScreenshot ss = (TakesScreenshot)driver;
		File screenshotFile = ss.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(System.getProperty("user.dir")+"/Screenshots/"+ DateString));
		
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='phoneNumberCategory']//parent::div")));
		String phoneNumber = driver.findElement(By.xpath("//span[@class='phoneNumberCategory']//parent::div")).getText();
		System.out.println("Phone Number : "+phoneNumber);
		
		Thread.sleep(3000);
		driver.quit();
	}

}
