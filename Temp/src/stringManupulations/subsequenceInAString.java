package stringManupulations;

/*Given two strings str1 and str2, find if str1 is a subsequence of str2.
 * A subsequence is a sequence that can be derived from another sequence
 * by deleting some elements without changing the order of the remaining elements (source: wiki). Expected time complexity is linear.*/

public class subsequenceInAString 
{
	public static void main(String[] args)
	{
		String s="RATAT";
		String r="KARAATTAT";
		
		System.out.println(check(s,r,0,0)?"1":"0");
	}

	private static boolean check(String s, String r, int i, int j) 
	{
		if (i>=s.length())
		{
			return true;
		}
		if (j>=r.length())
		{
			return false;
		}
		if (s.charAt(i)==r.charAt(j))
		{
			return check(s, r, i+1, j+1);
		}
		else
			return check(s, r, i, j+1);
	}

}
