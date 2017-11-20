package spoj;

import java.util.Scanner;

public class TrailingZerosOfFactorial {

	static int findTrailingZeros(int n)
    {
        // Initialize result
        int count = 0;
        // Keep dividing n by powers of 5 and update count
        for (int i=5; n/i>=1; i *= 5)
            count += n/i;
 
        return count;
    }
    // Driver program
    public static void main (String[] args) 
    {
    	Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) 
        {
        	System.out.println(findTrailingZeros(sc.nextInt()));
		}
    }
}
