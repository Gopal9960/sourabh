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

import LibraryFiles.BaseClass_3;
import LibraryFiles.UtilityClass_3;
import Module_1_login.SwagLabHomePage_3;
import Module_1_login.SwagLabLoginPage_3;
import Module_3_menu.SwagLabMenuPage_3;

public class SwagLabLoginTest_3 extends BaseClass_3
{
	
	SwagLabLoginPage_3 login;
	SwagLabHomePage_3 home;
	SwagLabMenuPage_3 menu;
	int TCID;
	
	@BeforeClass
	public void openbrowser() throws IOException, InterruptedException
	{
		initializebrowser();
		Thread.sleep(2000);
		login=new SwagLabLoginPage_3(driver);
		Thread.sleep(2000);
		login.getSwagLabLoginPageScreen();
		home=new SwagLabHomePage_3(driver);
		menu=new SwagLabMenuPage_3(driver);
		
	
	}
	@BeforeMethod
	public void logintoapp() throws IOException, InterruptedException
	{
		
		login.inpSwagLabLoginPageun(UtilityClass_3.getpropertydata("UN"));
		Thread.sleep(2000);
		login.inpSwagLabLoginPagepwd(UtilityClass_3.getpropertydata("PWD"));
		Thread.sleep(2000);
		login.clickSwagLabLoginPagelogin();
	}
	@Test(priority = 1)
	public void verifylogo() throws InterruptedException
	{
		Thread.sleep(2000);
		TCID=4;
		boolean actresult = home.getSwagLabHomePagelogo();
		Assert.assertTrue(actresult, "failed result not matched");
	}
	@Test(priority = 2)
	public void getremovetext() throws InterruptedException, EncryptedDocumentException, IOException
	{
		TCID=5;
		Thread.sleep(2000);
		home.clickSwagLabHomePagecartbtn();
		Thread.sleep(2000);
		String acttext = home.getSwagLabHomePageremovetext();
		String exptext = acttext=UtilityClass_3.gettestdata(0, 2);
		Assert.assertEquals(acttext, exptext,"failed both are not matched");
		
	}
	@AfterMethod
	public void logoutfromapp(ITestResult f1) throws InterruptedException, IOException
	{
		if(f1.getStatus()==ITestResult.FAILURE)
		{
			UtilityClass_3.getscreenshot(driver, TCID);
		}
		Thread.sleep(2000);
		home.clickSwagLabHomePagemenubtn();
		Thread.sleep(2000);
		menu.clickSwagLabMenuPagelogoutbtn();
		
	}
	@AfterClass
	public void closebrowser() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.close();
	}

}
