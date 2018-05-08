package conpanySpecific;

public class SmallestWindowInAString {
	
	static int start;
	static int end;

	public static void main(String[] args) 
	{
		String s="this is a test string";
		String pattern = "tist";
		
		start=0;
		end=Integer.MAX_VALUE;
		for (int i = 0; i < s.length(); i++)
		{
			for (int j = 0; j < args.length; j++) {
				findString(s.substring(i,s.length()),pattern);
			}
		}
		System.out.println();
		System.out.println(s.substring(start, end+1));
	}
	private static void findString(String substring, String pattern) 
	{
		int j=0;
		int startInternal=0;
		int endInternal=Integer.MAX_VALUE;
		
		boolean startFound=false;
			for (int i = 0; i < substring.length(); i++) 
			{
				if (substring.charAt(i)==pattern.charAt(j)) 
				{
					if (!startFound) 
					{
						startInternal=i;
						startFound=true;
					}
					else if(j==pattern.length()-1)
					{
						endInternal=i;
					}
					j++;
				}
				if (j==pattern.length()) {
					break;
				}
			}
			if (endInternal-startInternal<end-start) {
				start=startInternal;
				end=endInternal;
				System.out.println(substring.substring(start, end+1));
			}
	}
}
