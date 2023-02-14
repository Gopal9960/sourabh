package LibraryFiles;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class UtilityClass_2
{
	//@author=saurabh
	//this method is use for fetching data from property file
	//this method will accept 1 tring parameter
	
	public static String getPF(String key) throws IOException
	{
		FileInputStream file=new FileInputStream("C:\\Users\\Suraj Bankar\\eclipse-workspace\\Selenium_Maven\\PropertyFile_1.properties");
		
		Properties f1=new Properties();
		
		f1.load(file);
		
		String value = f1.getProperty(key);
		
		return value;
		
	}
	
	//author name=saurabh
	//this method is use for fetching the data from excell file
	//this method will accept 2 parameter 1-rowindex,2-cellindex
	
	public static String getTD(int rowindex,int cellindex) throws EncryptedDocumentException, IOException
	{
		FileInputStream file=new FileInputStream("C:\\Users\\Suraj Bankar\\eclipse-workspace\\Selenium_Maven\\TestData\\ExcelSheet.xlsx");
		
		Sheet sh = WorkbookFactory.create(file).getSheet("DDF");
		
		String value = sh.getRow(rowindex).getCell(cellindex).getStringCellValue();
		
		return value;
	}
	public static void CaptureScreenShot(WebDriver driver,int TDN) throws IOException
	{
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		File dest =new File("C:\\Users\\Suraj Bankar\\eclipse-workspace\\Selenium_Maven\\FailedTcaseSS\\test"+TDN+".png");
		
		FileHandler.copy(source, dest);
	}
	
	public static void Screenshot(WebDriver driver) throws IOException
	{
		File f1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		File f2=new File("C:\\Users\\Suraj Bankar\\eclipse-workspace\\Selenium_Maven\\SreenShot\\ss_2.png");
		
		FileHandler.copy(f1, f2);
	}
	

}
