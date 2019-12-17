package com.qa.tests;

import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.qa.base.TestBase;

public class CreateAsset extends TestBase
{
	@Test
	public void createAssetTest() throws InterruptedException 
	{
		driver.findElement(By.xpath("//img[@class='allTabsArrow']")).click();
		driver.findElement(By.xpath("//img[@alt='Assets']")).click();
		driver.findElement(By.id("tryLexDialogX")).click();
		
		driver.findElement(By.name("new")).click();
		
		driver.findElement(By.xpath("//label[text()='Asset Name']//parent::td//following-sibling::td//input")).sendKeys("Test Asset2");
		
		driver.findElement(By.xpath("//img[@alt='Product Lookup (New Window)']")).click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		String parentWindowHandle = driver.getWindowHandle();
		
		for(String i :windowHandles) 
		{
			if(!(i.equals(parentWindowHandle))) 
			{
				driver.switchTo().window(i);
			}
		}
		
		driver.switchTo().frame("searchFrame");
		driver.findElement(By.xpath("//input[@id='lksrch']")).sendKeys("GenWatt Diesel 1000kW");
		
		
		driver.findElement(By.xpath("//a[text()='GenWatt Diesel 1000kW']")).click();
		
		driver.switchTo().window(parentWindowHandle);
		//driver.switchTo().defaultContent();
		
		driver.findElement(By.id("Quantity")).clear();
		driver.findElement(By.id("Quantity")).sendKeys("2");
		
		driver.findElement(By.xpath("//label[@for='Description']//parent::td//following-sibling::td//textarea")).sendKeys("TestDescription");
		
		//Clicking the save button 
		driver.findElement(By.xpath("//input[@class='btn' and @name='save']")).click();
		
		Thread.sleep(4000);
		
	}
	

}
