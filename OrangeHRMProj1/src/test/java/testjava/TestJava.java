package testjava;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;


import io.github.bonigarcia.wdm.WebDriverManager;
import mainjava.BaseJava;
import mainjava.DashboardPage;
import mainjava.LoginPage;

public class TestJava extends BaseJava {
	
@BeforeClass
public void LaunchBrowser()
{
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.get("https://opensource-demo.orangehrmlive.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
}
@BeforeMethod
public void POM()
{
	loginpage=new LoginPage(driver);
	//dashboard=new DashboardPage(driver);
}
@AfterClass
public void QuitBrowser()
{
	driver.quit();
}
}
