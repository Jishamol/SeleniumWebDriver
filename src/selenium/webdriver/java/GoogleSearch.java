package selenium.webdriver.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//Simple program for google search

public class GoogleSearch {

	public static void main(String[] args) throws InterruptedException  {
	
		
		Utilities ui=new Utilities();
		WebDriver driver=ui.invokeApplication("https://www.google.com/");
		
		driver.findElement(By.name("q")).sendKeys("Automation");
		Thread.sleep(1000);
		driver.findElement(By.name("btnK")).click();
		driver.manage().timeouts().getPageLoadTimeout();
	}

}
