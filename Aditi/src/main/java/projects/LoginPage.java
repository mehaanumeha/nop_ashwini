package projects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	


	WebDriver ldriver;
	
	public LoginPage(WebDriver driver) {

		ldriver=driver;
		PageFactory.initElements(driver,this);
	}
	
    
	
	
	@FindBy(id="txt-username")
	WebElement usernamElement;
	
	
	@FindBy(id="txt-password")
	WebElement passElement;
	
	@FindBy(id="btn-login")
	WebElement login;
	
	
	
	public void setUsernamElement(String user) {
		usernamElement.sendKeys(user);
		}



		public void setPassElement(String pass) {
			passElement.sendKeys(pass);
		}



		public void clickLoginButton() {
			login.click();
		}

}
