package utilities;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.HTMLReporter;

import org.testng.annotations.BeforeTest;

public class SupportReport {
	
	  ExtentTest test;
	 ExtentReports report;

	public   SupportReport()
	{
		try {
		System.out.println("hiiiiiiiiiii");
		System.out.println(System.getProperty("user.dir"));
		
		
	
	 
	report = new ExtentReports("D:\\workspace\\HealthCura\\ExtentReportResult.html");
	System.out.println("11111111i");
	
	System.out.println("2222222222");

	test = report.startTest("ExtentDemo");
		}catch(Exception e)
		{
			System.out.println(e);
		}

}
		}
