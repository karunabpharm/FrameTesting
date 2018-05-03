package com.NewToursApplication;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class LogInTest 
{
	ChromeDriver driver;
	@Given("^Open FireFox Browser and Navigate to NewTours Application$")
	public void open_FireFox_Browser_and_Navigate_to_NewTours_Application() throws Throwable
	{
		driver = new ChromeDriver();
		driver.get("http://newtours.demoaut.com");
	}

	@When("^User enters Valid \"([^\"]*)\" and Valid \"([^\"]*)\" and click on SignIn button$")
	public void user_enters_Valid_and_Valid_and_click_on_SignIn_button(String UserName, String Password) throws Throwable 
	{
		driver.findElement(By.name("userName")).sendKeys(UserName);
		driver.findElement(By.name("password")).sendKeys(Password);
		driver.findElement(By.name("login")).click();
		
		String expected_Title="Find";
		String actual_Title=driver.getTitle();
	
		Assert.assertTrue("Title not mathed --LogIN Fail", actual_Title.contains(expected_Title));
	}

	@Then("^User should be able to successfully LogiIn and close the Applciation$")
	public void user_should_be_able_to_successfully_LogiIn_and_close_the_Applciation() throws Throwable
	{
		driver.close();
	}

}
