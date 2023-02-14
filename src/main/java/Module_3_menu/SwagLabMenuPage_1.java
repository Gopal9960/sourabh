package Module_3_menu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabMenuPage_1
{
	@FindBy(xpath="//a[@id='logout_sidebar_link']") private WebElement logout;
	
	
	public SwagLabMenuPage_1(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickSwagLabMenuPagelogoutbtn()
	{
		logout.click();
	}

}
