package Pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Loginpage extends Baseclass
{
 
	 public Loginpage(WebDriver driver) 
		// TODO Auto-generated constructor stub
	{
	 super(driver);
	}
	
	 @FindBy(xpath = "//input[@name=\"email\"]")
	 WebElement em;
	 
	@FindBy(xpath = "//input[@name=\"password\"]")
    WebElement pasword; 
	
	@FindBy(xpath = "//input[@value=\"Login\"]")
	WebElement cliks;
	
	public void logins(String emails)
	{
	 em.sendKeys(emails);
	}
	 
	public void pw(String pws)
	{
		pasword.sendKeys(pws);
	}
	
	public void clik()
	{
		cliks.click();
	}
  
}
