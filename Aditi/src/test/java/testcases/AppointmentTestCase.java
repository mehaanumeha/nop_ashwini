package testcases;

import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.MakeAppointment;
import utilities.BaseClass;

public class AppointmentTestCase extends BaseClass {
	
	
	@Test
	void makeAppointmnetBasicFlow()
	{
		driver.get("https://katalon-demo-cura.herokuapp.com/profile.php#login");
		LoginPage login  = new LoginPage(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		login.setUserName(global_username);
		log.info("enter username "+global_username);
		
		login.setPassword("ThisIsNotAPassword");
		log.info("enter username "+global_password);
		
		login.clickButton(); 
		log.info("clciked on login button ");
		
		
		MakeAppointment ma = new MakeAppointment(driver);
		ma.setFacilty("My facility");
		log.info("setting facility  as : ");
		
		ma.selectMedicalAid();
		log.info("selected aid ");
		
		ma.selectReadmission();
		log.info("option readmission selected ");
		
		ma.selectCalender();
		log.info("selecing calender ");
		
		ma.setDate();
		log.info("setting date");
		
		ma.setComment("anumeha");
		log.info("setting value");
		
		ma.bookAppointement();
		log.info("appointement fixed ");
		
	
		
		
	}

}
