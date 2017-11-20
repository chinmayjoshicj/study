package spoj;

import java.util.Scanner;

public class dummy
{
	public static void main(String[] args)
	{
		Scanner s=new Scanner(System.in);
		
		int n=s.nextInt();
		int a=0;
		int b=0;
		for (int i = 0; i < n; i++) 
		{
			a=s.nextInt();
			b=s.nextInt();
			addReversed(a,b);
		}
	}

	private static void addReversed(int a,int b) 
	{
		
		if ((a+"").startsWith("0") && a!=0)
		{
			a=removeZeros(a);
			a=Integer.parseInt(new StringBuffer(a+"").reverse().toString());
		}
		else
			a=Integer.parseInt(new StringBuffer(a+"").reverse().toString());
		if ((b+"").startsWith("0") && b!=0)
		{
			b=removeZeros(b);
			b=Integer.parseInt(new StringBuffer(b+"").reverse().toString());
		}
		else
			b=Integer.parseInt(new StringBuffer(b+"").reverse().toString());
		
		int c=Integer.parseInt(new StringBuffer(removeZeros(a+b)+"").reverse().toString());
		System.out.println(c);
	}
	private static int removeZeros(int a) 
	{
		while((a+"").startsWith("0") && a!=0)
		{
			a=Integer.parseInt((a+"").replaceFirst("0", ""));
		}
		return a;
	}
}
