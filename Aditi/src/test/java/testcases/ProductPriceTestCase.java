package testcases;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.SLLoginPage;
import pages.SlProductPage;
import utilities.BaseClass;

public class ProductPriceTestCase extends BaseClass{
	
	
	@Test
	void verifyHighestPrice() throws InterruptedException
	{
		driver.get("https://www.saucedemo.com/");
		SLLoginPage slogin = new SLLoginPage(driver);
		slogin.setUserName("standard_user");
		slogin.setPassword("secret_sauce");
		slogin.clickButton();
		Thread.sleep(3000);
		SlProductPage sp = new SlProductPage(driver);
		
		Assert.assertEquals(sp.getProductLabelStaus(), true);
		
		List<WebElement> val =sp.getValue();

		int arr[] =  new int[val.size()];
		// initialize array
    for (WebElement webElement : val) {
	System.out.println();
	String str=  new String(webElement.getText());
	arr[] = Integer.parseInt((str).substring(1));
	
	// inside array
	
 }
   
   
		// find the highest 
		
	}
	
	
	@Test
	void verifyLowestPrice() throws InterruptedException
	{
		driver.get("https://www.saucedemo.com/");
		SLLoginPage slogin = new SLLoginPage(driver);
		slogin.setUserName("standard_user");
		slogin.setPassword("secret_sauce");
		slogin.clickButton();
		Thread.sleep(3000);
		SlProductPage sp = new SlProductPage(driver);
		List<WebElement> val =sp.getValue();

   for (WebElement webElement : val) {
	System.out.println(webElement.getText());
	// find the lowest 
 }
	
	}


}
