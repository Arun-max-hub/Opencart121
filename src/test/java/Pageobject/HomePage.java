package Pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends  Baseclass
{

	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath = "//span[normalize-space()='My Account']")
	WebElement myaccount; 
	
	@FindBy(xpath = "//a[normalize-space()='Register']")
	WebElement register;
	
	@FindBy(linkText ="Login")  //login link added steps 
	WebElement login; 
	
	public void myaccounts(String cli)
	{
	myaccount.click();	
	}
	
	public void reg(String reg)
	{
	  register.click();	
	}
	
	public void logins(String log)
	{
		login.click();
	}
	
	}
