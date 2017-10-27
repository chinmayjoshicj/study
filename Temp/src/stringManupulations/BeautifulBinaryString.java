package stringManupulations;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/*Alice has a binary string, B , of length n. She thinks a binary string is beautiful if and only if it doesn't contain the substring "010".

In one step, Alice can change a 0 to a 1 (or vice-versa). Count and print the minimum number of steps needed to make Alice see the string as beautiful.	*/
/*
7
0101010
Output: 2
*/
public class BeautifulBinaryString 
{
	public static void main(String[] args) 
	{
		 	Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        String B = in.next();
	        int result = minSteps(n, B);
	        System.out.println(result);
	}

	private static int minSteps(int n, String b) 
	{
		String s="010";
		Pattern pat = Pattern.compile(s);
		Matcher match = pat.matcher(b);
		int count=0;
		
		while (match.find())
		{
			int start=match.start();
			int end=match.end();
//			System.out.println(start+1);
			if (end==n)
			{
				count++;
				break;
			}
			b=b.substring(end);
			n=b.length();
			count++;
			match = pat.matcher(b);
		}
		
		return count;
	}
}
