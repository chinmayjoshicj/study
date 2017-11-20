package hackerEarth;

import java.util.Scanner;

public class NiceQueries {


	public static void main(String[] args) 
	{
		Scanner sc= new Scanner(System.in);
		int n=sc.nextInt();
		int q=sc.nextInt();
		int c=0;
		long arr[]=new long[n];
		long[] changed=new long[n];
		for (int i = 0; i < q; i++) 
		{
			boolean find=false;
			long a=sc.nextInt();
			long b=sc.nextInt();
			
			if (a==1)
			{
				arr[(int) b]=-1;
				changed[c++]=b;
			}
			else
			{
				long min=Integer.MAX_VALUE;
				for (int j = 0; j < c; j++)
				{
					if (changed[j]>=b)
					{
//						System.out.println(changed[j]);
						find=true;
						if (min>changed[j]) 
						{
							min=(int) changed[j];
						}
					}
				}
				if (min!=Integer.MAX_VALUE)
				{
					System.out.println(min);
				}
				else
					System.out.println(-1);
			}
		}
	}

}
