package searchAlgoProblems;

import java.util.Scanner;

/*
 Given  integers, count the number of pairs of integers whose difference is K.
 
Input Format

The first line contains N and K. 
The second line contains N numbers of the set. All the N numbers are unique.*/
public class Paris
{
	public static void main(String[] args) 
	{
		Scanner in= new Scanner(System.in);
		int n = in.nextInt();
		int k=in.nextInt();
		int a[]=new int[n];
		for (int i = 0; i<n; i++)
		{
			a[i]=in.nextInt();
		}
		int count=0;
		for (int i = 0; i < a.length; i++) 
		{
			for (int j = i; j < a.length; j++) 
			{
				if (Math.abs(a[i]-a[j])==k) 
				{
					count++;
				}
			}
		}
		System.out.println(count);
	}

}
