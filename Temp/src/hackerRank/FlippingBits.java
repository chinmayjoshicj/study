package hackerRank;

import java.util.Scanner;

/*You will be given a list of 32 bits unsigned integers.
 * You are required to output the list of the unsigned integers you get by flipping bits in its binary representation 
 * (i.e. unset bits must be set, and set bits must be unset).
 * Sample Input

3 
2147483647 
1 
0
Sample Output

2147483648 
4294967294 
4294967295
Explanation

Take 1 for example, as unsigned 32-bits is 00000000000000000000000000000001 and 
doing the flipping we get 11111111111111111111111111111110 which in turn is 4294967294.

 * */
public class FlippingBits {

	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for (int i = n; i >0; i--)
		{
			String number1=in.next();
			logicWork(number1);
		}
	}

	private static void logicWork(String number1) 
	{
        String number = Long.toBinaryString(Long.parseLong(number1));
        /*System.out.println("Binary value: "+number);
        System.out.println("Original value: "+Integer.parseInt(number, 2));*/

        while (number.length()!=32)
        {
        	number="0"+number;
		}
        StringBuffer sp= new StringBuffer(number);
        for (int i = 0; i < sp.length(); i++)
        {
			if (sp.charAt(i)=='1')
			{
				sp=sp.replace(i, i+1, "0");
			}
			else
				sp=sp.replace(i, i+1, "1");
		}
        String binaryString =String.valueOf(sp);
        System.out.println(convertBack(binaryString));
	}

	private static Long convertBack(String binaryString) 
	{
		Long total=(long) 0;
		for (int i = 0; i < binaryString.length(); i++) 
		{
			total= ((total)+(Long.parseLong(binaryString.charAt(i)+"")*(long)Math.pow(2, binaryString.length()-i-1)));//-1 becoz 2^31 we will take
		}
		return total;
	}

}
