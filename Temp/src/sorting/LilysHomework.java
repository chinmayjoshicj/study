package sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
/*
Whenever George asks Lily to hang out, she's busy doing homework. 
George wants to help her finish it faster, but he's in over his head! 
Can you help George understand Lily's homework so she can hang out with him?
Consider an array of distinct integers,A . George can swap any two elements of the array any number of times. 
An array is beautiful if the sum of|ai-ai-1| among is minimal possible (after, possibly, performing some swaps).
Given the array , find and print the minimum number of swaps that should be performed in order to make the array beautiful. */
/*https://www.hackerrank.com/challenges/lilys-homework/problem*/
/*INcomplete*/
public class LilysHomework {
	public static void main(String[] args) 
	{
		Scanner sc= new Scanner(System.in);       
        int n=sc.nextInt();
      
        Integer initialArray[]=new Integer[n];
        for (int i = 0; i < n; i++) 
        {
			initialArray[i]=sc.nextInt();
		}
        Integer sorted[]=new Integer[n];
        Integer original[]=new Integer[n];
        original=initialArray.clone();
        sorted=initialArray.clone();
        Arrays.sort(sorted);
        int asc=check(initialArray,sorted);
        Collections.reverse(Arrays.asList(sorted));
        int desc=check(original,sorted);
        System.out.println(asc<desc?asc:desc);
	}

	private static int check(Integer[] initialArray, Integer[] sorted) 
	{
		int count=0;
		
		HashMap<Integer, Integer> map1=new HashMap<>();
        for (int i = 0; i < initialArray.length; i++) 
        {
        	map1.put(initialArray[i], i);
        }
        
        for (int i = 0; i < sorted.length; i++) 
        {
        	if (initialArray[i]!=sorted[i])
        	{
        		count++;
        		int temp=initialArray[i];
        		initialArray[i]=sorted[i];
        		initialArray[map1.get(sorted[i])]=temp;
			}
		}
        return count;
	}
}

