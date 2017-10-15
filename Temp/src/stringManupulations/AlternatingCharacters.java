package stringManupulations;

import java.util.Scanner;

/*You are given a string containing characters A and B only,
 your task is to change it into a string such that every two consecutive characters are different. 
 To do this, you are allowed to delete one or more characters in the string.
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
public class AlternatingCharacters {
	static int alternatingCharacters(String s) {
		char a = 0;
		char b = 0;
		int i = 0;
		int count = 0;
		a = s.charAt(0);
		int k=0;
		StringBuffer st=new StringBuffer(s);
		while (i != s.length())// to get 2 characters
		{
			if (s.charAt(i) != a) {
				b = s.charAt(i);
				break;
			}
			i++;
		}
		if (b == 0) // All Letters Same
		{
			return s.length() - 1;
		}
		for (int j = 1; j < st.length(); j++) 
		{
			if (j % 2 == 0) 
			{
				if (st.charAt(j)==b)
				{
					st=st.deleteCharAt(j);
					count++;
					j=j-1;
				}
			} 
			else
			{
				if (st.charAt(j)==a)
				{
					st=st.deleteCharAt(j);
					count++;
					j=j-1;
				}
			}
		}
		if (count==s.length()-1)
		{
			return count-1;
		}
		return count;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int q = in.nextInt();
		for (int a0 = 0; a0 < q; a0++) {
			String s = in.next();
			int result = alternatingCharacters(s);
			System.out.println(result);
		}
	}

}
