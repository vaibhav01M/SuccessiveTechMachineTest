import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestCase3 {

	public static void main(String[] args) throws InterruptedException, AWTException {
	 
		System.setProperty("webdriver.ie.driver","F:\\Java Basic\\JAR files\\IEDriverServer.exe");
        WebDriver driver = new InternetExplorerDriver();
         
        driver.get("http://bg-dev.eweblife.com/prm/bgbtw/rsvp-signup/apply?record=826");
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println("Browser Launched");

        driver.findElement(By.xpath("//input[@id='field_12052' and @name='field[12052][value]']")).sendKeys("ABC");  
        driver.findElement(By.xpath("//input[@id='field_12053' and @name='field[12053][value]']")).sendKeys("XYZ");
        driver.findElement(By.xpath("//input[@type='text' and @name='field[12054][value]']")).sendKeys("abcxyz@qmail.com");
        driver.findElement(By.xpath("//input[@id='phone_flag_field_12055_6884']")).click();
        driver.findElement(By.xpath("//input[@name='field[12055][value][6884][number]' and @class='input_text_115']")).sendKeys("9898989898");
        driver.findElement(By.xpath("//input[@name='field[12055][value][6884][extension]']")).sendKeys("91");
        driver.findElement(By.xpath("//input[@id='field-12056-field_value_id-3627' ]")).click();
        driver.findElement(By.xpath("//input[@id='field-12056-sub_field_ids-20-field_value_id-1']")).click();
        driver.findElement(By.xpath("//input[@id='field_12056_sub_field_ids_2']")).sendKeys("pqrstu");
                
        WebElement profileDD = driver.findElement(By.xpath("//select[@name='field[12058][field_value_id]']"));
        Select proDD = new Select(profileDD);
        proDD.selectByValue("3730");
        driver.findElement(By.xpath("//textarea[@name='field[12058][sub_field_ids][6839][value]']")).sendKeys("Senior Tester");
        driver.findElement(By.xpath("//input[@name='field[12058][sub_field_ids][5936][value]']")).sendKeys("Nicky");
        
        driver.findElement(By.xpath(" //*[@id=\"field_block_field_12059\"]/a")).click();
		driver.findElement(By.xpath("//img[@src='/www/default/images/cloud-upload-image.png']")).click();
	StringSelection imgSrc = new StringSelection("F:\\Java Basic\\workspace 4.10.0\\SuccessiveMachineTest\\folder\\Koala.jpg"); 
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

        
        
        
        
        driver.findElement(By.xpath("//input[@type='checkbox' and @name='group_leader']")).click();
        driver.findElement(By.xpath("//input[@type='text' and @name='group_name']")).sendKeys("Royal");
        driver.findElement(By.xpath("//input[@type='text' and @name='group_state']")).sendKeys("MP");
        driver.findElement(By.xpath("//input[@type='text' and @name='group_city']")).sendKeys("bhopal");
        driver.findElement(By.xpath("//input[@type='text' and @id='group_people']")).sendKeys("Yes- Rs-500");
        driver.findElement(By.xpath("//input[@type='radio' and @id='attending_status_may_be']")).click();
        driver.findElement(By.xpath("//input[@type='checkbox' and @value='1' and @name='show_rsvp_information']")).click();
        
        WebElement ticketDD = driver.findElement(By.xpath("//select[@id='section_674_745']"));
        Select tktDD = new Select(ticketDD);
        tktDD.selectByValue("2");
        
        driver.findElement(By.xpath("//input[@type='password' and @name='password']")).sendKeys("abc@123");
        driver.findElement(By.xpath("//input[@type='password' and @name='confirm_password']")).sendKeys("abc@123");
        
        WebElement securityQueDD = driver.findElement(By.xpath("//select[@name='security_question_id' and @class='select_250']"));
        Select queDD = new Select(securityQueDD);
        queDD.selectByValue("8");
        
        driver.findElement(By.xpath("//input[@type='text' and @name='security_answer']")).sendKeys("Dada");
        driver.findElement(By.xpath("//*[@id=\"volunteerForm\"]/div[10]/input")).click();
        
	}

}
