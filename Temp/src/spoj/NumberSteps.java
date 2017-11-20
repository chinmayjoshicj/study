package spoj;

import java.util.Scanner;

public class NumberSteps 
{
	public static void main(String[] args) 
	{
		Scanner sc= new Scanner(System.in);
		int n=sc.nextInt();
		
		for (int i = 0; i < n; i++) 
		{
			int x=sc.nextInt();
			int y=sc.nextInt();
			
			if (y==x || y==x-2)
			{
				if (x%2==0)
				{
					System.out.println(x+y);
				}
				else
					System.out.println(x+y-1);
			}
			else
				System.out.println("No Number");
		}
	}

}
