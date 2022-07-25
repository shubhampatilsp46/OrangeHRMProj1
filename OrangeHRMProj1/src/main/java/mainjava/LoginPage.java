package mainjava;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseJava {
@FindBy(id="txtUsername")
WebElement username;

@FindBy(id="txtPassword")
WebElement password;

@FindBy(id="btnLogin")
WebElement btnlogin;


public LoginPage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver,this);
}

public String verifyURL1()
{
	String url=driver.getCurrentUrl();
	return url;
}

public String verifyTitle1()
{
	String title=driver.getTitle();
	return title;
}

public void verifylogincredential(String uName,String pWord) throws InterruptedException
{
	username.sendKeys(uName);
	password.sendKeys(pWord);
	btnlogin.click();
	Thread.sleep(3000);
}
}
