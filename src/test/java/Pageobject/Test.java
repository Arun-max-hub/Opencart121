package Pageobject;

import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Test {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://testautomationpractice.blogspot.com/");

        // Locate dropdown
        WebElement dropdown = driver.findElement(By.id("country"));

        // Create Select object
        Select sel = new Select(dropdown);

        // Get all options
        List<WebElement>   options = sel.getOptions();

         String S1 ="";
        // Iterate through dropdown values.
           
        for (WebElement option : options) {

            String value = option.getText().trim();
              if(value.compareTo(S1) > 0 )
              {
            	  S1=value;
            	  System.out.println("aruntest");
              }
       
            
        }
        System.out.println(S1);

        driver.quit();
    }
}