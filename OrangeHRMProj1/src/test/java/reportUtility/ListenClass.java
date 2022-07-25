package reportUtility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import failedscreenshot.FailedTestScreeshot;
import testjava.TestJava;

public class ListenClass extends  TestJava implements ITestListener{
	
	ExtentReports extent=CustomeReporter.extentReportGenerator();
	ExtentTest test;
	@Override
	
	public void onTestStart(ITestResult result) {
		test=extent.createTest(result.getMethod().getMethodName());		
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test case: "+result.getMethod().getMethodName()+" is passed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
	test.log(Status.FAIL, "Test case: "+result.getMethod().getMethodName()+" is Failed");
	FailedTestScreeshot fs=new FailedTestScreeshot();
	try {
		fs.capture(driver, result.getName());
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
                 
	
	}
	

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
		}
}
