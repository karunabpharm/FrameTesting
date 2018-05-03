package com.Argos.selectProduct;

import java.util.concurrent.TimeUnit;

import org.junit.rules.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SearchOption {
	
	ChromeDriver driver;
	@Given("^Open FireFox Browser and Navigate to Argos$")
	public void open_FireFox_Browser_and_Navigate_to_Argos() throws Throwable {
		driver=new ChromeDriver();
		driver.get("http://argos.co.uk");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	   
	}

	@When("^I enter the product \"([^\"]*)\"$")
	public void i_enter_the_product(String arg1) throws Throwable {
		driver.findElement(By.id("searchTerm")).sendKeys("nike");
		driver.findElement(By.className("argos-header__search-button")).click();
		driver.findElement(By.xpath(" //*[@id='app']/div/div/div[4]/div/div/div[3]/div[1]/div[2]/div[3]/div[5]/div/div[2]/div/button")).click();
		driver.findElement(By.xpath("//*[@id='app']/div/div/div[4]/div/div/div[1]/div/div/div[1]/div/div[2]/div[2]/div/div[2]/a[1]")).click();
	   
	}

	@Then("^I should see respective product$")
	public void i_should_see_respective_product() throws Throwable {
		
	   
	}


}
