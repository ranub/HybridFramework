package com.Testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.Base;

public class Search extends Base {

WebDriver driver;
	 
	
	@BeforeMethod()
	public void setup() 
	{
		driver=initilizeBrowserAndOpenApplication("chrome");
}
	
	@AfterMethod()
	
	public void teardown() {
		
		driver.quit();
		
	}
	
	@Test(priority=1)
	public void verifyProductWithValidProduct() 
	{
		driver.findElement(By.xpath("//input[@name='search']")).sendKeys("HP");
		driver.findElement(By.xpath("//div[@id=\"search\"]/span/button/i")).click();
		Assert.assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed(),"valid product hp is not displayed");
}
	@Test(priority=2)
	public void verifySearchWithInvalidProduct() 
	{
		driver.findElement(By.xpath("//input[@name='search']")).sendKeys("Honda");
		driver.findElement(By.xpath("//div[@id=\"search\"]/span/button/i")).click();
		String actualSearchMessage = driver.findElement(By.xpath("//*[@id=\"content\"]/p[2]")).getText();
		Assert.assertEquals(actualSearchMessage, "There is no product that matches the search criteria.","No product message in search result not displayed");
			
}
	
	@Test(priority=3)
	public void verifySearchProductWithoutInteringAnything() 
	{
		driver.findElement(By.xpath("//input[@name='search']")).sendKeys("");
		driver.findElement(By.xpath("//div[@id=\"search\"]/span/button/i")).click();
		String actualSearchMessage = driver.findElement(By.xpath("//*[@id=\"content\"]/p[2]")).getText();
		Assert.assertEquals(actualSearchMessage, "There is no product that matches the search criteria.","No product message in search result not displayed");
			
}	
	
	
	
	
	
	
	
	
	
}	