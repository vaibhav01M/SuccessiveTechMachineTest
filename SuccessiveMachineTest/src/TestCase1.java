import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
//import org.openqa.selenium.remote.DesiredCapabilities;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase1 {

	public static void main(String[] args) {

		 
		System.setProperty("webdriver.ie.driver","F:\\Java Basic\\JAR files\\IEDriverServer.exe");
        WebDriver driver = new InternetExplorerDriver();
        
        driver.get("http://bg-dev.eweblife.com/prm/bgbtw/rsvp-signup/apply?record=826");
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println("Browser Launched");
		driver.findElement(By.xpath("//div[@class='center']//input[@type='submit' and @value='Submit']")).click();
		System.out.println("Submit Button Clicked");

		List<WebElement> fields = driver.findElements(By.xpath(
		 "//div[@class='form_value_cell pad-B-10 pad-T-10 pad-L-10 col col-lg-7 col-md-7 col-sm-7 col-xs-7 col-mbl-12 text-left dotted-border-left']"));
		System.out.println("Size of list : " + fields.size());
		for (int i = 1; i <= fields.size(); i++) {
			
		//	System.out.println("i= " + i);

			WebElement ele = (WebElement) fields.get(i-1);
			if (ele.findElement(By.xpath("//div[@class='error']")).getText().equalsIgnoreCase("Required Field")) 
			  {
				System.out.println(driver.findElement(By.xpath(
				"//div[@class=\'content responsive-field row dotted-border-top solid-border-top-max-500\']"
				+ "[" +i+ "]/div[1]")).getText());
			  }
		}   
	}
}
