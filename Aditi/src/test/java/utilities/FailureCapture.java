package utilities;

import java.io.File;
import java.io.IOException;

import com.relevantcodes.extentreports.LogStatus;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class FailureCapture extends BaseClass   implements ITestListener {

	public void onTestFailure(ITestResult result) {
		System.out.println(result.getStatus());
		
		try {	ExtentReportsClass rep = new ExtentReportsClass();
		System.out.println("creating object of  rep ");
		rep.startReport();
		System.out.println("start rep ");
	
		rep.getResult(result);
		System.out.println("get result");
	
		rep.endReport();
		System.out.println("end result");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
			
		}

	public void onTestSkipped(ITestResult result) {
		
	}

	

public  String capture(WebDriver driver) throws IOException {
	System.out.println("in capture==================");
File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
System.out.println("in capture==================");
File Dest = new File("D:\\workspace\\HealthCura\\ScreenShot\\" + System.currentTimeMillis()
+ ".png");
String errflpath = Dest.getAbsolutePath();
FileUtils.copyFile(scrFile, Dest);
System.out.println("in capture==================");
return errflpath;

}
}
