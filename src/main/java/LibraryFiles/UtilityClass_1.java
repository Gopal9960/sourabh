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

public class UtilityClass_1
{
	//Author=saurabh
	//this method is used to fetch data from property file
	//it will accept 1 string parameter i.e key
	public static String getPFdata(String key) throws IOException
	{
		FileInputStream file=new FileInputStream("C:\\Users\\Suraj Bankar\\eclipse-workspace\\Selenium_Maven\\PropertyFile.properties");
		
		Properties p=new Properties();
		
		p.load(file);
		
		String value = p.getProperty(key);
		
		return value;
		
	}
	//@author=saurabh
	//this method is used fetch data from excell sheet 
	//it will accept 2 parameter 1-rowindex,2-cellindex
	public static String testdata(int rowindex,int cellindex) throws EncryptedDocumentException, IOException
	{
		FileInputStream file=new FileInputStream("C:\\Users\\Suraj Bankar\\eclipse-workspace\\Selenium_Maven\\TestData\\ExcelSheet.xlsx");
		Sheet sh = WorkbookFactory.create(file).getSheet("DDF");
		
		String value = sh.getRow(rowindex).getCell(cellindex).getStringCellValue();
		
		return value;
	
	}
	public static void capturess(WebDriver driver,int TCID) throws IOException
	{
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		File dest=new File("C:\\Users\\Suraj Bankar\\eclipse-workspace\\Selenium_Maven\\FailedTcaseSS\\test1"+TCID+".jpeg");
		
		FileHandler.copy(source, dest);
	}

}
