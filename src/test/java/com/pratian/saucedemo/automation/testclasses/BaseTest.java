package com.pratian.saucedemo.automation.testclasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.pratian.saucedemo.automation.filehandling.PropertyManager;



public class BaseTest {

	protected WebDriver driver;
	
	@BeforeClass
	public void setUp() throws IOException
	{
		System.setProperty("webdriver.chrome.driver", PropertyManager.getProperty("path.driver.chrome"));
		driver = new ChromeDriver();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
}


