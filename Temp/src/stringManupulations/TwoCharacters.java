package stringManupulations;

import java.util.ArrayList;
import java.util.HashSet;

/*String  always consists of two distinct alternating characters.
For example, if string 's two distinct characters are x and y, then t could be xyxyx or yxyxy but not xxyy or xyyx.
You can convert some string  to string  by deleting characters from . 
When you delete a character from , you must delete all occurrences of it in . 
For example, if  abaacdabd and you delete the character a, then the string becomes bcdbd.
Given , convert it to the longest possible string . 
Then print the length of string  on a new line; if no string  can be formed from , print  instead.*/

//Incomplete

public class TwoCharacters 
{
	public static void main(String[] args)
	{
		String s="abaa	cdabd";
		perform(s);
	}

	private static void perform(String s)
	{
		HashSet<Character> set=new HashSet<>();            
		ArrayList<Character> list= new ArrayList<>();      
		ArrayList<Character> templist= new ArrayList<>();  
	            
		int j=0;
		for (int i = 0; i < s.length(); i++)
		{
			set.add(s.charAt(i));
			list.add(s.charAt(i));
		}
		if (set.size()==2)
		{
			System.out.println(s);
			return;
		}
		templist.addAll(list);
		for (Character ele : set) 
		{
			ArrayList<Character> a=new ArrayList<Character>();
			a.add(ele);
			list.removeAll(a);
			print(list);
			list.clear();
			list.addAll(templist);
			System.out.println();
			perform(s);
		}
	}

	private static void print(ArrayList<Character> list) 
	{
		if (check(list))
		{
		}
		for (Character character : list)
		{
			System.out.print(character);
		}
	}

	private static boolean check(ArrayList<Character> list) 
	{
		char prev = 0;
		for (Character character : list) 
		{
			if (prev==character)
			{
				prev=character;
				return false;
			}
			prev=character;
		}
		return true;
	}

}
