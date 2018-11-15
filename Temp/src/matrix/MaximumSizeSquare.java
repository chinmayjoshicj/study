package matrix;

public class MaximumSizeSquare {

	public static void main(String[] args) 
	{
		int M[][] = {{0, 1, 1, 0, 1},  
                {1, 1, 0, 1, 0},  
                {0, 1, 1, 1, 0}, 
                {1, 1, 1, 1, 0}, 
                {1, 1, 1, 1, 1}, 
                {0, 0, 0, 0, 0}}; 
          
    printMaxSubSquare(M); 
	}

	private static void printMaxSubSquare(int[][] m) 
	{
		int max_i,max_j,max_s;
		int s[][]=new int[m.length][m[0].length];
		
		for (int i = 0; i < s.length; i++) 
		{
			for (int j = 0; j < s[0].length; j++) {
				System.out.print(s[i][j]);
			}
			System.out.println();
			
		}
		for (int i = 0; i < s.length; i++) 
		{
			s[i][0]=m[i][0];
		}
		for (int i = 0; i < s[0].length; i++) 
		{
			s[0][i]=m[0][i];
		}
		for (int i = 1; i < s.length; i++) 
		{
			for (int j = 1; j < s[0].length; j++) 
			{
				if (m[i][j]==1) {
					s[i][j]=Math.min(s[i][j-1], Math.min(s[i-1][j-1], s[i-1][j]))+1;
				}else
					s[i][j]=0;
			}
		}
		max_s=s[0][0];
		max_i=0;
		max_j=0;
		for (int i = 0; i < s.length; i++) 
		{
			for (int j = 0; j < s[0].length; j++) 
			{
				if (max_s<s[i][j]) {
					max_s=s[i][j];
					max_i=i;
					max_j=j;
				}
			}
		}
		
		for (int i = max_i; i > max_i-max_s; i--) 
		{
			for (int j = max_j; j > max_j-max_s; j--) 
			{
				System.out.print(m[i][j]+" ");
			}
			System.out.println();
		}
	}
}
