package stringManupulations;

import java.util.Scanner;
/*But, to lock the door he needs a key that is an anagram of a certain palindrome string.

The king has a string composed of lowercase English letters. Help him figure out whether any anagram of the string can be a palindrome or not.

Sample Input 0

aaabbbb
Sample Output 0

YES
Explanation 0

A palindrome permutation of the given string is bbaaabb. 

Sample Input 1

cdefghmnopqrstuvw
Sample Output 1

NO
Explanation 1

You can verify that the given string has no palindrome permutation. 

Sample Input 2

cdcdcdcdeeeef
Sample Output 2

YES

*/
public class GameofThrone1 {

	static String gameOfThrones(String s)
	{
		int arr[]=new int[256];
		int count = 0;
		for (int i = 0; i < s.length(); i++) 
		{
			arr[s.charAt(i)]++;
		}
		for (int i = 0; i < arr.length; i++) 
		{
			if (arr[i]%2!=0)
			{
				count++;
			}
		}
		if (count==1 && s.length()%2!=0)
		{
			return "YES";
		}
		else if(count==0 && s.length()%2==0)
			return "YES";
		else
			return "NO";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = gameOfThrones(s);
        System.out.println(result);
    }
}
