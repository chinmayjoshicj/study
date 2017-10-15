package dynamicProgramming;

public class LongestFirstAndLastSumEqualBruteForce 
{
	public static void main(String[] args) 
	{
		String str="142124";
		str="9430723";
		int maxLen=0;
		
		for (int i = 0; i < str.length(); i++) 
		{
			//+2 because we need length to even in number
			for (int j = i+1; j < str.length(); j+=2)
			{
				int len=j-i+1;
				if (maxLen>len)
				{
					continue;
				}
				int leftSum=0;
				int rightSum=0;
				for (int k = 0; k <len/2; k++) 
				{
					leftSum=leftSum+Integer.parseInt(str.charAt(i+k)+"");
					rightSum=rightSum+Integer.parseInt(str.charAt(i+k+len/2)+"");
				}
				if (leftSum==rightSum)
				{
					maxLen=len;	
				}
			}
		}
		System.out.println("Required Answer is: "+maxLen);
	}

}
