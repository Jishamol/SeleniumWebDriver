package selenium.webdriver.java;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Locators{
	
	public static WebDriver driver;

	
	public static void main(String[] args) throws Exception {

		Utilities ui=new Utilities();
		Locators loc=new Locators();
		
		driver=ui.invokeApplication("http://automationpractice.com/index.php");
		System.out.println((driver.manage().toString()));
		//driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[normalize-space()='Sign in']")).click();
		//driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
	
		/*
		 * System.out.println(ui.randomIntGenerator());
		 * System.out.println(ui.randomEmailGenerator());
		 * System.out.println(ui.generateRandomString(8));
		 * System.out.println(ui.generatePhoneNumber("HYN"));
		 * System.out.println(ui.generatePhoneNumber("PNH"));
		 * System.out.println(ui.generatePhoneNumber("NUM"));
		 * 
		 */
		
		loc.newUserCreation();
		

	}
	
	/*
	 * ##########################################################################################
	 * Created by :Jisha 
	 * Created on : 01/16/2022 
	 * Purpose :To sign up for new user with auto generated values 
	 * Dependency : Utilities class
	 * ##########################################################################################
	 */
	
	
	public void newUserCreation() throws InterruptedException
	
	{
		Utilities ui=new Utilities();
		driver.findElement(By.id("email_create")).sendKeys(ui.randomEmailGenerator());
		driver.findElement(By.cssSelector("#SubmitCreate > span")).click();
		//Thread.sleep(4000);
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
		//driver.findElement(By.id("id_gender2")).click();
		driver.findElement(By.cssSelector("input[id^='id_gender'][value='2']")).click(); //generated manually using selectorshub
		driver.findElement(By.id("customer_firstname")).sendKeys(ui.generateRandomString(5));
		driver.findElement(By.id("customer_lastname")).sendKeys(ui.generateRandomString(5));
		driver.findElement(By.id("passwd")).sendKeys("Auto1234");
		
		WebElement date_day=driver.findElement(By.id("days"));
		WebElement date_mon=driver.findElement(By.id("months"));
		WebElement date_yr=driver.findElement(By.id("years"));
		ui.dropdownSelection(date_day,"index", "5");
		ui.dropdownSelection(date_mon,"value", "11");
		ui.dropdownSelection(date_yr,"value", "1985");
		
		/*
		 * Select sel_d=new Select(date_day); sel_d.selectByIndex(5);
		 * 
		 * Select sel_m=new Select(date_mon); sel_m.selectByIndex(9);
		 * 
		 * Select sel_y=new Select(date_yr); sel_y.selectByIndex(10);
		 */
		
		//driver.close();
		
		
		
	}

}
