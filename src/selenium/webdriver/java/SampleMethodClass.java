package selenium.webdriver.java;

//sample method class created to access the function in another class
//This static method cannot be accessed in another class, visibility limited to this class.

public class SampleMethodClass {
	
	public String samplegetData()
	{
		System.out.println ("Sample method");
		return "SampleMethodClass return";
		
	}
	
	public static void samplegetData2()
	{
		System.out.println ("Sample static method");
	}
	
}
