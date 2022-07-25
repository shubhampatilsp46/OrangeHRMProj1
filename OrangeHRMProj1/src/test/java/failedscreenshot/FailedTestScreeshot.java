package failedscreenshot;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class FailedTestScreeshot {
	public String capture(WebDriver driver,String screenshotname) throws IOException
	{
		TakesScreenshot  t = (TakesScreenshot)driver;
		  
	    File srcFile = t.getScreenshotAs(OutputType.FILE);
	    String path= System.getProperty("user.dir")+"/failedTestScreenShot/"+screenshotname+".png";
	    File destFile = new File(path);
	    try {
	    FileUtils.copyFile(srcFile, destFile);
	 } 
	    catch (IOException e) {
	    e.printStackTrace();
	 }
	          
	return path;
	}
}
