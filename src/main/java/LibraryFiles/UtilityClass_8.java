package LibraryFiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class UtilityClass_8 
{
	//@author=Saurabh
	//this method is use to fetch data from property file
	//this method will accept string parameter
	
	public static String getPfdata(String key) throws IOException
	{
		FileInputStream file=new FileInputStream("C:\\Users\\Suraj Bankar\\eclipse-workspace\\Selenium_Maven\\TestData\\PropertyFile_8.properties");
		
		Properties p=new Properties();
		
		p.load(file);
		
		String value = p.getProperty(key);
		
		return value;
	}
	//@author=saurabh
	//this method is use to fetch data from excel sheet
	//this method will accept 2 parameter i.e rowindex,cellindex
	public static String gettestdata(int rowindex,int cellindex) throws EncryptedDocumentException, IOException
	{
		FileInputStream file=new FileInputStream("C:\\Users\\Suraj Bankar\\eclipse-workspace\\Selenium_Maven\\TestData\\ExcelSheet.xlsx");
		
		Sheet sh = WorkbookFactory.create(file).getSheet("DDF");
		
		String value = sh.getRow(rowindex).getCell(cellindex).getStringCellValue();
		
		return value;
		
	}
	
	public static void getscreenshot(WebDriver driver,int TCN) throws IOException
	{
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		File dest=new File("C:\\Users\\Suraj Bankar\\eclipse-workspace\\Selenium_Maven\\SreenShot");
		
		FileHandler.copy(source, dest);
	}

}
