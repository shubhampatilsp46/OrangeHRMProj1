package testjava;

import dataproviderUtility.dataproviderRead;
import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import dataproviderUtility.ExcelDataProvider;

public class LoginPageTest extends TestJava {
	@Test(priority=0)
	public void verifyURL()
	{
		String actualUrl=loginpage.verifyURL1();
		Assert.assertEquals(actualUrl, "https://opensource-demo.orangehrmlive.com/");
	}
	@Test(priority=0)
	public void verifyTitle()
	{
		String actualTitle=loginpage.verifyTitle1();
		Assert.assertEquals(actualTitle, "OrangeHRMa");
	}
	@DataProvider(name="empLogin")
	public Object[][] loginData() {
		dataproviderRead ds=new dataproviderRead();
		Object[][] arrayObject = ds.getExcelData("C:\\Users\\Neosoft\\eclipse-workspace\\OrangeHRMProj1\\TestData\\LoginPageTestData.xlsx", "Login");
		return arrayObject;
	}
	@Test(priority=1,dataProvider="empLogin")
	public void verifyLogin(String userName, String userName1)  throws IOException, InterruptedException
	{
		//ExcelDataProvider exc= new ExcelDataProvider();
	//loginpage.verifylogincredential(exc.getStringData("Login", 0, 0),exc.getStringData("Login", 0, 1));
	//loginpage.verifylogincredential(exc.getStringData("Login", 1, 0),exc.getStringData("Login", 1, 1));
		loginpage.verifylogincredential(userName,userName1);
	Reporter.log("Verify Login with Correct cre",true);
	}
}
