package practice;

public class TwoStringsInterleavingOfEachOther {

	public static void main(String[] args)
	{
		System.out.println(perform("AB","CD","ADCB"));
		System.out.println(perform("AB","CD","ABCD"));
		System.out.println(perform("AB","CD","ACBD"));
	}

	private static boolean perform(String a, String b, String c)
	{
		int aCount=0;
		int bCount=0;
		int count=0;
		
		while (count<c.length())
		{
			if (aCount<a.length() && c.charAt(count)==a.charAt(aCount))
			{
				aCount++;
			}
			else if (bCount<b.length() && c.charAt(count)==b.charAt(bCount))
			{
				bCount++;
			}
			else
				return false;
			count++;
		}
		return true;
	}

}
