package conpanySpecific;

import java.util.Scanner;

public class EggsDropingproblem {

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
			System.out.println(check(n,criticalFloor,k, criticalFloor,0));
				
		}
	}

	private static int check(int n, int cFloor, int k, int originalCriticalFloor,int count) 
	{
		int i=0;
		i++;
		if (k<cFloor)
		{
			return count;
		}
		System.out.println("CFloor "+((count+1)*originalCriticalFloor-count));
		int first=cFloor-(count*(originalCriticalFloor-1));
		count=1+Math.min((count+1)*originalCriticalFloor-count,check(n, cFloor+originalCriticalFloor-1,k, originalCriticalFloor,count+1));
		return count;
	}

	private static int findCriticalFloor(int n, int k) 
	{
		int root1=(int)Math.round(((-1)+Math.sqrt((1*1)-(4*(1)*(-2)*(k))))/2*(1));
		int root2=(int)Math.round(((-1)-Math.sqrt((1*1)-(4*(1)*(-2)*(k))))/2*(1));
		
		/*System.out.println("root1 "+root1);
		System.out.println("root2 "+root2);*/
		
		return (root1 > root2)? root1: root2;
	}

}
