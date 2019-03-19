package practice;

public class Fibonacci {

	public static void main(String[] args) 
	{
		int first=0;
		int second=1;
		System.out.println(first);
		System.out.println(second);
		printFibo(first,second);
	}

	private static void printFibo(int first, int second) 
	{
		if (second<20) {
			int temp=first+second;
			System.out.println(temp);
			printFibo(second, temp);
		}
	}
}
