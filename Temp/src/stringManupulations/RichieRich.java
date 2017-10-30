package stringManupulations;

import java.util.Scanner;
/*Incomplete
 * 
 * Sample Input 0

4 1
3943
Sample Output 0

3993
Sample Input 1

6 3
092282
Sample Output 1

992299
Sample Input 2

4 1
0011
Sample Output 2

-1*/
public class RichieRich {

	static String richieRich(String s, int n, int k)
	{
		int count=0;
		StringBuffer sb=new StringBuffer(s);
		int i=0;
		if (s.length()==1)
		{
			return "9";
		}
		while (sb.charAt(i)=='0')
		{
			if (sb.charAt(sb.length()-i-1)!='9')
			{
				sb=sb.replace(sb.length()-i-1,sb.length()-i, "9");
				count++;
			}
			sb=sb.replace(i,i+1, "9");
			count++;
			i++;
		}
		/*if (count>=k)
		{
			for (i = 0; i < sb.length()/2; i++) 
			{
				if (sb.charAt(i)!=sb.charAt(sb.length()-i-1))
				{
					return "-1";
				}
			}
			return sb.toString();
		}*/
		for (i = 0; i < sb.length(); i++) 
		{
			if (sb.charAt(i)!=sb.charAt(s.length()-i-1) ||(sb.charAt(sb.length()-i-1)!='9'&& sb.charAt(i)!='9'))
			{
				if (sb.charAt(i)!=sb.charAt(sb.length()-i-1) && count+2<=k) 
				{
					if (sb.charAt(i)!='9') 
					{
						sb.replace(i, i+1, "9");
						count++;
					}
					if (sb.charAt(sb.length()-i-1)!='9')
					{
						sb.replace(sb.length()-i-1 , sb.length()-i, "9");
						count++;
						if (count>=k)
						{
							break;
						}
					}
					continue;
				}
				if (sb.charAt(i)!=sb.charAt(sb.length()-i-1) && count+2>k) 
				{
					return "-1";
				}
				if ((sb.charAt(sb.length()-i-1)!='9'&& sb.charAt(i)!='9')) 
				{
					if (sb.charAt(i)!='9') 
					{
						sb.replace(i, i+1, "9");
						count++;
					}
					if (sb.charAt(sb.length()-i-1)!='9')
					{
						sb.replace(sb.length()-i-1 , sb.length()-i, "9");
						count++;
					}
					if (count>=k)
					{
						break;
					}
				}
			}
		}
		return sb.toString();
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        String s = in.next();
        String result = richieRich(s, n, k);
        System.out.println(result);
    }

}
