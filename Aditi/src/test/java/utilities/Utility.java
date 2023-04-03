package utilities;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utility {

public static String captureScreenshot(WebDriver driver, String screenshotName){

try {
TakesScreenshot ts=(TakesScreenshot)driver;

File source=ts.getScreenshotAs(OutputType.FILE);

String dest = "D:\\workspace\\HealthCura\\TestReport\\screenshots\\verifyPositiveLoginLogout\\"+"abc.png";

File destination = new File(dest);

FileUtils.copyFile(source, destination);

System.out.println("ScreenShot Taken");

return dest;

} catch (Exception e) {

System.out.println("Exception while taking Screenshot"+e.getMessage());
return e.getMessage();
}
}
}