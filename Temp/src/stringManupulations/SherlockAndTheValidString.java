package stringManupulations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
Sherlock considers a string, s , to be valid if either of the following conditions are satisfied:

All characters in s have the same exact frequency (i.e., occur the same number of times). For example, s="aabbcc" is valid, but s="baacdd" is not valid.
Deleting exactly  character from  will result in all its characters having the same frequency. For example, a="aaabbcc" and s="abbcc" are valid because 
all their letters will have the same frequency if we remove  occurrence of c, but s="abcccc" is not valid because we'd need to remove 3 characters.
Given , can you determine if it's valid or not? If it's valid, print YES on a new line; otherwise, print NO instead.
*/

/*Incomplete*/
public class SherlockAndTheValidString
{
	static String isValid(String s)
	{
		HashMap<Character, Integer> h=new HashMap<>();
		for (int i = 0; i < s.length(); i++) 
		{
			if (h.containsKey(s.charAt(i))) 
			{
				h.put(s.charAt(i), h.get(s.charAt(i))+1);
			}
			else 
			{
				h.put(s.charAt(i), 1);
			}
		}
			HashMap<Integer, Integer> h1=new HashMap<>();
			for (Map.Entry<Character, Integer> entry : h.entrySet())
			{
				if (h1.containsKey(entry.getValue())) 
				{
					h1.put(entry.getValue(), h1.get(entry.getValue())+1);
				}
				else
					h1.put(entry.getValue(), 1);
			}
		if (h1.size()>2)
		{
			return "NO";
		}	
		if (h1.size()==1)
		{
			return "YES";
		}
		ArrayList<Integer>a = new ArrayList<>();
		for (Map.Entry<Integer, Integer> entry : h1.entrySet())
		{
			a.add(entry.getValue());
		}
		if (a.get(0)>1 && a.get(1)>1)
		{	
			return "NO";
		}
		if(a.get(0)-a.get(1)==1 || a.get(1)-a.get(0)==1 || a.get(0)==1 || a.get(1)==1)
		{
			return "YES";
		}
		else
		{
			return "NO";
		}
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = isValid(s);
        System.out.println(result);
    }
}
