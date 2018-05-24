package stringManupulations;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

/*A uniform string is a string consisting of a single character repeated zero or more times. For example, 
 * ccc and a are uniform strings, but bcb and cd are not (i.e., they consist of more than one distinct character).
Given a string, , let  be the set of weights for all possible uniform substrings (contiguous) of string . 
You have to answer  queries, where each query  consists of a single integer, . For each query, print Yes on a new line if ; otherwise, print No instead.*/

public class WeightedUniformStrings 
{
	public static void main(String[] args) 
	{
		//String s="abccddde";
//		int alphabets[] = new int[26];
//		int temp[]=new int[26];
		Scanner in = new Scanner(System.in);
        String s = in.next();
        s = s.toLowerCase();
        int n = in.nextInt();
        Set<Integer> a = new HashSet<Integer>();// Using set to improve performance
        Stack<Character> st=new Stack<>();
        for (int j = 0; j < s.length(); j++)
        {
        	if (j==0 || st.isEmpty()) 
        	{
				st.push(s.charAt(j));
				continue;
			}
        	if (st.peek()==s.charAt(j))
        	{
        		st.push(s.charAt(j));
			}
        	else
        	{
        		while (!st.isEmpty())
        		{
        			a.add(st.size()*(st.peek()-96));
        			st.pop();
				}
        		st.push(s.charAt(j));
        	}
        }
        if (!st.isEmpty()) 
        {
			while (!st.isEmpty())
			{
				a.add(st.size()*(st.peek()-96));
    			st.pop();
			}
		}
        for(int a0 = 0; a0 < n; a0++)
        {
        	//System.out.println(a);
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
