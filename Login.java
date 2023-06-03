package com.Testcases;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.Base;
import com.utils.utilities;

public class Login extends Base{
	

	 public Login() {
		 super();
	 }
	WebDriver driver;
	
	
	@BeforeMethod()
	public void setup() {
  
		driver=initilizeBrowserAndOpenApplication(prop.getProperty("browserName"));
	driver.findElement(By.xpath("//span[text()=\"My Account\"]")).click();
	driver.findElement(By.linkText("Login")).click();
	
}
    @AfterMethod()
	public void teardown() {

		driver.quit();
	}

	@Test(priority = 1)

	public void verifyLoginPageWithValidData() {
		
		driver.findElement(By.id("input-email")).sendKeys("amotooricap9@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("12345");
		driver.findElement(By.xpath("//input[@value=\"Login\"]")).click();

		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed(),
				"edit your account information option is not displayed");

		
	}

	@Test(priority = 2)
	public void LoginWithInvalidData() {
		
		driver.findElement(By.id("input-email")).sendKeys(utilities.generateEmailwithTimeStamp());
		driver.findElement(By.id("input-password")).sendKeys("1234534556");
		driver.findElement(By.xpath("//input[@value=\"Login\"]")).click();

		/*
		 * String actualwarningMassege =
		 * driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).
		 * getText(); String expectedWarningMessage =
		 * "Warning: No Match for Email Address and/or Password.";
		 * Assert.assertTrue(actualwarningMassege.contains(expectedWarningMessage),
		 * "Expected Warning Message is not displayed"); driver.quit();
		 */
	}

	@Test(priority = 3)
	public void LoginWithInvalidEmailandValidPassword() {
		
		driver.findElement(By.id("input-email")).sendKeys("amotooricap9\"+generateTimeStamp()+\"@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("12345");
		driver.findElement(By.xpath("//input[@value=\"Login\"]")).click();
	}

	@Test(priority = 4)
	public void LoginWithValidEmailandInvalidPassword() {
	
		driver.findElement(By.id("input-email")).sendKeys("amotooricap9@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("123452345566");
		driver.findElement(By.xpath("//input[@value=\"Login\"]")).click();
	}

	@Test(priority = 5)
	public void LoginWithWithoutProvidingCredencial() {
		
		driver.findElement(By.id("input-email")).sendKeys("");
		driver.findElement(By.id("input-password")).sendKeys("");
		driver.findElement(By.xpath("//input[@value=\"Login\"]")).click();
	}
	
	
	}

	
	
