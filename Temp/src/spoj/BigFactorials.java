package spoj;

import java.math.BigInteger;
import java.util.Scanner;


public class BigFactorials 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		for (int i = 0; i < n; i++) 
		{
			calculateFact(sc.nextInt());
		}
	}

	private static void calculateFact(int nextInt) 
	{
		BigInteger fact=BigInteger.valueOf(1);
		for (int i = 1; i <= nextInt; i++)
		{
			fact=fact.multiply(BigInteger.valueOf(i));
		}
		System.out.println(fact);
	}
}
