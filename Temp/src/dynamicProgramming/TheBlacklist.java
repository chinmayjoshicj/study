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
		int rowSum[][]=new int[n][k];
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
		/*for (int i = 0; i < k; i++) 
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
		}*/
		/*System.out.println("Final array is:");
		for (int i = 0; i < k; i++) 
		{
			for (int j = 0; j < n; j++) 
			{
				System.out.print(finalArr[i][j]+" ");
			}
			System.out.println();
		}*/
		int deductRow=0;
		int row=0;
		int column=0;
		System.out.println("Final array is:");
		for (int i = 0; i < k; i++) 
		{
			/*calculate(arr,rowSum,i);*/
		}
		
		int leastCharge=0;
		for (int i = 0; i < k; i++) 
		{
			for (int j = 0; j < n; j++) 
			{
				System.out.print(rowSum[i][j]+" ");
			}
			System.out.println();
		}
	}

	private static int calculate(int[][] arr, int[] rowSum, int j2) 
	{
		return j2;
		/*for (int i = 0; i < n; i++) 
		{
			for (int j = j2; j < rowSum.length; j++) 
			{
				rowSum[row][column]+=arr[i][j-deductRow];//saving vertically by adding horizontally
			}
			deductRow++;
		}*/
	}
	
}
