package stringManupulations;

import java.util.HashMap;
import java.util.Scanner;
/*
 Amanda has a string, S , of m lowercase letters that she wants to copy into a new string,p .
  She can perform the following operations any number of times to construct string :

Append a character to the end of string p at a cost of 1 dollar.
Choose any substring of p and append it to the end of p at no charge.
 */
public class StringConstruction 
{
	static int stringConstruction(String s)
	{
		int count=0;
		StringBuffer orig=new StringBuffer(s);
		HashMap<Character, Integer> h=new HashMap<>();
		for (int i = 0; i < orig.length(); i++) 
		{
			h.put(s.charAt(i), count++);
		}
		return h.size();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            int result = stringConstruction(s);
            System.out.println(result);
        }
        in.close();
    }

}
