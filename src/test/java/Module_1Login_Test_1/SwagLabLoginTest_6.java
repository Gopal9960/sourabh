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

import LibraryFiles.BaseClass_6;
import LibraryFiles.UtilityClass_6;
import Module_1_login.SwagLabHomePage_6;
import Module_1_login.SwagLabLoginPage_6;
import Module_3_menu.SwagLabMenuPage_6;

public class SwagLabLoginTest_6 extends BaseClass_6
{
	int TCN;
	SwagLabLoginPage_6 f1;
	SwagLabHomePage_6 f2;
	SwagLabMenuPage_6 f3;
	@BeforeClass
	public void openbrowser() throws IOException
	{
		initializebrowser();
		f1=new SwagLabLoginPage_6(driver);
		f2=new SwagLabHomePage_6(driver);
		f3=new SwagLabMenuPage_6(driver);
	}
	@BeforeMethod
	public void logintoapp() throws IOException, InterruptedException
	{
		f1.inpSwagLabLoginPageun(UtilityClass_6.getpfdata("UN"));
		Thread.sleep(1000);
		f1.inpSwagLabLoginPagepwd(UtilityClass_6.getpfdata("PWD"));
		Thread.sleep(1000);
		f1.clickSwagLabLoginPageloginbtn();
	}
	@Test(priority = 1)
	public void verifylogo()
	{
		TCN=1;
		boolean actresult = f2.getSwagLabHomePagelogo();
		Assert.assertTrue(actresult, "failed result not matched");
	}
	@Test(priority = 2)
	public void getremovetext() throws InterruptedException, EncryptedDocumentException, IOException
	{
		TCN=2;
		Thread.sleep(1000);
		f2.clickSwagLabHomePagecartbtn();
		Thread.sleep(1000);
		String acttext = f2.getSwagLabHomePageremovetext();
		String exptext = UtilityClass_6.gettestdata(2, 0);
		Assert.assertEquals(acttext, exptext,"failed both are diff");
	}
	@AfterMethod
	public void logoutfromapp(ITestResult f4) throws IOException, InterruptedException
	{
		if(f4.getStatus()==ITestResult.FAILURE)
		{
			UtilityClass_6.getscreenshot(driver, TCN);
		}
		Thread.sleep(1000);
		f2.clickSwagLabHomePagemenubtn();
		Thread.sleep(1000);
		f3.clickSwagLabMenuPagelogoutbtn();
		
	}
	@AfterClass
	public void closebrowser() throws InterruptedException
	{
		Thread.sleep(1000);
		driver.close();
		
	}

}
