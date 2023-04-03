package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SlProductPage {
	
	
	WebDriver ldriver;
	
  public SlProductPage(WebDriver driver)
	{
	    ldriver= driver;
		PageFactory.initElements(driver, this);
	}
  
  
  @FindBy(xpath = "//span[@class='title']")
  WebElement  productLabel;
  
  @FindBy(xpath="//div[@class='inventory_item_price']")
  List <WebElement>  priceBar;
  
 public  List getValue()
  {
	return priceBar;
	
	  
  }
 
 public boolean getProductLabelStaus()
 {
	Boolean res= productLabel.isDisplayed();
	return res;
	 
 }
  
  
  
	

}
