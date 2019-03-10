import java.awt.AWTException;
 
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestCase2 {

	public static void main(String[] args) throws AWTException, InterruptedException  {
		
	
		System.setProperty("webdriver.ie.driver","F:\\Java Basic\\JAR files\\IEDriverServer.exe");
        WebDriver driver = new InternetExplorerDriver();
        driver.get("http://bg-dev.eweblife.com/prm/bgbtw/rsvp-signup/apply?record=826");
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println("Browser Launched");
		driver.findElement(By.xpath(" //*[@id=\"field_block_field_12059\"]/a")).click();
		driver.findElement(By.xpath("//img[@src='/www/default/images/cloud-upload-image.png']")).click();
		
		StringSelection imgSrc = new StringSelection("C:\\Users\\Public\\Pictures\\Sample Pictures\\Koala.jpg"); 
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(imgSrc, null);
		
		Robot robo = new Robot();
		
		robo.setAutoDelay(2000);
		robo.keyPress(KeyEvent.VK_CONTROL);
		robo.keyPress(KeyEvent.VK_V);
		
		robo.setAutoDelay(2000);
		robo.keyRelease(KeyEvent.VK_CONTROL);
		robo.keyRelease(KeyEvent.VK_V);
		
		robo.setAutoDelay(2000);
		robo.keyPress(KeyEvent.VK_ENTER);
		robo.keyRelease(KeyEvent.VK_ENTER);
		
		Actions act = new Actions(driver);                		                 
		for (int i = 1; i < 9; i++) {	
			driver.findElement(By.xpath("//*[@id=\"cropBtn_field_12059\"]/div[2]/div[2]/div/img")).click();
		}
		JavascriptExecutor js = (JavascriptExecutor) driver ;
		js.executeScript("window.scrollBy(0,-400)");  // scrolling up by -200
		System.out.println("webpage scrolled");
		Thread.sleep(4000);
		
	    WebElement cropper = driver.findElement(By.xpath("//span[@class='cropper-face cropper-move cropper-invisible']"));
	    act.clickAndHold().moveByOffset(-115, -120).release().build().perform();
	   
        driver.findElement(By.xpath("//a[@onclick='CropObject_field_12059.getCroppedNewData();']")).click();
        WebDriverWait w = new WebDriverWait(driver, 20);
        w.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\'field_image_field_12059\']/img"))));
        System.out.println("Task completed");
	}

}
