package dynamicProgramming;

import java.util.Scanner;

/*Incomplete
 * https://www.hackerrank.com/challenges/the-blacklist/problem*/
public class TheBlacklist {

	public static void main(String[] args)
	{
		Scanner sc= new Scanner(System.in);
		int n=sc.nextInt();
		int k=sc.nextInt();
		int arr[][]=new int[k][n];
		int finalArr[][]=new int[k][n];
		for (int i = 0; i < k; i++) 
		{
			for (int j = 0; j < n; j++) 
			{
				arr[i][j]=sc.nextInt();
			}
		}
		/*for (int i = 0; i < k; i++) 
		{
			for (int j = 0; j < n; j++) 
			{
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}*/
		for (int i = 0; i < k; i++) 
		{
			for (int j = 0; j < n; j++) 
			{
				if (i==0)
				{
					finalArr[i][j]=arr[i][j];
				}
				else
					finalArr[i][j]=Math.min(finalArr[i-1][j], arr[i][j]);
			}
		}
		System.out.println("Final array is:");
		for (int i = 0; i < k; i++) 
		{
			for (int j = 0; j < n; j++) 
			{
				System.out.print(finalArr[i][j]+" ");
			}
			System.out.println();
		}
		int leastCharge=0;
		for (int i = 0; i < n; i++) 
		{
			leastCharge+=finalArr[k-1][i];
		}
		System.out.println(leastCharge);
	}
	
}
