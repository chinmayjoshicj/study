package awesome;

import java.util.Scanner;

/*Find repeated character present first in a string
Given a string, find the repeated character present first in the string.

(Not the first repeated character, found here.)*/

public class RepeatedCharacterPresentFirst {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//String a = sc.nextLine();
		 String a="chinmayjoshi";

		/*for (int i = 0; i < a.length(); i++) {
			for (int j = 0; j < a.length(); j++) {
				if (i == j) {
					continue;
				}
				if (a.charAt(i) == a.charAt(j)) {
					System.out.println(a.charAt(j));
					i = 1000;
					break;
				}
			}
			if (i == 1000) {
				break;
			}
		} Order(n^2) Solution*/
		int MAX_CHAR=256;
		int hash[]=new int[MAX_CHAR];
		int pos[]=new int[MAX_CHAR];
		int pos1=-1;
		int i = 0;
		for (i = 0; i < a.length(); i++) 
		{
			System.out.println(i);
			pos1=(int)a.charAt(i);
			if (hash[pos1]==0)
			{
				hash[pos1]++;
				System.out.println(i);
				pos[i]=pos1;
			}
			else if (hash[pos1]==1)
			{
				hash[pos1]++;
			}
			System.out.println(i);
		}
		for (i = 0; i < MAX_CHAR; i++) 
		{
			if (hash[i]==2)
			{
				System.out.println(a.charAt(pos[i]));
				break;
			}
		}
	}

}
