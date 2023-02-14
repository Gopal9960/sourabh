package Module_1_login;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabLoginPage_5
{
	@FindBy(xpath="//input[@placeholder='Username']") private WebElement UN;
	@FindBy(xpath="//input[@placeholder='Password']") private WebElement PWD;
	@FindBy(xpath="//input[@id='login-button']") private WebElement login;
	@FindBy(xpath="//div[@class='bot_column']") private WebElement robot;
	
	public SwagLabLoginPage_5(WebDriver driver)
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
	public void getrobotss() throws IOException
	{
		File g1 = robot.getScreenshotAs(OutputType.FILE);
		File g2=new File("C:\\Users\\Suraj Bankar\\eclipse-workspace\\Selenium_Maven\\SreenShot\\pic_1.png");
		FileHandler.copy(g1, g2);
		
	}

}
