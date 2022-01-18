package selenium.webdriver.java;

import java.util.ArrayList;

public class JavaBasics {

//Some very basic java facts
	
public static void main(String[] args) {

//variable declaration

int myNum = 5;

String website = "Google";

//char letter = 'r';

//double dec = 5.99;

//boolean myCard = true;



System.out.println(myNum+"is the value stored in the myNum variable");

System.out.println(website);

//Arrays -

int[] arr = new int[5];// 5, 10

arr[0] = 1;

arr[1] = 2;

arr[2]= 4;

arr[3]= 5;

arr[4]= 6;







//for loop arr.length - 5

for(int i = 0; i< arr.length; i++) //4

{

if (arr[i]%2==0)
{
System.out.println(arr[i]);

}
else
{
	System.out.println(arr[i]+ "not divided by 2");
}

}
//array--2

int[] arr2 = {1,2,4,5,6};

for (int i =0;i<arr2.length; i++)

{

System.out.println(arr2[i]);

}


//Array 3--string

String[] name = {"Jishamol", "Thankachan", "Thadathimackel"};



for(int i =0; i<name.length;i++)

{

System.out.println(name[i]);

}


//alternative easy way to print array--for each

for( String s: name)

{

System.out.println(s);

}


//arraylist -is a class
//In array , need to specify the size while initializing and can't increase the size
//whereas in array list it will get incremented automatically. 

ArrayList<String> a= new ArrayList<String>();

a.add("Automation");
a.add("Testing");

System.out.println(a.get(0));
System.out.println(a.get(1));

a.remove(1);//removing "Testing"

System.out.println(a.get(0));
System.out.println(a.get(1)); // it will throw IndexOutOfBoundsException exception since its removed


}



}




