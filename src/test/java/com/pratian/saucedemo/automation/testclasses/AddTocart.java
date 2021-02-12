package com.pratian.saucedemo.automation.testclasses;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.pratian.saucedemo.automation.filehandling.PropertyManager;
import com.pratian.saucedemo.automation.pageofObjects.HomePage;
import com.pratian.saucedemo.automation.pageofObjects.SignIn;

public class AddTocart extends BaseTest {
	ExtentHtmlReporter htmlReporter;
	ExtentReports extentReport;
	ExtentTest reporttest;
	@Test(dataProvider = "signIn")
	public void signIn(String userName, String password) throws IOException
	{
		/*Check whether or not user is able to sign in into saucedemo with valid credentials*/
		htmlReporter=new ExtentHtmlReporter("extentReport.html");

		extentReport=new ExtentReports();
		extentReport.attachReporter(htmlReporter);
		reporttest=extentReport.createTest("Saucedemo","this is a test to validate sausedemo");
		reporttest.log(Status.INFO, "starting test case");
		driver.get(PropertyManager.getProperty("url.app"));
		WebDriverWait wait=new WebDriverWait(driver, 20);
		SignIn signIn= new SignIn(driver);
		
		signIn.provideUserName(userName);
		reporttest.pass("signin");
		signIn.providePassword(password);
		reporttest.pass("password");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		HomePage home= signIn.clickSignInButton(driver);
		reporttest.pass("login");
		home.clickAddToCart();
		reporttest.pass("clicking on cart");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		home.clickCartIcon();
		WebDriverWait wait1 = new WebDriverWait(driver, 30);
		home.assertingCheckIn();	
		
		reporttest.pass("browser hasbeen closed");
		reporttest.info("testcase1 completed");
		extentReport.flush();
		File screenshotFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(screenshotFile, new File(".//Screenshots/saucepage.png"));

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
