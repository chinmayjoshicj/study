package awesome;

public class LeastCommonSubsequence {

	public static void main(String[] args)
	{
		String a="Traveller";
		String b="rellevarT";
		/*String a="abcdaf";
		String b="acbcf";*/
		
		int mat[][]=new int[a.length()][b.length()];
		
		char s1[]=a.toCharArray();
		char s2[]=b.toCharArray();
		
		for (int i = 0; i < s1.length; i++) 
		{
			for (int j = 0; j < s2.length; j++) 
			{
				if (s1[i]==s2[j])
				{
					if (i==0 && j==0) 
					{
						mat[i][j]=1;
					}
					else if (i==0 || j==0)
					{
						if (i==0)
						{
							mat[i][j]=mat[i][j-1]+1;
						}
						else
						{
							mat[i][j]=mat[i-1][j]+1;
						}
					}
					else
					{
						mat[i][j]=mat[i-1][j-1]+1;
					}
				}
				else
				{
					if (i==0 && j==0) 
					{
						mat[i][j]=0;
					}
					else if (i==0 || j==0) 
					{
						if (i==0)
						{
							mat[i][j]=mat[i][j-1];
						}
						else
						{
							mat[i][j]=mat[i-1][j];
						}
					}
					else
						mat[i][j]=Integer.max(mat[i-1][j],mat[i][j-1]);
				}
			}
		}
		
		for (int i = 0; i < s1.length; i++) 
		{
			for (int j = 0; j < s2.length; j++) 
			{

				System.out.print(mat[i][j]+" ");
			}
			System.out.println();
		}
		
	}

}
