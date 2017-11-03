package stringManupulations;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*Louise joined a social networking site to stay in touch with her friends. 
 * The signup page required her to input a name and a password. However, the password must be strong. 
 * The website considers a password to be strong if it satisfies the following criteria:

Its length is at least 6.
It contains at least one digit.
It contains at least one lowercase English character.
It contains at least one uppercase English character.
It contains at least one special character. The special characters are: !@#$%^&*()-+ */
public class StrongPassword {

	static int minimumNumber(int n, String password)
	{
		int count=0;
		Pattern pat1 = Pattern.compile("[a-z]+");
		Pattern pat2 = Pattern.compile("[A-Z]+");
		Pattern pat3 = Pattern.compile("[0-9]+");
		Pattern pat4 = Pattern.compile("[!@#$%^&*()-+]+");
		Pattern pat =  Pattern.compile("[[a-z]+[A-Z]+[0-9]+[!@#$%^&*()-+]+]{6}");
		Matcher match1 = pat1.matcher(password);
		Matcher match2 = pat2.matcher(password);
		Matcher match3 = pat3.matcher(password);
		Matcher match4 = pat4.matcher(password);
		Matcher match = pat.matcher(password);

		if (!match1.find())
		{
//			System.out.println("Small missing");
			count++;
		}
		
		if (!match2.find())
		{
//			System.out.println("CAPS missing");
			count++;
		}
			
		if (!match3.find())
		{
//			System.out.println("number missing");
			count++;
		}
		
		if (!match4.find())
		{
//			System.out.println("special missing");
			count++;
		}
		
		if (password.length()+count<6)
		{
			count=count+6-(password.length()+count);
		}
		return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String password = in.next();
        int answer = minimumNumber(n, password);
        System.out.println(answer);
        in.close();
    }
}
