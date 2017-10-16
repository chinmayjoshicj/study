package hackerRank;

import java.util.Scanner;

/*Watson gives two integers (A and B) to Sherlock and asks if he can count the number of square integers between A and B (both inclusive).
Note: A square integer is an integer which is the square of any integer. 
For example, 1, 4, 9, and 16 are some of the square integers as they are squares of 1, 2, 3, and 4, respectively.*/
public class SherlockAndSquares 
{
	public static void main(String[] args) 
	{
		Scanner sc= new Scanner(System.in);
		int inputs=sc.nextInt();
		int[] arr = new int[2];
        for(int arr_i = 0; arr_i < inputs; arr_i++)
        {
        	for (int i = 0; i < 2; i++) 
            {
        		arr[i] = sc.nextInt();
    		}
        	System.out.println((int)(Math.floor(Math.sqrt(arr[1])) -
                    Math.ceil(Math.sqrt(arr[0])) + 1));
        }
	}

}
