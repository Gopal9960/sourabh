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

import LibraryFiles.BaseClass_5;
import LibraryFiles.UtilityClass_5;
import Module_1_login.SwagLabHomePage_5;
import Module_1_login.SwagLabLoginPage_5;
import Module_3_menu.SwagLabMenuPage_5;

public class SwagLabLoginTest_5 extends BaseClass_5
{
	int TCN;
	SwagLabLoginPage_5 f1;
	SwagLabHomePage_5 f2;
	SwagLabMenuPage_5 f3;
	@BeforeClass
	public void openbrowser() throws Throwable
	{
		initializebrowser();
		
		f1=new SwagLabLoginPage_5(driver);
		Thread.sleep(2000);
		f1.getrobotss();
		Thread.sleep(2000);
		f2=new SwagLabHomePage_5(driver);
		f3=new SwagLabMenuPage_5(driver);
	}
	@BeforeMethod
	public void logintoapp() throws Throwable
	{
		f1.inpSwagLabLoginPageun(UtilityClass_5.getpfdata("UN"));
		Thread.sleep(1000);
		f1.inpSwagLabLoginPagepwd(UtilityClass_5.getpfdata("PWD"));
		Thread.sleep(1000);
		f1.clickSwagLabLoginPageloginbtn();
	}
	@Test(priority = 1)
	public void verifylogo() throws InterruptedException
	{
		TCN=3;
		Thread.sleep(1000);
		boolean actresult = f2.getSwagLabHomePagelogo();
		Assert.assertTrue(actresult, "Failed result not matched");
		
	}
	@Test(priority = 2)
	public void getremovetext() throws InterruptedException, EncryptedDocumentException, IOException
	{
		TCN=4;
		Thread.sleep(1000);
		f2.clickSwagLabHomePagecartbtn();
		Thread.sleep(1000);
		String acttext = f2.getSwagLabHomePageremovetext();
		String exptext = UtilityClass_5.getTD(0, 2);
		Assert.assertEquals(acttext, exptext,"failed both are diff");
	}
	@Test(priority = 3)
	public void screenshot() throws IOException
	{
		UtilityClass_5.clickscreenshot(driver);
	}
	@AfterMethod
	public void logoutfromapp(ITestResult f4) throws IOException, InterruptedException
	{
		if(f4.getStatus()==ITestResult.FAILURE)
		{
			UtilityClass_5.getscreenshot(driver, TCN);
		}
		Thread.sleep(1000);
		f2.clickSwagLabHomePagemenu();
		Thread.sleep(1000);
		f3.clickSwagLabMenuPagelogoutbtn();
	}
	@AfterClass
	public void closebrowser() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.quit();
		
	}

}
