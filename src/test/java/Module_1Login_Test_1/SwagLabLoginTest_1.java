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

import LibraryFiles.BaseClass_1;
import LibraryFiles.UtilityClass_1;
import Module_1_login.SwagLabHomePage_1;
import Module_1_login.SwagLabLoginPage_1;
import Module_3_menu.SwagLabMenuPage_1;

public class SwagLabLoginTest_1 extends BaseClass_1
{
	SwagLabLoginPage_1 login;
	SwagLabHomePage_1 home;
	SwagLabMenuPage_1 menu;
	
	int TCID;
	@BeforeClass
	public void openbrowser() throws IOException
	{
		initializebrowser();
		login=new SwagLabLoginPage_1(driver);
		home=new SwagLabHomePage_1(driver);
		menu=new SwagLabMenuPage_1(driver);
		
	}
	@BeforeMethod
	public void logintoapp() throws IOException, InterruptedException
	{
		login.inpSwagLabLoginPageun(UtilityClass_1.getPFdata("UN"));
		Thread.sleep(1000);
		login.inpSwagLabLoginPagepwd(UtilityClass_1.getPFdata("PWD"));
		Thread.sleep(1000);
		login.clickSwagLabLoginPageloginbtn();
	}
	@Test(priority = 1)
	public void verifylogo()
	{
		TCID=1;
		boolean actresult = home.getSwagLabHomePagelogo();
		Assert.assertTrue(actresult, "failed result not matched");
	}
	@Test(priority = 2)
	public void getremovetext() throws InterruptedException, EncryptedDocumentException, IOException
	{
		TCID=2;
		Thread.sleep(1000);
		home.clickSwagLabHomePagecartbtn();
		Thread.sleep(1000);
		String acttext = home.getSwagLabHomePageremovetext();
		String exptext = UtilityClass_1.testdata(0, 2);
		Assert.assertEquals(acttext, exptext,"failed both are differnt");
		
	}
	@AfterMethod
	public void logoutfromapp(ITestResult f1) throws IOException, InterruptedException
	{
		if(f1.getStatus()==ITestResult.FAILURE)
		{
			UtilityClass_1.capturess(driver, TCID);
		}
		Thread.sleep(1000);
		home.clickSwagLabHomePagemenubtn();
		Thread.sleep(1000);
		menu.clickSwagLabMenuPagelogoutbtn();
	}
	@AfterClass
	public void closebrowser() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.quit();
	}

}
