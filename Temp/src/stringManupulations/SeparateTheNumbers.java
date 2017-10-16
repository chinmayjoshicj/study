package stringManupulations;

import java.util.Scanner;

/*check if the separated numbers are sequential or not*/
/*7
1234
91011
99100
101103
010203
13
1 Sample Input*/

/*YES 1
YES 9
YES 99
NONO
NO
NO*/

public class SeparateTheNumbers 
{
	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		int q = in.nextInt();
		for (int i = 0; i < q; i++) 
		{
			
			long first=-1;
			boolean valid=false;
			String s=in.next();
			for (int j = 1; j <= s.length()/2; j++) 
			{
				long x=Long.parseLong(s.substring(0, j));
				first=x;
				String test=Long.toString(x);
				
				while (test.length()<s.length()) 
				{
					test+=Long.toString(++x);
				}
				if (test.equals(s))
				{
					valid=true;
					break;
				}
			}
			System.out.println(valid?"YES "+ first : "NO ");
			
		}
	}

}
