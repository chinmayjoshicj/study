package ConpanySpecific;

import java.awt.Checkbox;
import java.util.Scanner;

public class EggsDropingproblem {

	static int criticalfloor=Integer.MAX_VALUE;
	static int count=1;
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		//System.out.println("Enter no of Eggs");
		int inputs= Integer.parseInt(sc.nextLine());
		
		for (int i = 0; i < inputs; i++)
		{
			String temp=sc.nextLine();
			String a[]=new String[2];
			a=temp.split("\\s");
			int n = Integer.parseInt(a[0]);
			
			int k = Integer.parseInt(a[1]);
			
			int criticalFloor=findCriticalFloor(n,k);
			System.out.println(Math.min(criticalFloor,check(n,k)));
				
		}
	}

	private static int check(int n, int k) 
	{
			
		//if it doesn't break
		if (n<1 || k<1) 
		{
			return 0;
		}
		return 1+Math.min(findCriticalFloor(n,k),check(n-1, k-1));
	}

	private static int findCriticalFloor(int n, int k) 
	{
		int root1=(int)Math.round(((-1)+Math.sqrt((1*1)-(4*(1)*(-2)*(k))))/2*(1));
		int root2=(int)Math.round(((-1)-Math.sqrt((1*1)-(4*(1)*(-2)*(k))))/2*(1));
		
		System.out.println("root1 "+root1);
		System.out.println("root2 "+root2);
		
		return (root1 > root2)? root1: root2;
	}

}
