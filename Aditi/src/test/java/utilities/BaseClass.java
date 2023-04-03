package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
public class BaseClass {
	
	ReadConfigFile read = new ReadConfigFile();
	protected  String global_username = read.getUsername();
	protected  String global_password = read.getPassword();
	protected  String url=read.getUrl();
	protected  String browser = read.getBrowser();
	public static Logger log;
	protected static WebDriver driver;
	
	@BeforeTest
	public void setup()
	{		  
			if(browser.equals("chrome"))
			{
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
			log = Logger.getLogger("Healthcura");
			PropertyConfigurator.configure("logfile.properties");
			
			}
			if(browser.equals("firefox"))
			{
				
		//		WebDriverManager.firefoxdriver().setup();
			    System.setProperty("webdriver.gecko.driver",".\\src\\test\\resources\\driver\\geckodriver.exe");
				driver = new FirefoxDriver();
				log = Logger.getLogger("Healthcura");
				PropertyConfigurator.configure("logfile.properties");
				
				
			}
			if(browser.equals("edge"))
			{
			WebDriverManager.edgedriver().setup();
			driver= new EdgeDriver();
			log = Logger.getLogger("Healthcura");
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
	
	WebDriver getDriver()
	{
		return driver;
	}
}
