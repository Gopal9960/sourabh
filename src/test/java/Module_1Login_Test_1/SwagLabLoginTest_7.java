package Module_1Login_Test_1;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import LibraryFiles.BaseClass_7;
import LibraryFiles.UtilityClass_7;
import Module_1_login.SwagLabHomePage_7;
import Module_1_login.SwagLabLoginPage_7;
import Module_3_menu.SwagLabMenuPage_7;

public class SwagLabLoginTest_7 extends BaseClass_7
{
	int TCN;
	SwagLabLoginPage_7 login;
	SwagLabHomePage_7 home;
	SwagLabMenuPage_7 menu;
	@BeforeClass
	public void openbrowser() throws IOException
	{
		initializebrowser();
		login=new SwagLabLoginPage_7(driver);
		home=new SwagLabHomePage_7(driver);
		menu=new SwagLabMenuPage_7(driver);
	}
	@BeforeMethod
	public void logintoapp() throws InterruptedException, IOException
	{
		Thread.sleep(1000);
		login.inpSwagLabLoginPageun(UtilityClass_7.getPFdata("UN"));
		Thread.sleep(1000);
		login.inpSwagLabLoginPagepwd(UtilityClass_7.getPFdata("PWD"));
		Thread.sleep(1000);
		login.clickSwagLabLoginPageloginbtn();
	}
	@Test(priority = 1)
	public void verifylogo() throws InterruptedException
	{
		TCN=1;
		Thread.sleep(1000);
		boolean actresult = home.getSwagLabHomePagelogo();
		Assert.assertTrue(actresult, "failed-result not matched");	
	}
	@Test(priority = 2)
	public void getremovetext() throws Throwable
	{
		TCN=2;
		Thread.sleep(1000);
		home.clickSwagLabHomePagecart();
		Thread.sleep(1000);
		String acttext = home.getSwagLabHomePageremovetext();
		String exptext = UtilityClass_7.gettestdata(0, 2);
		Assert.assertEquals(acttext, exptext,"failed-both are different");
	}
	@AfterMethod
	public void logoutfromapp(ITestResult f1) throws IOException, InterruptedException
	{
		if(f1.getStatus()==ITestResult.FAILURE)
		{
			UtilityClass_7.getSreenShot(driver, TCN);
		}
		Thread.sleep(1000);
		home.clickSwagLabHomePagemenubtn();
		Thread.sleep(1000);
		menu.clickSwagLabMenuPagelogoutbtn();
	}
	@AfterClass
	public void closebrowser() throws InterruptedException
	{
		Thread.sleep(1000);
		driver.quit();
	}

}
