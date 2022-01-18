
package selenium.webdriver.java;

import java.util.Calendar;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Utilities {

	public static WebDriver driver;

	/**
	 * ##########################################################################################
	 * Created on : 01/08/2022 Purpose : Invoke an application in Chrome browser
	 * 
	 * @param browserUrl - Application URL
	 * @return driver
	 * ##########################################################################################
	 */

	public WebDriver invokeApplication(String browserUrl)

	{
		String projectPath = System.getProperty("user.dir");
		System.out.println(projectPath);
		String osname = System.getProperty("os.name").toLowerCase();
		System.out.print(osname);

		if (osname.contains("mac")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "/resources/drivers/chrome/chromedriver");
		} else {
			System.setProperty("webdriver.chrome.driver", projectPath + "/resources/drivers/chrome/chromedriver.exe");
		}
		driver = new ChromeDriver();
		driver.get(browserUrl);
		driver.manage().window().maximize();
		return driver;
	}

	/**
	 * ##########################################################################################
	 * Created on : 01/08/2022 Purpose : Return integer value with 3 digits
	 * 
	 * @return randomNumber
	 * ##########################################################################################
	 */

	public int randomIntGenerator() {

		Random rand = new Random();
		int randomNumber = rand.nextInt(1000);
		return randomNumber;

	}

	/**
	 * ##########################################################################################
	 * Created on : 01/09/2022 Purpose :Generate email id
	 * 
	 * @return randomEmail
	 * ##########################################################################################
	 */

	public String randomEmailGenerator() {
		String randomEmail = generateRandomString(6) + randomIntGenerator() + "@gmail.com";
		return randomEmail;

	}

	/**
	 * ##########################################################################################
	 * Created on : 01/09/2022 Purpose : Generate random string value
	 * 
	 * @param wordLength - length of the string
	 * @return sb.toString()
	 * ##########################################################################################
	 */
	public String generateRandomString(int wordLength) {
		Random r = new Random();
		StringBuilder sb = new StringBuilder(wordLength);
		for (int i = 0; i < wordLength; i++) {
			char tmp = (char) ('A' + r.nextInt('Z' - 'A'));
			sb.append(tmp);
		}
		return sb.toString();
	}

	/**
	 * ##########################################################################################
	 * Created on : 01/09/2022 Purpose :Generate integer values
	 * 
	 * @param noOfDigits - length of integer value
	 * @return FinalString
	 * ##########################################################################################
	 */

	public String generateRandomInt(int noOfDigits) {
		int min = 0, max = 0, randomNum = 0;
		String sNumberMin = "1", sNumberMax = "9", FinalString = "";
		Random rand = new Random();

		for (int idig = 0; idig < noOfDigits - 1; idig++) {
			sNumberMin = sNumberMin + "0";
			sNumberMax = sNumberMax + 9;
		}

		min = Integer.parseInt(sNumberMin);
		try {
			max = Integer.parseInt(sNumberMax);
		} catch (Exception e) {
			max = 999999999;
		}
		randomNum = rand.nextInt((max - min) + 1) + min;

		if (noOfDigits > 9) {
			String sNewStringofInteger = String.valueOf(randomNum);
			for (int start = 10; start < noOfDigits; start++) {
				sNewStringofInteger = sNewStringofInteger + "3";
			}
			FinalString = sNewStringofInteger;
		} else {
			FinalString = String.valueOf(randomNum);
		}

		return FinalString;
	}

	/**
	 * #############################################################################
	 * Created on : 01/09/2022 Purpose :Generate phone number in different format
	 * 
	 * @param phoneNumberFormat - format of phone number to return
	 * @return actualNumber
	 * #############################################################################
	 */

	public String generatePhoneNumber(String phoneNumberFormat) {

		String areaCode = "";
		String actualNumber = "";
		Calendar now = Calendar.getInstance();
		int hour = now.get(Calendar.HOUR_OF_DAY);

		if (hour > 20) {
			areaCode = "818";
		} else if (hour > 15) {
			areaCode = "614";
		} else if (hour > 10) {
			areaCode = "310";
		} else if (hour > 5) {
			areaCode = "646";
		} else {
			areaCode = "402";
		}

		if (phoneNumberFormat.contains("NUM")) {
			actualNumber = areaCode + generateRandomInt(3) + generateRandomInt(4);
		} else if (phoneNumberFormat.contains("HYN")) {
			actualNumber = areaCode + "-" + generateRandomInt(3) + "-" + generateRandomInt(4);
		} else if (phoneNumberFormat.contains("PNH")) {
			actualNumber = "(" + areaCode + ") " + generateRandomInt(3) + "-" + generateRandomInt(4);
		}

		return actualNumber;
	}

	/**
	 * #############################################################################
	 * Created on : 01/18/2022 Purpose : Select value from drop down based on index
	 * ,value and text
	 * 
	 * @param selectElement  - element locator
	 * @param selectBy       - index, value and text
	 * @param selectionValue - value to be selected
	 * #############################################################################
	 */

	public void dropdownSelection(WebElement selectElement, String selectBy, String selectionValue) {

		Select selectObject = new Select(selectElement);

		if (selectBy.matches("index")) {
			selectObject.selectByIndex(Integer.parseInt(selectionValue));

		} else if (selectBy.matches("value")) {
			selectObject.selectByValue(selectionValue);

		} else if (selectBy.matches("text")) {
			selectObject.selectByVisibleText(selectionValue);
		}

	}
}
