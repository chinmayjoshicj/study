package stringManupulations;

import java.util.Scanner;

/*Given a string, S , of lowercase letters,
determine the index of the character whose removal will make S a palindrome. 
If S is already a palindrome or no such character exists, then print -1.
There will always be a valid solution, and any correct answer is acceptable. 
For example, if S="bcbc", we can either remove 'b' at index or 'c' at index .*/


/*Correct and incorrect as well for the mentioned Case both answers exist*/
public class PalindromeIndex {

	static int palindromeIndex(String s)
	{
        for (int i = 0; i < s.length()/2; i++) 
        {
        	if (s.charAt(i)!=s.charAt(s.length()-i-1))
			{
				if (s.charAt(i)!=s.charAt(s.length()-i-1))
				{
					if (s.charAt(i+1)==s.charAt(s.length()-i-1)) 
					{
						return i;
					}
					else
					{
						return s.length()-i-1;
					}
				}
			}
		}
		return -1;
    }

    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int q = in.nextInt();
        /*for(int a0 = 0; a0 < q; a0++){*/
            String s = "hgygsvlfcwnswtuhmyaljkqlqjjqlqkjlaymhutwsnwcwflvsgygh";
            int result = palindromeIndex(s);
            System.out.println(result);
        /*}*/
    }

}
