package com.pratian.saucedemo.automation.pageofObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver,this);
			}
	
	// properties
	@FindBy(xpath="//*[@id=\"inventory_container\"]/div/div[1]/div[3]/button")
	WebElement AddtoCart;
	@FindBy(xpath="//*[@id=\"shopping_cart_container\"]")
	WebElement CartIcon;
	@FindBy(xpath="//*[@id=\"cart_contents_container\"]/div/div[2]/a[2]")
	WebElement ProductName;
	
	//Methods

	public void clickCartIcon()
	{
		this.CartIcon.click();
	}
	public void clickAddToCart()
	{
		this.AddtoCart.click();
	}
//	public void ProductName(String password)
//	{
//		this.password.sendKeys(password);
//	}
//	
	public boolean ProductName() {
		// TODO Auto-generated method stub
		return false;
	}
	public void assertingCheckIn() {				
		WebElement element = driver.findElement(By.xpath("//*[@id='cart_contents_container']/div/div[2]/a[2]"));
		String checking = element.getText();
		
		Assert.assertEquals("CHECKOUT", checking ,"Checkin is successful");
		System.out.println("Add to cart is successful");
		 }

}
