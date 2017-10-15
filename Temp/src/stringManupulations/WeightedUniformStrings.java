package stringManupulations;

import java.util.ArrayList;
import java.util.Scanner;

/*A uniform string is a string consisting of a single character repeated zero or more times. For example, 
 * ccc and a are uniform strings, but bcb and cd are not (i.e., they consist of more than one distinct character).
Given a string, , let  be the set of weights for all possible uniform substrings (contiguous) of string . 
You have to answer  queries, where each query  consists of a single integer, . For each query, print Yes on a new line if ; otherwise, print No instead.*/


/*Timed OUT in HackerRank*/

public class WeightedUniformStrings 
{
	//Incomplete
	public static void main(String[] args) 
	{
		//String s="abccddde";
//		int alphabets[] = new int[26];
//		int temp[]=new int[26];
		Scanner in = new Scanner(System.in);
        String s = in.next();
        s = s.toLowerCase();
        int n = in.nextInt();
        ArrayList<Integer> a=new ArrayList<>();
        int k=1;
        int i=1;
        for (int j = 0; j < s.length(); j=j+i)
        {
        	i=1;
        	k=j;
        	while (k<s.length() && s.charAt(k)==s.charAt(j))
        	{
        		if (k>j) 
        		{
        			i++;
        			a.add(a.get(a.size()-1) + (s.charAt(j)-96));
        		} else {
        			a.add((s.charAt(j)-96));
        		}
        		k++;
			}
        }
        for(int a0 = 0; a0 < n; a0++)
        {
            int x = in.nextInt();
            if (a.contains(x))
            {
            	System.out.println("Yes");
			}
            else
            	System.out.println("No");
        }
	}

}
