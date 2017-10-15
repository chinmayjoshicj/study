package stringManupulations;

import java.util.ArrayList;
import java.util.Scanner;
/*Incomplete*/

public class MakingAnagrams {

	static int makingAnagrams(String s1, String s2)
	{
		int count=0;
		ArrayList<Character> a=new ArrayList<>();
		for (int i = 0; i < s1.length(); i++) 
		{
			a.add(s1.charAt(i));
		}
		for (int i = 0; i < s2.length(); i++) 
		{
			if (!a.contains(s2.charAt(i)))
			{
				count++;
			}
			else
			{
				int index=a.indexOf(s2.charAt(i));
				a.remove(index);
			}
		}
		int greater=s1.length()>s2.length()?s1.length():s2.length();
		int small=s1.length()<s2.length()?s1.length():s2.length();
		int diff=(greater-small);
		return count+count+diff+diff;
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String s1 = in.next();
        String s2 = in.next();
        int result = makingAnagrams(s1, s2);
        System.out.println(result);
    }

}
