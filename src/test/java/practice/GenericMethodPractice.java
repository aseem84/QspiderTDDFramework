package practice;

public class GenericMethodPractice {
	                                          //user
	public static void main(String[] args) { // Caller Function
		
//		int a = 20;  Hard Coded
//		int b = 30;
//		int c = a+b;
//		System.out.println(c);
		
		int sum = add(19,40);
		System.out.println(sum);
		int data = sum+10;
		System.out.println(data);
		
		sub();
		add(30,50);
		add(50,60);
	}
	              //Parameterisation - inputs from Caller - 1
	public static int add(int a, int b) //Called function - generic methods
	{
		int c= a+b;
		return c;
		//return the output to Caller - 2
		
	}
	
	public static void sub() //Called function
	{
		int a = 20;
		int b = 30;
		int c= b-a;
		System.out.println(c);
	}


}
