package com.base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Base {

		WebDriver driver;
		public Properties prop;
		public  Base() {
			 prop = new Properties();
			File proFile = new File(System.getProperty("user.dir")+"\\src\\com\\config\\config.properties");
			try {
			FileInputStream fis = new FileInputStream(proFile);
			prop.load(fis);
		}
			catch(Throwable e) {
				e.printStackTrace();
				}
			}

	public WebDriver initilizeBrowserAndOpenApplication(String browsername)
	{
		
		/*String browserName ="chrome";
		if(browserName.equals("chrome")) {
			
			driver = new ChromeDriver();
		}
		else if(browserName.equals("firefox")) {
			driver = new FirefoxDriver();
			
		}else if (browserName.equals("edge")) {
			driver = new EdgeDriver();
		}
		else if(browserName.equals("safari")) {
			driver = new SafariDriver();*/
		
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ranub\\Downloads\\chromedriver_win32 (4)\\chromedriver.exe");
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		 driver = new ChromeDriver(co);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(25));
		driver.get(prop.getProperty("url"));
		
		return driver;
	}
}
