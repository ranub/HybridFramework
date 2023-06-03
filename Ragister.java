package com.Testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.Base;
import com.utils.utilities;

public class Ragister extends Base{
 
	WebDriver driver;
	
	@BeforeMethod()
	public void setup() {
		driver= initilizeBrowserAndOpenApplication("chrome");
		driver.findElement(By.xpath("//span[text()=\"My Account\"]")).click();
		driver.findElement(By.linkText("Register")).click();
	}
	
	@AfterMethod()
	public void teardown() {

		driver.quit();
	}
	
	@Test(priority=1)
	public void RagisterAnAccount() {
		
		driver.findElement(By.id("input-firstname")).sendKeys("Arun");
		driver.findElement(By.id("input-lastname")).sendKeys("Motoori");
		driver.findElement(By.id("input-email")).sendKeys(utilities.generateEmailwithTimeStamp());
		driver.findElement(By.id("input-telephone")).sendKeys("1234567890");
		driver.findElement(By.id("input-password")).sendKeys("12345");
		driver.findElement(By.id("input-confirm")).sendKeys("12345");
		driver.findElement(By.xpath("//input[@name=\"agree\"]")).submit();
		driver.findElement(By.xpath("//input[@name=\"agree\"]")).click();
		driver.findElement(By.xpath("//input[@value=\"Continue\"]")).click();

		String actualSuccessHeading = driver.findElement(By.xpath("//div[@id=\"content\"]/h1")).getText();
		Assert.assertEquals(actualSuccessHeading, "Your Account Has Been Created!",
				"Account Success page is not displayed");

	}
	@Test(priority=2)
	public void verifyRagisteringAccountbyProvidingallFeilds()
	{
		
		driver.findElement(By.id("input-firstname")).sendKeys("Arun");
		driver.findElement(By.id("input-lastname")).sendKeys("Motoori");
		driver.findElement(By.id("input-email")).sendKeys(utilities.generateEmailwithTimeStamp());
		driver.findElement(By.id("input-telephone")).sendKeys("1234567890");
		driver.findElement(By.id("input-password")).sendKeys("12345");
		driver.findElement(By.id("input-confirm")).sendKeys("12345");
		driver.findElement(By.xpath("//input[@name=\"newsletter\"]")).click();
		
		driver.findElement(By.xpath("//input[@name=\"agree\"]")).click();
		driver.findElement(By.xpath("//input[@value=\"Continue\"]")).click();

		
		String actualSuccessHeading = driver.findElement(By.xpath("//div[@id=\"content\"]/h1")).getText();
		Assert.assertEquals(actualSuccessHeading, "Your Account Has Been Created!",
				"Account Success page is not displayed");


	}
	@Test(priority=3)
	public void ragisteringAccountWithInvalidEmailAdress() 
	{
	
		driver.findElement(By.id("input-firstname")).sendKeys("Arun");
		driver.findElement(By.id("input-lastname")).sendKeys("Motoori");
		driver.findElement(By.id("input-email")).sendKeys("amotooricap9@gmail.com");
		driver.findElement(By.id("input-telephone")).sendKeys("1234567890");
		driver.findElement(By.id("input-password")).sendKeys("12345");
		driver.findElement(By.id("input-confirm")).sendKeys("12345");
		driver.findElement(By.xpath("//input[@name=\"newsletter\"]")).click();
		
		driver.findElement(By.xpath("//input[@name=\"agree\"]")).click();
		driver.findElement(By.xpath("//input[@value=\"Continue\"]")).click();

		
		//String actualWarnig = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
	//	Assert.assertTrue(actualWarnig.contains("Warning: Email Address is already registerd!"),
		//		"warning message regarding duplicate email address is not displayed Success page is not displayed");

	
	}
		@Test(priority=4)
		public void ragisteringAccountWithWithoutFillingAnyDetaials() 
		{
		
			driver.findElement(By.xpath("//input[@value=\"Continue\"]")).click();

		String actualprivacyPolicyWarning = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		Assert.assertTrue(actualprivacyPolicyWarning.contains("Warning: You must agree to the Privacy Policy!"),"privacy policy warning is not displayed");
			
		String actualFirstNameWarning = driver.findElement(By.xpath("//input[@id=\"input-firstname\"]/following-sibling::div")).getText();
		Assert.assertEquals(actualFirstNameWarning,"First Name must be between 1 and 32 characters!","first name warning message is not displayed");
		
		String actuallastNameWarning = driver.findElement(By.xpath("//input[@id=\"input-lastname\"]/following-sibling::div")).getText();
		Assert.assertEquals(actuallastNameWarning,"Last Name must be between 1 and 32 characters!","last name warning message is not displayed");
		
		String actualEmailidWarning = driver.findElement(By.xpath("//input[@id=\"input-email\"]/following-sibling::div")).getText();
		Assert.assertEquals(actualEmailidWarning,"E-Mail Address does not appear to be valid!","Email warning message is not displayed");
		
		String actualTelephonicWarning = driver.findElement(By.xpath("//input[@id=\"input-telephone\"]/following-sibling::div")).getText();
		Assert.assertEquals(actualTelephonicWarning,"Telephone must be between 3 and 32 characters!","telephonic warning message is not displayed");
		
		String actualpasswordWarning = driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).getText();
		Assert.assertEquals(actualpasswordWarning,"Password must be between 4 and 20 characters!","password warning message is not displayed");
		
		
	}
		
		
		
}
