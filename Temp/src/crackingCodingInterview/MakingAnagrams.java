package crackingCodingInterview;

import java.util.Scanner;

public class MakingAnagrams {

	public static void main(String[] args)
	{
		/*Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();*/
        System.out.println(numberNeeded("abc", "cde"));
	}

	private static int numberNeeded(String a, String b) 
	{
		int arr1[]=countAlphabets(a);
		int arr2[]=countAlphabets(b);
		int count=0;
		
		for (int i = 0; i < arr2.length; i++) 
		{
			count+=Math.max(arr1[i]-arr2[i],arr2[i]-arr1[i]);
		}
		return count;
	}

	private static int[] countAlphabets(String a) 
	{
		int alphabets[]=new int[26];
		for (int i = 0; i < a.length(); i++) 
		{
			alphabets[a.charAt(i)-'a']=alphabets[a.charAt(i)-'a']+1;
		}
		return alphabets;
	}

}
