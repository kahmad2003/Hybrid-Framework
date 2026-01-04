package listeners;

//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.chaintest.plugins.ChainTestListener;

import dataproviders.ConfigReader;
import helper.Utility;

public class CustomTestNGListeners implements ITestListener
{
	
	public void onTestSuccess(ITestResult result) 
	{
	    ChainTestListener.log("Test Executed : Test Passed " + result.getMethod().getMethodName());
	    
	    String value=ConfigReader.getValue("screenshot_on_success");
	    if(value.equalsIgnoreCase("true")) 
		{
			ChainTestListener.embed(Utility.captureScreenshot(), "image/png");
		}
	    
	}
	
	
	public void onTestFailure(ITestResult result) 
	{
		ChainTestListener.log("Test Executed : Test Failed " + result.getMethod().getMethodName() + " " + result.getThrowable().getMessage());
		
		String value=ConfigReader.getValue("screenshot_on_failure");
		
		if(value.equalsIgnoreCase("true")) 
		{
			ChainTestListener.embed(Utility.captureScreenshot(), "image/png");
		}
		
	}
	
	public void onTestSkipped(ITestResult result) 
	{
		ChainTestListener.log("Test Executed : Test Failed " + result.getMethod().getMethodName() + " " + result.getThrowable().getMessage());
		String value=ConfigReader.getValue("screenshot_on_skip");
		
		if(value.equalsIgnoreCase("true")) 
		{
			ChainTestListener.embed(Utility.captureScreenshot(), "image/png");
		}
	}
}
