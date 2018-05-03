package hybridFrameWork;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Combination_DataDriver_Keyword {

	//public WebDriver driver;
	FirefoxDriver driver;
	
		@BeforeTest
		public void setUp()
		{
			driver = new FirefoxDriver();
			driver.get("http://newtours.demoaut.com");
			
			driver.manage().window().maximize();
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		
		
		@Test(priority=0)
		public void LogIn() throws IOException
		{
			
			FileInputStream file = new FileInputStream("C:\\Users\\karuna\\Desktop\\TestingScripts\\FramWorksTesting\\HybridFramework");
			
			Properties pr = new Properties();
			
			pr.load(file);
			
			
			driver.findElement(By.name(pr.getProperty("UserName"))).sendKeys("tutorial");
			driver.findElement(By.name(pr.getProperty("Password"))).sendKeys("tutorial");
			driver.findElement(By.name(pr.getProperty("SignIn"))).click();
			
			String expected_Title ="Find";
			String actual_Title=driver.getTitle();
			
			Assert.assertTrue(actual_Title.contains(expected_Title),"Title not Matched , LogIn Failed -- FAIL");
		}
			
			@Test(priority=1)
			public void  NewUserRegistrarion() {
				
				
			}

	}


