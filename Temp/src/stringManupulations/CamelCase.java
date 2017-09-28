package stringManupulations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*Alice wrote a sequence of words in CamelCase as a string of letters, , having the following properties:

It is a concatenation of one or more words consisting of English letters.
All letters in the first word are lowercase.
For each of the subsequent words, the first letter is uppercase and rest of the letters are lowercase.
Given , print the number of words in  on a new line.*/

public class CamelCase 
{
	public static void main(String[] args) 
	{
		String s="saveChangesInTheEditor";
		Pattern pat = Pattern.compile("[A-Z].*?");
		Matcher match = pat.matcher(s);

		int count=0;
		while(match.find())
		{
			count++;
		}
		count++;
		System.out.println(count);
	}
}
