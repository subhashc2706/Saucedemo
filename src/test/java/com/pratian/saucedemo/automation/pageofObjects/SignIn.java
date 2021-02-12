package com.pratian.saucedemo.automation.pageofObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignIn extends BasePage{
	
	public SignIn(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver,this);
		// TODO Auto-generated constructor stub
	}
	
	// Properties
	@FindBy(id="user-name")
	WebElement userName;
	@FindBy(id="password")
	WebElement password;
	@FindBy(xpath="//*[@id=\"login-button\"]")
	WebElement signInButton;
	
	// Methods
	public void provideUserName(String userName)
	{
		this.userName.sendKeys(userName);
	}
	public void providePassword(String password)
	{
		this.password.sendKeys(password);
	}
	
	public HomePage clickSignInButton(WebDriver driver)
	{
		signInButton.click();
		return new HomePage(driver);
	}
}
