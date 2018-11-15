package practice;

public class LongestPalandromeSubstring {

	public static void main(String[] args) 
	{
		String s="forgeeksskeegfor";
		int start=0;
		int end=s.length();
		int maxLen=1;
		int low=0;
		int high=0;
		for (int i = 1; i < end; i++) 
		{
			low=i-1;
			high=i;
			//odd Length
			while (low>=0 && high<end && s.charAt(low)==s.charAt(high))
			{
				if (high-low+1>maxLen) {
					start=low;
					maxLen=high-low+1;
				}
				low--;
				high++;
			}
			low=i-1;
			high=i+1;
			//Even Length
			while (low>=0 && high<end && s.charAt(low)==s.charAt(high))
			{
				if (high-low+1>maxLen) {
					start=low;
					maxLen=high-low+1;
				}
				low--;
				high++;
			}
		}
		System.out.println(s.substring(start, start+maxLen));
	}

}
