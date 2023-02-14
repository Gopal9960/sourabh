package Module_1_login;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabLoginPage_2
{
	@FindBy(xpath="//input[@placeholder='Username']") private WebElement UN;
	@FindBy(xpath="//input[@placeholder='Password']") private WebElement PWD;
	@FindBy(xpath="//input[@id='login-button']") private WebElement login;
	@FindBy(xpath="//div[@class='bot_column']") private WebElement robot;
	
	public SwagLabLoginPage_2(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void inpSwagLabLoginPageun(String username)
	{
		UN.sendKeys(username);
	}
	public void inpSwagLabLoginPagepwd(String password)
	{
		PWD.sendKeys(password);
	}
	public void clickSwagLabLoginPageloginbtn()
	{
		login.click();
	}
	public void getSSrobot() throws IOException
	{
		File f3 = robot.getScreenshotAs(OutputType.FILE);
		
		File f4=new File("C:\\Users\\Suraj Bankar\\eclipse-workspace\\Selenium_Maven\\SreenShot\\ss_1.png");
		
		FileHandler.copy(f3, f4);
	}

}
