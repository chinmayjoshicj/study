package dynamicProgramming;

public class LongestFirstAndLastSumEqualDynamicProgramming
{

	public static void main(String[] args) 
	{
		String str="31421245";
		/*str="9431623";*/
		int maxLen=0;
		
		int n=str.length();
		int sum[][]=new int[n][n];
		int j=0;
		int i=0;
		int len=0;
		for (i=0; i< n; i++) 
		{
			sum[i][i]=Integer.parseInt(str.charAt(i)+"");
		}
		for (i = 0; i < str.length(); i++) 
		{
			for (j = i+1; j < str.length(); j++) 
			{
				len=j-i+1;
				sum[i][j]=Integer.parseInt(str.charAt(j)+"")+sum[i][j-1];
				if (len>maxLen && len%2==0 && Integer.parseInt(str.charAt(j)+"")==sum[i][j-1]) 
				{
					//maxLen=len;
				}
			}
		}
		for (i = 0; i < str.length(); i++) 
		{
			for (j = i+1; j < str.length(); j++) 
			{
				len=j-i+1;
				
				if (len>maxLen && len%2==0 && Integer.parseInt(str.charAt(j)+"")==sum[i][j-1]) 
				{
					//maxLen=len;
				}
			}
		}
		System.out.println(maxLen);
		printArr(sum);
		maxLen=0;
		System.out.println();
		for (len = 2; len <=str.length(); len++) 
		{
			for (i = 0; i < n-len+1; i++)
			{
				j=i+len-1;
				int k=len/2;
				
				System.out.println(i+","+j+"==>["+i+","+(j-k)+"]+["+(j-k+1)+","+j+"]");
				sum[i][j]=sum[i][j-k]+sum[j-k+1][j];
				if (len%2==0 && sum[i][j-k]==sum[j-k+1][j] && len>maxLen)
				{
					maxLen=len;
				}
			}
		}
		System.out.println(maxLen);
		printArr(sum);
	}

	private static void printArr(int[][] sum) 
	{
		for (int i = 0; i < sum.length; i++) 
		{
			for (int j = 0; j < sum.length; j++) 
			{
				if (sum[i][j]>=10)
				{
					System.out.print(sum[i][j]+"  ");
				}
				else
					System.out.print(sum[i][j]+"   ");
			}
			System.out.println();
		}
	}

}
