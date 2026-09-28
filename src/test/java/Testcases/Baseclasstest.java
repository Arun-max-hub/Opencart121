package Testcases;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.compress.harmony.pack200.NewAttribute;
import org.apache.commons.compress.harmony.unpack200.bytecode.SourceFileAttribute;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager; // Log4j 
import org.apache.logging.log4j.Logger;// Log4j
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;



public class Baseclasstest {
	

	public  static WebDriver driver; 
	public Logger logger;
	public Properties p;
	
	@Parameters({"osv","browser"})
	@BeforeClass(groups = {"Sanity","Regression", "Master", "Datadriven"})
	public void setup( String os, String brs) throws IOException
	{
	    FileReader fc = new FileReader("./src/test/resources/config.properties");
		p= new Properties(); 
		p.load(fc);
		
		
		logger=LogManager.getLogger(this.getClass());
		
		switch (brs.toLowerCase()) {
		case "chrome" : driver = new ChromeDriver(); break; 
		case "firefox" : driver = new FirefoxDriver(); break; 
		default : System.out.println("invalid browser"); return;
		}
	driver.manage().deleteAllCookies();
	driver.get(p.getProperty("appURL1"));  // reading url from properties file. 
	driver.manage().window().maximize(); 

	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(65));
	}
	
	
	public String randomstring()
	{
		 String generated=RandomStringUtils.randomAlphabetic(5);
		return generated;
		
	}

	public String randomnumbner()
	{
		String gent=RandomStringUtils.randomNumeric(5);
		return gent;
		
	}

	public String alphanumeric()
	{
		String gent1=RandomStringUtils.randomAlphabetic(4);
		String gent2= RandomStringUtils.randomNumeric(3);
		return gent1+"@"+gent2;
	}
	
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date(0));
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
			
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}


	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		return false;
	}

}


