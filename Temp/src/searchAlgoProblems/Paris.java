package searchAlgoProblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/*
 Given  integers, count the number of pairs of integers whose difference is K.
 
Input Format

The first line contains N and K. 
The second line contains N numbers of the set. All the N numbers are unique.*/

/*Incomplete*/
public class Paris
{
	public static void main(String[] args) 
	{
		Scanner in= new Scanner(System.in);
		int n = in.nextInt();
		int k=in.nextInt();
		int a[]=new int[n];
		ArrayList<Integer>a1=new ArrayList<>();
		for (int i = 0; i<n; i++)
		{
			a[i]=in.nextInt();
		}
		int count=0;
		int j=0;
		for (int i = 0; i < a.length; i++) 
		{
			/*for (int j = i; j < a.length; j++) 
			{
				if (Math.abs(a[i]-a[j])==k) 
				{
					count++;
				}
			}*/
			a1.add(a[i]);
		}
		ArrayList<Integer>a2=new ArrayList<>();
		a2.addAll(a1);
		HashMap<Integer, Integer> map=new HashMap<>();
		for (Integer integer : a1) 
		{
				map.put(integer+k, 1);
				map.put(integer-k, 1);
		}
		for (Integer integer : a1) 
		{
			if (map.containsKey(integer))
			{
				map.remove(integer);
				count++;
			}
		}
		System.out.println(count);
	}

}
