package utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
/*
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;*/
import java.util.*;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.Augmenter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenToFailiure extends BaseClass   implements ITestListener{



	/*public void onTestFailure(ITestResult result) {
		BaseClass base= new BaseClass();
		System.out.println("==================="+result.getName());
		System.out.println("==================="+result.getStatus());
		System.out.println("==================="+result.getMethod());
		System.out.println("==================="+result.getTestName());
		System.out.println("==================="+result.getStartMillis());
		try {
			base.failed(result.getName());
			
		}
		catch (Exception e) {System.out.println(e);	}
		
	}*/


	
	/*
	 * 
	 * 
	 * 
	 * public void onStart(ITestContext context) {
	 * System.out.println("*** Test Suite " + context.getName() + " started ***"); }
	 * 
	 * public void onFinish(ITestContext context) {
	 * System.out.println(("*** Test Suite " + context.getName() + " ending ***"));
	 * ExtentTestManager.endTest(); ExtentManager.getInstance().flush(); }
	 * 
	 * public void onTestStart(ITestResult result) {
	 * System.out.println(("*** Running test method " +
	 * result.getMethod().getMethodName() + "..."));
	 * ExtentTestManager.startTest(result.getMethod().getMethodName()); }
	 * 
	 * public void onTestSuccess(ITestResult result) {
	 * System.out.println("*** Executed " + result.getMethod().getMethodName() +
	 * " test successfully..."); ExtentTestManager.getTest().log(Status.PASS,
	 * "Test passed"); }
	 * 
	 * 
	 * 
	 * public void onTestSkipped(ITestResult result) {
	 * System.out.println("*** Test " + result.getMethod().getMethodName() +
	 * " skipped..."); ExtentTestManager.getTest().log(Status.SKIP, "Test Skipped");
	 * }
	 * 
	 * public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	 * System.out.println("*** Test failed but within percentage % " +
	 * result.getMethod().getMethodName()); }
	 * 
	 * public void onTestFailure(ITestResult result) {
	 * 
	 * ExtentTestManager.getTest().info("*** Test execution " +
	 * result.getMethod().getMethodName() + " failed...");
	 * ExtentTestManager.getTest().info((result.getMethod().getMethodName() +
	 * " failed!"));
	 * 
	 * ITestContext context = result.getTestContext(); WebDriver driver =
	 * (WebDriver) context.getAttribute("driver");
	 * 
	 * String targetLocation = null;
	 * 
	 * String testClassName =result.getName();
	 * 
	 * 
	 * Timestamp timestamp=new Timestamp(System.currentTimeMillis()); String
	 * timeStamp = timestamp.toString(); //Util.getCurrentTimeStamp(); // get
	 * timestamp String testMethodName = result.getName().toString().trim(); String
	 * screenShotName = testMethodName + timeStamp + ".png"; String fileSeperator =
	 * System.getProperty("file.separator"); String reportsPath =
	 * System.getProperty("user.dir") + fileSeperator + "TestReport" + fileSeperator
	 * + "screenshots";
	 * ExtentTestManager.getTest().info("Screen shots reports path - " +
	 * reportsPath); try { File file = new File(reportsPath + fileSeperator +
	 * testClassName); // Set // screenshots // folder if (!file.exists()) { if
	 * (file.mkdirs()) { ExtentTestManager.getTest().info("Directory: " +
	 * file.getAbsolutePath() + " is created!"); } else {
	 * ExtentTestManager.getTest().info("Failed to create directory: " +
	 * file.getAbsolutePath()); }
	 * 
	 * }
	 * 
	 * System.out.println(fileSeperator); System.out.println(testClassName);
	 * System.out.println(screenShotName); System.out.println(reportsPath); File
	 * screenshotFile = ((TakesScreenshot)
	 * getDriver()).getScreenshotAs(OutputType.FILE);
	 * 
	 * 
	 * targetLocation = reportsPath + fileSeperator + testClassName+"\\";// define
	 * System.out.println("--------------"+targetLocation);
	 * 
	 * String save=targetLocation+"\\"+testMethodName ;
	 * //System.out.println("yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy"+save); //
	 * FileUtils.copyFile(screenshotFile, new File(save+ timeStamp +".jpg"));
	 * FileUtils.copyFile(screenshotFile, new
	 * File(targetLocation+"\\"+testClassName+".jpeg"));;
	 * 
	 * 
	 * //File targetFile = new File(targetLocation); //
	 * targetFile.setReadable(true); //read // targetFile.setWritable(true); //write
	 * // targetFile.setExecutable(true);
	 * 
	 * 
	 * // ExtentTestManager.getTest().info("Screen shot file location - " +
	 * screenshotFile.getAbsolutePath()); //
	 * ExtentTestManager.getTest().info("Target File location - " +
	 * targetFile.getAbsolutePath()); // FileHandler.copy(screenshotFile,
	 * targetFile);
	 * 
	 * } catch (FileNotFoundException e) { System.out.println(e);
	 * ExtentTestManager.getTest().
	 * info("File not found exception occurred while taking screenshot " +
	 * e.getMessage()); } catch (Exception e) { System.out.println(e);
	 * ExtentTestManager.getTest().
	 * info("An exception occurred while taking screenshot " + e.getCause()); }
	 * 
	 * // attach screenshots to report try {
	 * 
	 * 
	 * 
	 * // ExtentTestManager.getTest().log(Status.FAIL,ExtentTestManager.getTest().
	 * addScreenCaptureFromPath(targetLocation+"\\")+ "Test Failed");
	 * 
	 * // ExtentTestManager.getTest().fail("Screenshot", //
	 * MediaEntityBuilder.createScreenCaptureFromPath(targetLocation+"\\").build());
	 * 
	 * 
	 * // ExtentTestManager.getTest().fail("details",
	 * MediaEntityBuilder.createScreenCaptureFromPath(
	 * "D:\\workspace\\HealthCura\\TestReport\\screenshots\\verifyPositiveLoginLogout\\"
	 * ).build());
	 * 
	 * } catch (Exception e) { System.out.println(e);
	 * 
	 * ExtentTestManager.getTest().
	 * info("An exception occured while taking screenshot " + e.getCause()); }
	 * ExtentTestManager.getTest().log(Status.FAIL, "Test Failed");
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * }
	 */
}
