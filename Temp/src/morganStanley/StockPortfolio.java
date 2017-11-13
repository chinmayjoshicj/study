package morganStanley;

import java.util.Scanner;


public class StockPortfolio {

	static Long maxSum[]=null;
    static long maxTotalStrength(int[] strength, int[] l, int[] r)
    {
        maxSum=new Long[strength.length];
        Long max=(long) -1;
        for (int i = 0; i < r.length; i++) 
		{
			maxSum[i]=(long) strength[i];
			for (int  j=(int) (i+r[i]+1); j < r.length; j++)
			{
				if (j-l[j]-1>=i)
				{
					maxSum[i]+=strength[j];
				}
			}
			if (max<maxSum[i])
			{
				max=maxSum[i];
			}
		}
		return max;
	}

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] strength = new int[n];
        for(int strength_i = 0; strength_i < n; strength_i++){
            strength[strength_i] = in.nextInt();
        }
        int[] l = new int[n];
        for(int l_i = 0; l_i < n; l_i++){
            l[l_i] = in.nextInt();
        }
        int[] r = new int[n];
        for(int r_i = 0; r_i < n; r_i++){
            r[r_i] = in.nextInt();
        }
        long result = maxTotalStrength(strength, l, r);
        System.out.println(result);
        in.close();
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*static Long maxSum[]=null;
	public static void main(String[] args)
	{
		Scanner s= new Scanner(System.in);
		int n=s.nextInt();
		Long strength[]=new Long[n];
		Long l[]=new Long[n];
		Long r[]=new Long[n];
		maxSum=new Long[n];
		
		for (int i = 0; i < strength.length; i++) 
		{
			strength[i]=s.nextLong();
		}
		for (int i = 0; i < l.length; i++) 
		{
			l[i]=s.nextLong();
		}
		for (int i = 0; i < r.length; i++) 
		{
			r[i]=s.nextLong();
		}
		for (int i = 0; i < r.length; i++) 
		{
			maxSum[i]=strength[i];
			for (int  j=(int) (i+r[i]+1); j < r.length; j++)
			{
				if (j-l[j]-1>=i)
				{
					maxSum[i]+=strength[j];
				}
			}
		}
		System.out.println(findMax());
	}
	private static Long findMax() 
	{
		Long max=maxSum[0];
		for (int i = 0; i < maxSum.length; i++) 
		{
			if (max<maxSum[i])
			{
				max=maxSum[i];
			}
		}
		return max;
	}
*/
    }
}
