package Pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Myaccountpagevalidation  extends Baseclass
{

 public Myaccountpagevalidation (WebDriver driver) 
		// TODO Auto-generated constructor stub
	{
	 super(driver);
	}
    
  @FindBy (xpath = "//h2[normalize-space()='My Account']")
   WebElement msgvalid; 
 
  @FindBy (xpath = "//div[@class=\"list-group\"]//a[normalize-space()=\"Logout\"]")
  WebElement logout; 
 
  public boolean vaidmsg()
 {
	 try
	 {   return(msgvalid.isDisplayed());
	   
	 }
	 catch (Exception e) {
	       return false;
	}
	 
 }
  
  public void clicklogout()
  {
	  logout.click();
  }
 
}
