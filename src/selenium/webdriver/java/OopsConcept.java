package selenium.webdriver.java;

public class OopsConcept {

	public static void main(String[] args) {
		
			OopsConcept op = new OopsConcept ();
			String ret1 = op.getData();
			System.out.println(ret1);
			
			String ret2=getData2();//static method
			System.out.println(ret2);
			
			//accessing method of another class inside same package
			SampleMethodClass sc=new SampleMethodClass();
			String ret3=sc.samplegetData();
			System.out.println(ret3);
			
			//ret3.samplegetData2();  samplegetData2 is a static method of SampleMethodClass, which cannot be accessed using object.

		}

		public String getData()
		{
			System.out.println ("hello world");
			return "Method1 return vale";
		}

		public static String getData2()
		{
			System.out.println ("hello world");
			return "Static method return value";
		}

		


}
