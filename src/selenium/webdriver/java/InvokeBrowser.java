package selenium.webdriver.java;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InvokeBrowser {

	public static void main(String[] args)  {
	
		
		String projectpath=System.getProperty("user.dir");
		System.out.println(projectpath);
		String osname=System.getProperty("os.name").toLowerCase();
		//System.out.print(osname);
		
		if (osname.contains("mac"))
		{
		System.setProperty("webdriver.chrome.driver", projectpath+"/resources/drivers/chrome/chromedriver");
		}
		else
		{
			System.setProperty("webdriver.chrome.driver", projectpath+"/resources/drivers/chrome/chromedriver.exe");
		}

		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com/");
		
	}

}
