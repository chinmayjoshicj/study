package stringManupulations;

import java.util.Scanner;

/*
 We have  pairs to check:
. The substrings s1 and  s2 are common to both a and b, so we print YES on a new line.
. Because  and  have no common substrings, we print NO on a new line.
 */
public class TwoStrings 
{
	static String twoStrings(String s1, String s2)
	{
		for(char c : "abcdefghijklmnopqrstuvwxyz".toCharArray())
		{
		        if(s1.indexOf(c) > -1 && s2.indexOf(c) > -1)
		        return "YES";
		}
		return "NO";
    }
    public static void main(String[] args) 
    {
    	Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s1 = in.next();
            String s2 = in.next();
            String result = twoStrings(s1, s2);
            System.out.println(result);
        }
    }

}
