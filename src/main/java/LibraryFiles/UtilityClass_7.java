package LibraryFiles;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class UtilityClass_7 
{
	//@author=saurabh
	//this method is use to fetch data from propertyfile
	//it will accept 1 string parameter i.e key
	
	public static String getPFdata(String key) throws IOException
	{
		FileInputStream file=new FileInputStream("C:\\Users\\Suraj Bankar\\eclipse-workspace\\Selenium_Maven\\TestData\\PropertyFile_7.properties");
		
		Properties p1=new Properties();
		
		p1.load(file);
		
		String value = p1.getProperty(key);
		
		return value;
	}
	//@author=saurabh
	//this method is use to fetch data from excell sheet
	//this method will accept 2 parameter i.e 1-rowindex,2-cellindex
	public static String gettestdata(int rowindex,int cellindex) throws Throwable
	{
		FileInputStream file=new FileInputStream("C:\\Users\\Suraj Bankar\\eclipse-workspace\\Selenium_Maven\\TestData\\ExcelSheet.xlsx");
		
		Sheet sh = WorkbookFactory.create(file).getSheet("DDF");
		
		String value = sh.getRow(rowindex).getCell(cellindex).getStringCellValue();
		
		return value;
		
	}
	public static void getSreenShot(WebDriver driver,int TCN) throws IOException
	{
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		File dest=new File("C:\\Users\\Suraj Bankar\\eclipse-workspace\\Selenium_Maven\\FailedTcaseSS\\test_"+TCN+".png");
		
		FileHandler.copy(source, dest);
	}
}
