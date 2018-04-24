package conpanySpecific;

public class NoOfPathsInMatrix {

	public static void main(String[] args)
	{
		int n=5;
		int m=5;
		int a[][]=new int[m][n];
		
		
		/*if (m == 1 || n == 1)
			System.out.println("1");	 
	   // If diagonal movements are allowed then the last addition
	   // is required.
	   System.out.println();
	   System.out.println(numberOfPaths(m, n));*/
	           // + numberOfPaths(m-1,n-1);
		for (int i = 0; i < a.length; i++) 
		{
			for (int j = 0; j < a.length; j++)
			{
				if (i==0)
				{
					a[i][j]=i+1;
				}
				else if (j==0) {
					a[i][j]=j+1;
				}
				else
					a[i][j]=a[i-1][j]+a[i][j-1]+a[i-1][j-1];
				
			}
		}
		for (int i = 0; i < a.length; i++)
		{
			for (int j = 0; j < a.length; j++) {
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
	}

	private static int numberOfPaths(int i, int j) 
	{
		if (i == 1 || j == 1)
	        return 1;
	 
		return numberOfPaths(i-1, j) + numberOfPaths(i, j-1);
	}

}
