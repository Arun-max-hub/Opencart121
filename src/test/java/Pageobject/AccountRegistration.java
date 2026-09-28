package Pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistration extends Baseclass
{
	
	public AccountRegistration(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath = "//input[@name=\"firstname\"]")
   WebElement fn;

   @FindBy(xpath = "//input[@name=\"lastname\"]")
   WebElement ln;
   
   @FindBy(xpath = "//input[@type=\"email\"]")
   WebElement eml;
   
   @FindBy(xpath = "//input[@name=\"telephone\"]")
   WebElement tl;
  
   @FindBy(xpath = "//input[@name=\"password\"]")
   WebElement pw;
  
   @FindBy(xpath = "//input[@placeholder=\"Password Confirm\"]")
   WebElement cpw;
  
   @FindBy(xpath = "//input[@name=\"agree\"]")
   WebElement ckb;
  
   @FindBy(xpath = "//input[@value=\"Continue\"]")
   WebElement conte;
   
   @FindBy(xpath = "//h1[normalize-space()=\"Your Account Has Been Created!\"]")
   WebElement msgconf;
   
   public void firstname (String ft)
   {
	   fn.sendKeys(ft);
	   
   }
   
   public void lastname (String lt)
   {
	   ln.sendKeys(lt);
   }
   
   public void email (String emls)
   {
	   eml.sendKeys(emls);
   }
   

   public void telephone1 (String teles)
   {
	   tl.sendKeys(teles);
   }
   

   public void password (String pwsd)
   {
	   pw.sendKeys(pwsd);
   }
   
   public void confirmpassword (String cpwd)
   {
	   cpw.sendKeys(cpwd);
   }
   
   
   public void checkbox (String cb)
   {
	   ckb.click();
   }
   
   public void click (String clicks)
   {
	   conte.click();
   }
   
   public String getconf()
   {
	   try
	   {
		   return(msgconf.getText());
	   }
	   catch (Exception e)
	   {
		   return(e.getMessage());
	   }
   }

   
 }