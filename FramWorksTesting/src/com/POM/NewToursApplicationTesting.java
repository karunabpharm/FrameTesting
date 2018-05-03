package com.POM;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class NewToursApplicationTesting 
{

	@Test
	public void HomePage()
	{
		
		System.setProperty("webdriver.gecko.driver","C:\\Users\\karuna\\Desktop\\TestingScripts\\FramWorksTesting\\DriverFiles\\geckodriver.exe");
		
		FirefoxDriver driver = new FirefoxDriver();
		
		driver.get("http://newtours.demoaut.com");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		WelComeMercuryTours  WMT = PageFactory.initElements(driver, WelComeMercuryTours.class);
		
		WMT.Register();
		driver.navigate().back();
		
		
		WMT.Support();
		driver.navigate().back();
		
		
		WMT.FindAFlight("tutorial", "tutorial");
		driver.navigate().back();
		
		driver.close();
	}
	
	
	
	
	
	
}
