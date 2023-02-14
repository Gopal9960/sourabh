package Module_1_login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabHomePage_2
{
	@FindBy(xpath="//div[@class='app_logo']") private WebElement logo;
	@FindBy(xpath="//button[text()='Add to cart']") private WebElement cart;
	@FindBy(xpath="//button[text()='Remove']") private WebElement remove;
	@FindBy(xpath="//button[@id='react-burger-menu-btn']") private WebElement menu;
	
	public SwagLabHomePage_2(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean getSwagLabHomePagelogo()
	{
		boolean result = logo.isDisplayed();
		return result;
	}
	public void clickSwagLabHomePagecartbtn()
	{
		cart.click();
	}
	public String getSwagLabHomePageremovetext()
	{
		String acttext = remove.getText();
		return acttext;
	}
	public void clickSwagLabHomePagemenubtn()
	{
		menu.click();
	}

}
