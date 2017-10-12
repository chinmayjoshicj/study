package stringManupulations;

import java.util.Scanner;

/*You are given a string containing characters A and B only, your task is to change it into a string such that every two consecutive characters are different. To do this, you are allowed to delete one or more characters in the string.

Your task is to find the minimum number of required deletions.

For example, string ABAA should be changed to ABA by deleting one character .*/

/*5
AAAA
BBBBB
ABABABAB
BABABA
AAABBB*/

/*Output
 *  3
4
0
0
4
 * */
public class AlternatingCharacters
{
	static int alternatingCharacters(String s)
	{
		char a = 0;
		char b = 0;
		int i=0;
		while (i!=s.length())
		{
			if (a!=s.charAt(i))
			{
				a=s.charAt(i);
			}
			else if (b!=s.charAt(i))
			{
				b=s.charAt(i);
			}
			else
			{
				
			}
		}
		return 0;
    }

    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++)
        {
            String s = in.next();
            int result = alternatingCharacters(s);
            System.out.println(result);
        }
    }

}
