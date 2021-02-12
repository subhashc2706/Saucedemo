package com.pratian.saucedemo.automation.testclasses;

import com.pratian.saucedemo.automation.filehandling.PropertyManager;
import com.pratian.saucedemo.automation.pageofObjects.HomePage;
import com.pratian.saucedemo.automation.pageofObjects.SignIn;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestSignIn extends BaseTest{
	@Test(dataProvider = "signIn")
	public void signIn(String userName, String password) throws IOException
	{
		/*Check whether or not user is able to sign in into saucedemo with valid credentials*/
		
		driver.get(PropertyManager.getProperty("url.app"));
		SignIn signIn= new SignIn(driver);
		signIn.provideUserName(userName);
		signIn.providePassword(password);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		HomePage home= signIn.clickSignInButton(driver);
	}
	

	@DataProvider(name="signIn")
	String [][] getData() throws IOException
	{
		String path= System.getProperty("user.dir")+"/src/test/java/com/pratian/saucedemo/automation/testdata/testData.xlsx";
		
		int rownum=com.pratian.saucedemo.automation.utils.XLUtils.getRowCount(path, "Sheet1");
		int colcount=com.pratian.saucedemo.automation.utils.XLUtils.getCellCount(path,"Sheet1",1);
		
		String logindata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=com.pratian.saucedemo.automation.utils.XLUtils.getCellData(path,"Sheet1", i,j);
			}
				
		}
	return logindata;
	}
}
