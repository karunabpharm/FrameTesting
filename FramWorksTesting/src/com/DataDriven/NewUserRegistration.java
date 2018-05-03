package com.DataDriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewUserRegistration
{
//FirefoxDriver driver;
	
	ChromeDriver driver;
	
	@BeforeTest
	public void setUp()
	{
		
	//	System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
	//	driver = new FirefoxDriver();
		
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://newtours.demoaut.com");
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
	}
	
	@Test(priority=1)
	public void Register()
	{
		driver.findElementByLinkText("REGISTER").click();
	}
	
	@Test(priority=2)
	public void NewUserRegistration() throws IOException, InterruptedException
	{
		FileInputStream file = new FileInputStream("C:\\Users\\karuna\\Desktop\\TestingScripts\\FramWorksTesting\\src\\com\\ExcelTetDataFiles\\NewUserRegistrationTestData.xlsx");
		XSSFWorkbook workBook = new XSSFWorkbook(file);
		XSSFSheet sheet = workBook.getSheet("Sheet1");
		
				
		int RowCount=sheet.getLastRowNum();
		for(int i=1;i<=RowCount;i++)
		{
		
			Row r=sheet.getRow(i);
			
			driver.findElementByName("firstName").clear();
		driver.findElementByName("firstName").sendKeys(r.getCell(0).getStringCellValue());
		
		driver.findElementByName("lastName").clear();
		driver.findElementByName("lastName").sendKeys(r.getCell(1).getStringCellValue());
		
		double d=r.getCell(2).getNumericCellValue();
		long New=(long)d;
		String PhoneNo=Long.toString(New);
		
		driver.findElementByName("phone").clear();
		driver.findElementByName("phone").sendKeys(PhoneNo);
		
		 driver.findElementByName("userName").clear();
	    driver.findElementByName("userName").sendKeys(r.getCell(3).getStringCellValue());
	    
	    
	    driver.findElementByName("address1").clear();
	    driver.findElementByName("address1").sendKeys(r.getCell(4).getStringCellValue());
	   // driver.findElementByName("address2").sendKeys(r.getCell(5).getStringCellValue());
	    
	    driver.findElementByName("city").clear();
	    driver.findElementByName("city").sendKeys(r.getCell(5).getStringCellValue());
	    
	    driver.findElement(By.name("state")).clear();
	    driver.findElement(By.name("state")).sendKeys(r.getCell(6).getStringCellValue());
	    
	    
	    double x=r.getCell(7).getNumericCellValue();
	    
	    long y = (long)x;
	    
	    String PostalCode=Long.toString(y);
	    
	    
	    driver.findElementByName("postalCode").clear();
	    driver.findElementByName("postalCode").sendKeys(PostalCode);
	    driver.findElementByName("country").sendKeys(r.getCell(8).getStringCellValue());
	    
	    driver.findElementById("email").clear();
	    driver.findElementById("email").sendKeys(r.getCell(9).getStringCellValue());
	    
	    driver.findElementByName("password").clear();
	    driver.findElementByName("password").sendKeys(r.getCell(10).getStringCellValue());
	    
	    driver.findElementByName("confirmPassword").clear();
	    driver.findElementByName("confirmPassword").sendKeys(r.getCell(11).getStringCellValue());
	    
	  //  Sleeper.sleepTightInSeconds(5);
	    driver.findElementByName("register").click();
	    
	       
	   
	   String ExpectedUserName=r.getCell(9).getStringCellValue();
	   
	   String ActualText=driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[3]/a/font/b")).getText();
	   
	 //  Sleeper.sleepTightInSeconds(5);
	   if(ActualText.contains(ExpectedUserName))
	   {
		   System.out.println("User Registed Successfully -- PASS");
		   r.createCell(12).setCellValue(" User Registed Successfully -- PASS");
		   
		   
	   }
	   else
	   {
		   System.out.println("User REgistration Fail");
		   r.createCell(12).setCellValue("User Registration Failed -- FAIL");
	   }
	   
	   	   
	      
	  // Sleeper.sleepTightInSeconds(5);

	   FileOutputStream file1 = new FileOutputStream("C:\\Users\\karuna\\Desktop\\TestingScripts\\FramWorksTesting\\src\\com\\ExcelTestResultsFiles\\NewUserRegistationResult2.xlsx");
	   workBook.write(file1);
	   
	   driver.navigate().back();
	   
	   Thread.sleep(5000);
		}
		
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}

}
