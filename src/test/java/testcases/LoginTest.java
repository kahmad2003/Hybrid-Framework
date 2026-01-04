package testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseClass;
import dataproviders.ExcelReader;
import pages.LoginPage;

public class LoginTest extends BaseClass{
	
	@Test(dataProvider="logindata")
	public void testLoginWithValidCredentials(String uname, String pass) 
	{
		
		LoginPage login = new LoginPage(driver);
		
		login.loginToApplication(uname, pass);
		
	}
	
	@DataProvider(name="logindata")
	public Object [][] getData()
	{
		Object [][]arr=ExcelReader.getDataFromExcel("login");
		
		return arr;
	}

}
