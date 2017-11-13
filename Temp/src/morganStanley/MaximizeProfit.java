package morganStanley;

import java.util.Scanner;

public class MaximizeProfit {

static int maximizeProfit(int[] a, int[] b, int m, int k) 
{
	int max=0;
        for (int i = 0; i < b.length; i++) 
        {
			if (max<a[i]*b[i]) 
			{
				max=a[i]*b[i];
			}
		}
        return max*m;
}

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        int[] a = new int[n];
        for(int a_i = 0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        int[] b = new int[n];
        for(int b_i = 0; b_i < n; b_i++){
            b[b_i] = in.nextInt();
        }
        int result = maximizeProfit(a, b, m, k);
        System.out.println(result);
        in.close();
    }

}
