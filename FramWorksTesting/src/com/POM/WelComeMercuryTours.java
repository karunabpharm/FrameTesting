package com.POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WelComeMercuryTours 
{

	// Identification of the Element and Operation done on the Element is written and stored
	
	// we a Business logic to perform the Operations
	
	// OBject Repository
	
	
	//WebElement Register=driver.findElement(By.linkText("REGISTER"));
	
	@FindBy(linkText="REGISTER")
	WebElement register;
	
	
	public void Register() // Business Logic
	{
		register.click();
		
	}
	
	
	@FindBy(linkText="SUPPORT")
	WebElement support;
	
	public void Support()
	{
		support.click();
	}
	
	@FindBy(name="userName")
	WebElement Username;
	
	@FindBy(name="password")
	WebElement Passowrd;
	
	@FindBy(name="login")
	WebElement SignIN;
	
	

	public void FindAFlight(String Uname,String Pwd)
	
	{
		Username.sendKeys(Uname);
		Passowrd.sendKeys(Pwd);
		SignIN.click();
		
	}
	
	
}	
	 
	
	

