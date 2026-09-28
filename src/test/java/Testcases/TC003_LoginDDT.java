package Testcases;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pageobject.HomePage;
import Pageobject.Loginpage;
import Pageobject.Myaccountpagevalidation;
import utilities.Dataprovider;


//

public class TC003_LoginDDT  extends Baseclasstest
{  
	@Test(dataProvider = "Logindata", dataProviderClass =Dataprovider.class, groups = "Datadriven") //getting dataprovider from different class
	public void verifylogin(String email, String pwd, String exp)
	{
		
	try
	{
		
	 //homepage 	
	 HomePage st = new HomePage(driver); 
	 st.myaccounts(null);
	 st.logins(null);
	 
	 //loginpage
	 Loginpage st1 = new Loginpage(driver); 
	 st1.logins(email);
	 st1.pw(pwd);
	 st1.clik();
	 
	 //myaccountpage
	 Myaccountpagevalidation mt = new Myaccountpagevalidation(driver);
	 boolean trg = mt.vaidmsg();
	 
	 //Data is valid - login Success - testpass - logout
	                  //-login failed- test fail 
	 //Data is invalid - login Success -testfail - logout
	                    //-login failed - testpass
	 
	 
	 if(exp.equalsIgnoreCase("Valid"))
	 {
      if (trg == true)
      {
    	  mt.clicklogout();
    	  Assert.assertTrue(true);
    	  
      }
      else
      {
    	  Assert.assertTrue(false);
      }
	 }
	 
	 if(exp.equalsIgnoreCase("Invalid"))
	 {
		 if (trg == true)
	      {
	    	  mt.clicklogout();
	    	  Assert.assertTrue(false);
	    	  
	      }
	      else
	      {
	    	  Assert.assertTrue(true);
	      }
	}
	}
	
	catch (Exception e) {
		Assert.fail(); 
	}
	}
}
