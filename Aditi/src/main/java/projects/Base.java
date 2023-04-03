package projects;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Base{
	
	ReadProperties read = new ReadProperties();
	protected   String global_username = read.getUsername();
	protected  String global_password = read.getPassword();
	protected  String url=read.getUrl();
	protected  String browser = read.getBrowser();
	public static Logger  log;
	
	protected static WebDriver driver;
	
	@BeforeTest
	public void setup()
	{
		
		if(browser.equals("chrome"))
		{
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		log = Logger.getLogger("health cura");
		PropertyConfigurator.configure("logfile.properties");
		}
		

		
	}
	
	@AfterTest
	public void tear()
	{
		driver.quit();
	}
	
	
	
	
	
	
	
	
	public void failed(String name) throws IOException
	{
		
        File srcFile=    ( (TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File("D:\\workspace\\HealthCura\\ScreenShot\\"+name+".png"));
	}    

	

}
