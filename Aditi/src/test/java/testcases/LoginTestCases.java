package testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.LoginPage;
import projects.Base;
import utilities.BaseClass;
import utilities.ExcelUtility;
import utilities.ListenToFailiure;

@Listeners({ListenToFailiure.class })
public class LoginTestCases extends BaseClass {
	
	
	@DataProvider
	Object readData() throws IOException // creating | reading the data and will give the data  to another method 
	{
		String loc="D:\\workspace\\HealthCura\\resources\\LoginDataResource.xlsx";
		ExcelUtility read = new ExcelUtility(loc);
	    int rows= read.getRowCount("Sheet1");
	    int cols = read.getCellCount("Sheet1", rows);
		
		Object[][] data = new Object[rows][cols];  // creating two dim array
		
		for(int i = 1;i<=rows;i++)
		{
			for(int j=0;j<cols;j++)
			{
				    data[i-1][j]=  read.getCellData("Sheet1",i, j);
			}
			
		}
		
		
		
		return data;
	}
	
	
	//@Test(dataProvider = "readData")
	void verifyValidUser(String user, String pass)
	{
		System.out.println(user);
		System.out.println(pass);
		
	//	driver.get("https://katalon-demo-cura.herokuapp.com/profile.php#login");
	//	LoginPage login  = new LoginPage(driver);
	//	login.setUserName(user);
	//	login.setPassword(pass);
		//
		//login.clickButton(); 
		
		
		
	
	}
	
	
	@Test()
	void verifyPositiveLoginLogout()
	{ 
		
		driver.get("https://katalon-demo-cura.herokuapp.com/profile.php#login");
		LoginPage login  = new LoginPage(driver);
		//driver.findElement(By.xpath("")).click();
		Assert.assertTrue(false);
		login.setUserName("user");
		login.setPassword("pass");
		login.clickButton(); 
		
		
		
	
	}

}
