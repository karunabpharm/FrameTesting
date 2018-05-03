package com.Argos.selectProduct;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Steps {
	ChromeDriver driver;
	@Given("^Open Chrome Browser and Navigate to FaceBook Home Page$")
	public void open_Chrome_Browser_and_Navigate_to_FaceBook_Home_Page() throws Throwable {
		
		driver=new ChromeDriver();
		driver.get("http://Facebook.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}

	@When("^User Enter Valid UserId PassWord And Click$")
	public void user_Enter_Valid_UserId_PassWord_And_Click() throws Throwable {
		driver.findElement(By.id("email")).sendKeys("Email");
		driver.findElement(By.id("pass")).sendKeys("Password");
		driver.findElement(By.id("login")).click();
	  
	}

	@Then("^user Can see FaceBook Home Page$")
	public void user_Can_see_FaceBook_Home_Page() throws Throwable {
		driver.close();
	   
	}


}
