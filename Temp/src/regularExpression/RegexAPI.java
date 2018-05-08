package regularExpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*1	boolean matches()	test whether the regular expression matches the pattern.
 
2	boolean find()	finds the next expression that matches the pattern.

3	boolean find(int start)	finds the next expression that matches the pattern from the given start number.

4	String group()	returns the matched subsequence.

5	int start()	returns the starting index of the matched subsequence.

6	int end()	returns the ending index of the matched subsequence.

7	int groupCount()	returns the total number of the matched subsequence.


1	static Pattern compile(String regex)	compiles the given regex and return the instance of pattern.

2	Matcher matcher(CharSequence input)	creates a matcher that matches the given input with pattern.

3	static boolean matches(String regex, CharSequence input)	It works as the combination of compile and matcher methods. It compiles the regular expression and matches the given input with the pattern.

4	String[] split(CharSequence input)	splits the given input string around matches of given pattern.

5	String pattern()	returns the regex pattern.

*/



public class RegexAPI {

	public static void main(String[] args)
	{
		Pattern p = Pattern.compile(".s");//. represents single character  
		Matcher m = p.matcher("as");  
		boolean b = m.matches();  
		  
		Pattern p1 = Pattern.compile(".s");//. represents single character  
		Matcher m1 = p1.matcher("aqs");  
		boolean b1 = m1.matches();  
		
		//2nd way  
		boolean b2=Pattern.compile(".s").matcher("as").matches();  
		  
		//3rd way  
		boolean b3 = Pattern.matches(".s", "as");  
		  
		System.out.println(b+" "+b1+" "+b2+" "+b3);  
	}

}
