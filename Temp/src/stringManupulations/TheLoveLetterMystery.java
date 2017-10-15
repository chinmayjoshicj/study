package stringManupulations;

import java.util.Scanner;
/*James found a love letter his friend Harry has written for his girlfriend. 
James is a prankster, so he decides to meddle with the letter. 
He changes all the words in the letter into palindromes.
To do this, he follows two rules:He can reduce the value of a letter,
e.g. he can change d to c, but he cannot change c to d.
In order to form a palindrome, if he has to repeatedly reduce the value of a letter, 
he can do it until the letter becomes a. Once a letter has been changed to a, 
it can no longer be changed.
Each reduction in the value of any letter is counted as a single operation.
Find the minimum number of operations required to convert a given string into a palindrome.*/
public class TheLoveLetterMystery {

	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++)
        {
            String s = in.next();
            int result = theLoveLetterMystery(s);
            System.out.println(result);
        }
	}

	private static int theLoveLetterMystery(String s) 
	{
		int count=0;
		for (int i = 0; i < s.length()/2; i++)
		{
			if (s.charAt(i)!=s.charAt(s.length()-i-1))
			{
				if (s.charAt(i)>s.charAt(s.length()-i-1))
				{
					count+=s.charAt(i)-s.charAt(s.length()-i-1);
				}
				if (s.charAt(i)<s.charAt(s.length()-i-1))
				{
					count+=s.charAt(s.length()-i-1)-s.charAt(i);
				}
			}
		}
		return count;
	}
}
