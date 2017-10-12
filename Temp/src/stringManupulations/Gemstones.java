package stringManupulations;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;


/*Remaining
 * 3
abcdde
baccd
eeabg
Output-2*/

/*
 * John has discovered various rocks. Each rock is composed of various elements,
 *  and each element is represented by a lower-case Latin letter from 'a' to 'z'. 
 *  An element can be present multiple times in a rock. 
 *  An element is called a gem-element if it occurs at least once in each of the rocks.
	Given the list of N rocks with their compositions, 
	display the number of gem-elements that exist in those rocks.
 * */

public class Gemstones 
{
		static HashMap<Integer, Integer> countMap=new HashMap<>();
		static int gemstones(String[] arr)
		{
			int i=0;
			int j=0;
			int finalCount=0;
			boolean a1[]=new boolean[256];
			String a="";
			for (i = 0; i < arr.length; i++) 
			{
				a=arr[i];
				for (j = 0; j < arr[i].length(); j++) 
				{
					if (countMap.containsKey((int)arr[i].charAt(j)) && !a1[(int)arr[i].charAt(j)])
					{
						int count=countMap.get((int)arr[i].charAt(j))+1;
						countMap.put((int) arr[i].charAt(j), count);
						a1[arr[i].charAt(j)]=true;
					}
					else if (countMap.containsKey((int)arr[i].charAt(j))) 
					{
						int count=countMap.get((int)arr[i].charAt(j));
						countMap.put((int) arr[i].charAt(j), count);
						a1[arr[i].charAt(j)]=true;
					}
					else
					{
						countMap.put((int) arr[i].charAt(j), 1);
						a1[arr[i].charAt(j)]=true;
					}
				}
				Arrays.fill(a1, false);
			}
			for (int value : countMap.values()) 
			{
			    if (value==arr.length)
			    {
			    	finalCount++;
				}
			}
			return finalCount;
		}

	    public static void main(String[] args) 
	    {
	        Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        String[] arr = new String[n];
	        for(int arr_i = 0; arr_i < n; arr_i++)
	        {
	            arr[arr_i] = in.next();
	        }
	        int result = gemstones(arr);
	        System.out.println(result);
	    }
}
