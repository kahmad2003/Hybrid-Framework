package factory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import dataproviders.ConfigReader;

public class BrowserFactory
{
	static WebDriver driver;
	
	public static WebDriver getDriver() 
	{
		return driver;
	}
	
	public static WebDriver startBrowser(String brName, String appURL)
	{
		System.out.println("Application will be running on " + brName + "with url " + appURL);
		
		//WebDriver driver=null;
		
		if(brName.toLowerCase().equals("chrome")||brName.toLowerCase().equals("gc")||brName.toLowerCase().equals("google"))
		{	driver=new ChromeDriver();
		}else if(brName.toLowerCase().equals("firefox")||brName.toLowerCase().equals("mozilla")||brName.toLowerCase().equals("ff"))
		{	driver=new FirefoxDriver();
		}else if(brName.toLowerCase().equals("edge")||brName.toLowerCase().equals("msedge")||brName.toLowerCase().equals("microsoft edge"))
		{	driver=new EdgeDriver();
		}else if(brName.toLowerCase().equals("safari")||brName.toLowerCase().equals("apple safari"))
		{	driver=new SafariDriver();
		}else 
		{
			System.out.println("Sorry - Currently our framework does not support " + brName + "browser");
		}
		
		
		driver.manage().window().maximize();
		
		//String pageload=ConfigReader.getValue("pageloadtimeout");
		//long value=Long.parseLong(pageload);
		
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Long.parseLong(ConfigReader.getValue("pageloadtimeout"))));
		driver.get(appURL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(ConfigReader.getValue("implicitwait"))));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(Long.parseLong(ConfigReader.getValue("scripttimeout"))));
		System.out.println("Application is up and running");
		return driver;
	}
}
