package Testcases;

import java.time.Duration;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import Pageobject.AccountRegistration;
import Pageobject.HomePage;

@Test
public class TC001_Accountregistration extends Baseclasstest 
{
	@Test(groups={"Sanity", "Regression", "Master"})
public void verify()
{
	try 
	{
	
	logger.info("****starting Testcase Execution********");
	 HomePage st = new HomePage(driver);
	   
	   st.myaccounts(null);
		logger.info("Clicked on myaccount");

	   st.reg(null);
		logger.info("clicked on registration page");

   AccountRegistration nw = new AccountRegistration (driver);
   
   logger.info("providing cusotmer details");
   nw.firstname(randomstring().toUpperCase());   
   nw.lastname(randomstring().toUpperCase());
   nw.email( randomstring()+"@gmail.com");
   nw.telephone1(randomnumbner().toUpperCase());
   
   String pws = alphanumeric();
   nw.password(pws);
   nw.confirmpassword(pws);
   
   
   nw.checkbox(null);
   nw.click(null);
 
    logger.info("validation message");
   String test =nw.getconf();
  
    if(test.equals("Your Account Has Been Created!"))
    {
    	Assert.assertTrue(true);
    }
    else
    {
    	logger.error("Test failed");
		logger.debug("Debugs logs..");
    	Assert.assertTrue(false);
	}
   Assert.assertEquals(test, "Your Account Has Been Created!");
	}
	catch (Exception e) 
	{
		logger.error("Test failed");
		logger.debug("Debugs logs..");
		Assert.fail();
		
	}
	logger.info("***** finished **********");
	
}

	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
