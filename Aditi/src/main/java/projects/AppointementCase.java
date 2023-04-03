package projects;

import org.testng.annotations.Test;

public class AppointementCase  extends Base{
	
	
	@Test
	void makeAppointmnet()
	{
		driver.get(url);
		LoginPage lPage = new LoginPage(driver);
	      lPage.setUsernamElement(global_username);
	      lPage.setPassElement(global_password);
	      lPage.clickLoginButton();
	      
		
	}


}
