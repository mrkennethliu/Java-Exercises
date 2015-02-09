//Various programming exercises 
import java.util.*;

public class exercises{
	public static String MultiplyAnyTwoNum(int a, int b){
		return a + " times "+ b + " = "+ (a*b) + ".";
	}
	public static String EvenOrOdd(int a){
		if (a%2==0){
			return a+" is Even.";
		}else{
			return a + " is Odd.";
		}
	}
	public static void DeclareVar(){
		int a = 5;
		System.out.println("The variable a is declared with value: "+a);
		String s = "something";
		System.out.println("The variable s is declared with value: "+s);
	}
	public static void minMaxInt(){
		System.out.println("The lowest Integer value is " + Integer.MIN_VALUE);
		System.out.println("The largest Integer value is " + Integer.MAX_VALUE);
	}
	public static void FizzBuzz(){
		for (int i=1;i<=100;i++){
			if (i%3==0 && i%5==0){
				System.out.println("FizzBuzz");
			}
			else if (i%3==0){
				System.out.println("Fizz");
			}
			else if (i%5==0){
				System.out.println("Buzz");
			}
			else{
				System.out.println(i);
			}
				
		}
		
	}
	public static int fib(int n){
		if (n==0) return 0;
		if (n==1) return 1;
		int prev1 = 1;
		int prev2 = 0;
		int fibval = prev1 + prev2;
		for (int i=2;i<n;i++){
			prev2 = prev1;
			prev1 = fibval;
			fibval = prev1 + prev2;
		}
		return fibval;
	}
	public static int fib2(int n){
		if (n==1) return 1;
		int prev1 = 1;
		int prev2 = 0;
		int fibval = prev1 + prev2;
		for (int i=2;i<n;i++){
			prev2 = prev1;
			prev1 = fibval;
			fibval = prev1 + prev2;
		}
		return fibval;
	}
	public static int fib3(int n){
		if (n==0) return 0;
		if (n==1) return 1;
		return fib3(n-1) + fib3(n-2);
	}
	public static ArrayList<Integer> fib4(int n){
		ArrayList<Integer> fibbers = new ArrayList<Integer>();
		if (n==1) return new ArrayList<Integer>(Arrays.asList(1));
		int prev1 = 1;
		int prev2 = 0;
		int fibval = prev1 + prev2;
		fibbers.add(fibval);
		for (int i=2;i<n;i++){
			prev2 = prev1;
			prev1 = fibval;
			fibval = prev1 + prev2;
			fibbers.add(fibval);			
		}
		return fibbers;
	}
	public static void main(String[] args){
		System.out.println(fib4(2));
		System.out.println(fib4(3));
		System.out.println(fib4(10));
	}
}
