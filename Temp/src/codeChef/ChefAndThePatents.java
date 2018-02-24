package codeChef;

import java.util.Scanner;

public class ChefAndThePatents 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		int x=sc.nextInt();
		int k=sc.nextInt();
		String s=sc.nextLine();
		int even=0;
		int odd=0;
		for (int i = 0; i < s.length(); i++) {
			if ((s.charAt(i)=='E')) 
			{
				even++;
			}
			else odd++;
		}
		if (n/x>m)
		{
			System.out.println("no");
		}
	}
}