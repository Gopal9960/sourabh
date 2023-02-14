package Module_1Login_Test_1;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import LibraryFiles.BaseClass_8;
import LibraryFiles.UtilityClass_8;
import Module_1_login.SwagLabHomePage_8;
import Module_1_login.SwagLabLoginPage_8;
import Module_3_menu.SwagLabMenuPage_8;

public class SwagLabLoginTest_8  extends BaseClass_8
{
	int TCN;
	SwagLabLoginPage_8 login;
	SwagLabHomePage_8 home;
	SwagLabMenuPage_8 menu;
	
	@BeforeClass
	public void openbrowser() throws IOException
	{
		initializeBrowser();
		login=new SwagLabLoginPage_8(driver);
		home=new SwagLabHomePage_8(driver);
		menu=new SwagLabMenuPage_8(driver);
		
	}
	@BeforeMethod
	public void openapp() throws EncryptedDocumentException, IOException, InterruptedException
	{
		Thread.sleep(1000);
		login.inpSwagLabLoginPageUN(UtilityClass_8.getPfdata("UN"));
		Thread.sleep(2000);
		login.inpSwagLabLoginPagePWD(UtilityClass_8.getPfdata("PWD"));
		Thread.sleep(2000);
		login.clickSwagLabLoginPagelogin();
	}
	@Test(priority = 1)
	public void verifylogo() throws InterruptedException
	{
		TCN=1;
		Thread.sleep(1000);
		boolean actresult = home.verifySwagLabHomePagelogo();
		Assert.assertTrue(actresult, "failed result not matched");
		
	}
	@Test(priority = 2)
	public void getremove() throws InterruptedException, EncryptedDocumentException, IOException
	{
		TCN=2;
		Thread.sleep(1000);
		home.clickSwagLabHomePagecart();
		Thread.sleep(1000);
		String acttext = home.getSwagLabHomePageremove();
		String exptext = UtilityClass_8.gettestdata(0, 2);
		Assert.assertEquals(acttext,exptext,"failed-both are diff");
	}
	@AfterMethod
	public void logoutfromapp(ITestResult f1) throws InterruptedException, IOException
	{
		if(f1.getStatus()==ITestResult.FAILURE)
		{
			UtilityClass_8.getscreenshot(driver, TCN);
		}
		
		Thread.sleep(1000);
		home.clickSwagLabHomePagemenu();
		Thread.sleep(1000);
		menu.clickSwagLabMenuPagelogoutbtn();	
	}
	@AfterClass
	public void closebrowser() throws InterruptedException
	{
		Thread.sleep(1000);
		driver.close();
	}

}
