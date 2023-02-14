package Module_1Login_Test_1;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import LibraryFiles.BaseClass_4;
import LibraryFiles.UtilityClass_4;
import Module_1_login.SwagLabHomePage_4;
import Module_1_login.SwagLabLoginPage_4;
import Module_3_menu.SwagLabMenuPage_4;

public class SwagLabLoginTest_4 extends BaseClass_4
{
	int TCN;
	SwagLabLoginPage_4 login;
	SwagLabHomePage_4 home;
	SwagLabMenuPage_4 menu;
	@BeforeClass
	public void openbrowser() throws IOException
	{
		initializebrowser();
		login=new SwagLabLoginPage_4(driver);
		home=new SwagLabHomePage_4(driver);
		menu=new SwagLabMenuPage_4(driver);
		
	}
	@BeforeMethod
	public void logintoapp() throws IOException, InterruptedException
	{
		login.inpSwagLabLoginPageun(UtilityClass_4.getPFdata("UN"));
		Thread.sleep(2000);
		login.inpSwagLabLoginPagepwd(UtilityClass_4.getPFdata("PWD"));
		Thread.sleep(2000);
		login.clickSwagLabLoginPageloginbtn();
	}
	@Test(priority = 1)
	public void verifylogo()
	{
		TCN=1;
		boolean actresult = home.getSwagLabHomePagelogo();
		Assert.assertTrue(actresult, "failed result not matched");
	}
	@Test(priority = 2)
	public void getremovetext() throws InterruptedException, IOException
	{
		TCN=2;
		Thread.sleep(2000);
		home.clickSwagLabHomePagecartbtn();
		Thread.sleep(2000);
		String acctext = home.getSwagLabHomePageremovetext();
		String exptext = UtilityClass_4.gettestdata(0, 2);
		Assert.assertEquals(acctext, exptext,"failed both are diff");
		
	}
	@AfterMethod
	public void logoutfromapp(ITestResult t1) throws InterruptedException, IOException
	{
		if(t1.getStatus()==ITestResult.FAILURE)
		{
			UtilityClass_4.capturess(driver, TCN);
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
		driver.quit();
	}
	

}
