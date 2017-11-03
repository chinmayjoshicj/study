package searchAlgoProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 Numeros, the Artist, had two lists A and B, such that B was a permutation of A.
 Numeros was very proud of these lists. Unfortunately, while transporting them from one exhibition to another,
 some numbers were left out of A. 
 Can you find the missing numbers?

Notes

1)If a number occurs multiple times in the lists, you must ensure that the frequency of that number in both lists is the same. 
2)If that is not the case, then it is also a missing number.
3)You have to print all the missing numbers in ascending order.
4)Print each missing number once, even if it is missing multiple times.
The difference between maximum and minimum number in B is less than or equal to 100.
 */
public class MissingNumbers 
{
	static HashMap<Integer, Integer> map1=new HashMap<>();
	static HashMap<Integer, Integer> map2=new HashMap<>();
	public static void main(String[] args) 
	{
		Scanner sc= new Scanner(System.in);
		int n=sc.nextInt();
		int arr1[]=new int[n];
		
		for (int i = 0; i < arr1.length; i++) 
		{
			arr1[i]=sc.nextInt();
		}
		int m=sc.nextInt();
		int arr2[]=new int[m];
		for (int i = 0; i < arr2.length; i++) 
		{
			arr2[i]=sc.nextInt();
		}
		map1=insert(arr1,map1);
		map2=insert(arr2,map2);
		check();
	}

	private static void check()
	{
		int a[]= new int[map2.size()];
		ArrayList<Integer> arrList=new ArrayList<>();
		Arrays.fill(a, Integer.MAX_VALUE);
		int i=0;
		for (Map.Entry<Integer, Integer> entry : map2.entrySet())
		{
			if (map1.containsKey(entry.getKey()))
			{
				if (!map1.get(entry.getKey()).equals(entry.getValue()))//!= didn't work
				{
					if (!arrList.contains(entry.getKey())) 
					{
						arrList.add(entry.getKey());
					}
				}
			}
			else
			{
				if (!arrList.contains(entry.getKey())) 
				{
					arrList.add(entry.getKey());
				}
			}
		}
		for (Integer integer : arrList) 
		{
			a[i++]=integer;
		}
		Arrays.sort(a);
		for (int j = 0; j < a.length; j++) 
		{
			if (a[j]==Integer.MAX_VALUE) 
			{
				break;
			}
			System.out.print(a[j]+" ");
		}
	}
	private static HashMap<Integer, Integer> insert(int[] arr, HashMap<Integer, Integer> map1) 
	{
		for (int i = 0; i < arr.length; i++) 
		{
			if (map1.containsKey(arr[i]))
			{
				map1.put(arr[i], map1.get(arr[i])+1);
			}
			else
			{
				map1.put(arr[i], 1);
			}
		}
		return map1;
	}
}
