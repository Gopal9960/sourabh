package LibraryFiles;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BaseClass_5
{
	public WebDriver driver;
	
	public void initializebrowser() throws Throwable
	{
		driver=new EdgeDriver();
		
		driver.get(UtilityClass_5.getpfdata("URL"));
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}

}
