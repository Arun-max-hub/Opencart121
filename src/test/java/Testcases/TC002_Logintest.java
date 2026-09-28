package Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pageobject.HomePage;
import Pageobject.Loginpage;
import Pageobject.Myaccountpagevalidation;

public class TC002_Logintest extends Baseclasstest {

    @Test(groups = {"Sanity", "Master"})
    public void verify() {

        logger.info("**** Starting Login Test ****");

        try {

            // Home Page
            HomePage hp = new HomePage(driver);

            hp.myaccounts(null);
            logger.info("Clicked on My Account");

            hp.logins(null);
            logger.info("Clicked on Login");

            // Login Page
            Loginpage lp = new Loginpage(driver);

            lp.logins(p.getProperty("email"));
            lp.pw(p.getProperty("password"));
            lp.clik();

            logger.info("Entered login credentials");

            // My Account Page
            Myaccountpagevalidation map =
                    new Myaccountpagevalidation(driver);

            boolean result = map.vaidmsg();

            Assert.assertTrue(result, "Login failed");

            logger.info("Login successful");

        } catch (Exception e) {

            logger.error("Login test failed: " + e.getMessage());

            Assert.fail("Login test failed because of: " + e.getMessage());
        }

        logger.info("**** Login Test Finished ****");
    }
}