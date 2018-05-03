package com.NewToursLogInTest.MyMavenProject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class LogInTest 
{

	//FirefoxDriver driver;
	
	ChromeDriver driver;
	
	@BeforeTest
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\karuna\\Desktop\\TestingScripts\\MyMavenProject\\DriverFiles\\chromedriver.exe");
		
		//driver = new FirefoxDriver();
		driver = new ChromeDriver();
		driver.get("http://newtours.demoaut.com");
		
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
	@Test
	public void LogIn()
	{
		driver.findElement(By.name("userName")).sendKeys("tutorial");
		driver.findElement(By.name("password")).sendKeys("tutorial");
		driver.findElement(By.name("login")).click();
		
		String expected_Title="Find";
		String actual_Title=driver.getTitle();

		Assert.assertTrue("Title Not Matched -- FAIL", actual_Title.contains(expected_Title));
	
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
	
	
	
	
}
