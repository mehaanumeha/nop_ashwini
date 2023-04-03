package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// load the elements which are required for testing 
//  doing action using these elements
public class LoginPage {
	
	WebDriver ldriver;
	
  public LoginPage(WebDriver driver)
	{
	    ldriver= driver;
		PageFactory.initElements(driver, this);
		//initElements(new DefaultElementLocatorFactory(driverRef), page);
	}
	
	
	
		
	@FindBy(id="txt-username")
	WebElement usernameElement;
	

	@FindBy(id="txt-password")
	WebElement passwordElement;

	

	@FindBy(id="btn-login")
	WebElement buttonElement;
	
	
	
	public void setUserName(String username)
	{
		usernameElement.sendKeys(username);
	}
	
	
	public void setPassword(String password)
	{
		passwordElement.sendKeys(password);
	}
	
	
	public  void clickButton()
	 {
		buttonElement.click();
	 }
	
	
	

	
	
}
