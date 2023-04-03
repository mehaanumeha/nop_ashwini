package projects;



import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


import java.io.File;
import java.io.IOException;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.HTMLReporter;
public class ExtentDemo  {
	 WebDriver driver;
	 ExtentTest test;
 ExtentReports report;
@BeforeTest
public  void startTest()
{
	try {
	System.out.println("hiiiiiiiiiii");
	System.out.println(System.getProperty("user.dir"));
	
	
 String reportFileName = "Test-Automaton-Report"+".html";
 
report = new ExtentReports("D:\\workspace\\HealthCura\\ExtentReportResult.html");
System.out.println("11111111i");
HTMLReporter htmlReporter = new HTMLReporter(reportFileName);
System.out.println("2222222222");

test = report.startTest("ExtentDemo");
System.out.println("33333333333333");
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
}
@Test
public void extentReportsDemo() throws IOException
{
	WebDriverManager.chromedriver().setup();
driver = new ChromeDriver();
driver.get("https://www.facebook.com");

if(driver.getTitle().equals("Googl"))
{
test.log(LogStatus.PASS, "Navigated to the specified URL");
}
else
{
test.log(LogStatus.FAIL, "Test Failed");
test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "Test Failed");


}
}

public  String capture(WebDriver driver) throws IOException {
File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
File Dest = new File("D:\\workspace\\HealthCura\\ScreenShot\\" + System.currentTimeMillis()
+ ".png");
String errflpath = Dest.getAbsolutePath();
FileUtils.copyFile(scrFile, Dest);
return errflpath;

}







@AfterTest
public  void endTest()
{
report.endTest(test);
report.flush();
}
}