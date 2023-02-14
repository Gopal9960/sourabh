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

public class UtilityClass_5
{
	//@author=saurabh
	//this method is use for fetch data from property file
	//it will accept 1 String parameter i.e key
	
	public static String getpfdata(String key) throws Throwable
	{
		FileInputStream file=new FileInputStream("C:\\Users\\Suraj Bankar\\eclipse-workspace\\Selenium_Maven\\TestData\\PropertyFile_5.properties");
		
		Properties p1=new Properties();
		
		p1.load(file);
		
		String value = p1.getProperty(key);
		
		return value;
	}
	
	//@author=saurabh
	//this method is use to fetch data from excell sheet
	//it will accept 2 int parameter i.e 1-rowindex,2-cellindex
	public static String getTD(int rowindex,int cellindex) throws EncryptedDocumentException, IOException
	{
		FileInputStream file=new FileInputStream("C:\\Users\\Suraj Bankar\\eclipse-workspace\\Selenium_Maven\\TestData\\ExcelSheet.xlsx");
		
		Sheet sh = WorkbookFactory.create(file).getSheet("DDF");
		
		String value = sh.getRow(rowindex).getCell(cellindex).getStringCellValue();
		
		return value;
	}
	
	public static void getscreenshot(WebDriver driver,int TCN) throws IOException
	{
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		File dest=new File("C:\\Users\\Suraj Bankar\\eclipse-workspace\\Selenium_Maven\\FailedTcaseSS");
		
		FileHandler.copy(source, dest);
	}
	
	public static void clickscreenshot(WebDriver driver) throws IOException
	{
		File b1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		File b2=new File("C:\\Users\\Suraj Bankar\\eclipse-workspace\\Selenium_Maven\\SreenShot\\ss_3.png");
		
		FileHandler.copy(b1, b2);
	}
	
	
	

}
