package awesome;

import java.util.Scanner;
/*Time Out*/
public class PrimeGenerator {

	static boolean prime[]=null;
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int start[]=new int[n];
		int end[]=new int[n];
//		int actEnd = (int) Math.pow(10, 8);
		int actEnd=0;
		for (int i = 0; i < end.length; i++)
		{
			start[i]=sc.nextInt();
			end[i]=sc.nextInt();
		}
		for (int i = 0; i < n; i++)
		{
			if (end[i]>actEnd)
			{
				actEnd=end[i];
			}
		}
		prime=new boolean[actEnd+1];
		findPrime(0,actEnd);
		for (int j = 0; j < end.length; j++) 
		{
			for (int i = start[j]; i < end[j]+1; i++) 
			{
				if (prime[i]==true)
				{
					System.out.println(i);
				}
			}
			System.out.println();
		}
	}
	private static void findPrime(int start, int end) 
	{
		for (int i = 0; i < end+1; i++) 
		{
			prime[i]=true;
		}
		for (int i = 2; i*i < end+1; i++) 
		{
			if (prime[i]==true)
			{
				for (int j = i*2; j <end+1; j=j+i)
				{
					prime[j]=false;
				}
			}
		}
		System.out.println();
	}
}
