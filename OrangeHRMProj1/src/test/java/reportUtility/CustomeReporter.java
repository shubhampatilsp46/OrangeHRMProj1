package reportUtility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class CustomeReporter {
	public static ExtentReports extent;
	public static ExtentReports extentReportGenerator()
	{
		String path=System.getProperty("user.dir")+".\\OrangerHrmReport\\report.html";
		ExtentHtmlReporter reporter = new ExtentHtmlReporter(path);
		
		reporter.config().setReportName("Regression Test Report1");

		reporter.config().setDocumentTitle("Regression Test cases1");

		reporter.config().setTheme(Theme.STANDARD);
		
		 extent = new ExtentReports();
		
		extent.attachReporter(reporter);
		
		extent.setSystemInfo("OS", "Windows");
		extent.setSystemInfo("Organization", "Neosoft");		
		return extent;
		}
}
