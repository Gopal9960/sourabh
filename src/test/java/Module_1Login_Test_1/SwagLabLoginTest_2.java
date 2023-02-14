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

import LibraryFiles.BaseClass_2;
import LibraryFiles.UtilityClass_2;
import Module_1_login.SwagLabHomePage_2;
import Module_1_login.SwagLabLoginPage_2;
import Module_3_menu.SwagLabMenuPage_2;

public class SwagLabLoginTest_2  extends BaseClass_2
{
	int TCID;
	SwagLabLoginPage_2 login;
	SwagLabHomePage_2 home;
	SwagLabMenuPage_2 menu;
	@BeforeClass
	public void openbrowser() throws IOException
	{
		initializebrowser();
		
		login=new SwagLabLoginPage_2(driver);
		login.getSSrobot();
		home=new SwagLabHomePage_2(driver);
		menu=new SwagLabMenuPage_2(driver);		
	}
	@BeforeMethod
	public void logintobrowser() throws IOException, InterruptedException
	{
		login.inpSwagLabLoginPageun(UtilityClass_2.getPF("UN"));
		Thread.sleep(2000);
		login.inpSwagLabLoginPagepwd(UtilityClass_2.getPF("PWD"));
		Thread.sleep(2000);
		login.clickSwagLabLoginPageloginbtn();
	}
	@Test(priority = 1)
	public void verifylogo() throws InterruptedException
	{
		TCID=21;
		Thread.sleep(2000);
		boolean actresult = home.getSwagLabHomePagelogo();
		
		Assert.assertTrue(actresult,"failed result not matched");
	}
	@Test(priority = 2)
	public void getremovetext() throws InterruptedException, EncryptedDocumentException, IOException
	{
		TCID=22;
		home.clickSwagLabHomePagecartbtn();
		Thread.sleep(2000);
		String acttext = home.getSwagLabHomePageremovetext();
		String exptext = UtilityClass_2.getTD(0, 1);
		Assert.assertEquals(acttext, exptext,"failed both are diffrent");
		
	}
	@Test(priority = 3)
	public void getScreenShot() throws InterruptedException, IOException
	{
		TCID=23;
		Thread.sleep(2000);
		UtilityClass_2.Screenshot(driver);
		
	}
	@AfterMethod
	public void logoutfrombrowser(ITestResult f1) throws IOException, InterruptedException
	{
		if(f1.getStatus()==ITestResult.FAILURE)
		{
			UtilityClass_2.CaptureScreenShot(driver,TCID);
		}
		Thread.sleep(2000);
		home.clickSwagLabHomePagemenubtn();
		Thread.sleep(2000);
		menu.clickSwagLabMenuPagelogout();
	}
	@AfterClass
	public void closebrowser() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.close();
	}
	

}
