package sorting;

import java.util.Scanner;

public class countingSquares {

	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		while (n!=0)
		{
			int sum=0;
			for (int i = 1; i <= n; i++)
			{
				sum=sum+i*i;
			}
			System.out.println(sum);
			n=sc.nextInt();
		}
	}
}
