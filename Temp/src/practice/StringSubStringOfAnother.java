package practice;

public class StringSubStringOfAnother {

	public static void main(String[] args) 
	{
		String s1="for";
		String s2="geeksforgeeks";
		
		int M=s1.length();
		int N=s2.length();
		
		for (int i = 0; i <= N-M; i++) 
		{
			int j=0;
			for (j = 0; j < M; j++) 
			{
				if (s1.charAt(j)!=s2.charAt(i+j))
				{
					break;
				}
			}
			if (j==M) {
				System.out.println("Yes");
				break;
			}
		}
	}

}
