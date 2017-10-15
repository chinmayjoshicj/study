package stringManupulations;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

/*
6
aaabbb
ab
abc
mnop
xyyx
xaxbbbxx*/
/*
 Output 
3
1
-1
2
0
1
*/
/*
 TestCase #01: We have to replace all three characters from the first string
 to make both of strings anagram.
 Here, S1= "aaa" and S2= "bbb". 
 So the solution is to replace all character 'a' in string a with character 'b'.
Test Case #02: You have to replace 'a' with 'b', which will generate "bb".
Test Case #03: It is not possible for two strings of unequal length to be anagram for each other.
Test Case #04: We have to replace both the characters of first string ("mn") to make it anagram of other one.
Test Case #05: S1 and S2 are already anagram to each other.
Test Case #06: Here S1 = "xaxb" and S2 = "bbxx". 
He had to replace 'a' from S1 with 'b' so that S1 = "xbxb" 
and we can rearrange its letter to "bbxx" in order to get S2.
 */

/*Time Complexity*/
public class Anagram 
{
	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            int result = anagaram(s);
            System.out.println(result);
        }
	}

	private static int anagaram(String s)
	{
		HashMap<Integer, Character> h=new HashMap<>();
		int count=0;
		int match=0;;
		String s1=s.substring(0, s.length()/2);//xaxb
		String s2=s.substring(((s.length()/2)),s.length());//bbxx
		if (s.length()%2!=0)
		{
			return -1;
		}
		String compare1=s1.length()>s2.length()?s2:s1;
		String compare2=s1.length()>s2.length()?s1:s2;
		if (!s1.equals(s2)) 
		{
			for (int i = 0; i < compare1.length(); i++) 
			{
				if (compare2.matches(compare1))
				{
					match++;
					continue;
				}
			}
		}
		if (match==compare1.length())
		{
			return -1;
		}
		for (int i = 0; i < s.length()/2; i++)
		{
			h.put(i,s.charAt(i));
			if (h.containsValue(s.charAt(i+(s.length()/2))))
			{
				continue;
			}
		}
		for (int i = (s.length()/2); i < s.length(); i++) 
		{
			if (h.containsValue((s.charAt(i))))
			{
				for (HashMap.Entry<Integer, Character> pair : h.entrySet())
				{
				    if (pair.getValue()==s.charAt(i))
				    {
				    	h.remove(pair.getKey());
				    	break;
					}
				}
				continue;
			}
			else
				count++;
		}
		return count;
	}

}
