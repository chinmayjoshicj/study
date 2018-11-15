package practice;

public class LngstCommonAnagramSubseq {

	public static void main(String[] args) 
	{
		String s[]={"loop","lol","olive"};
		int arr[][]=new int [s.length][26];
		
		for (int i = 0; i < s.length; i++) 
		{
			for (int j = 0; j < s[i].length(); j++) {
				int a=s[i].charAt(j)-1;
				arr[i][a-96]+=1;
			}
		}
		/*
		for (int i = 0; i < s.length; i++) 
		{
			for (int j = 0; j < 26; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}*/
		for (int i = 0; i < 26; i++) 
		{
			int min=Integer.MAX_VALUE;
			int flag=0;
			for (int j = 0; j < s.length; j++)
			{
				if (arr[j][i]==0) 
				{
					flag=1;
					break;
				}
				if (arr[j][i]<min) {
					min=arr[j][i];
				}
				if (min<Integer.MAX_VALUE &&  flag==0 && j==s.length-1) {
					System.out.print((char)('a'+i)+"");
				}
			}
		}
	}
}
