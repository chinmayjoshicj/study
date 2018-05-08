package conpanySpecific;

public class AlphabetNumberDecoding {
	
/*	Let 1 represent ‘A’, 2 represents ‘B’, etc. Given a digit sequence, count the number of possible decodings of the given digit sequence.

	Examples:

	Input:  digits[] = "121"
	Output: 3
	// The possible decodings are "ABA", "AU", "LA"

	Input: digits[] = "1234"
	Output: 3
	// The possible decodings are "ABCD", "LCD", "AWD"
*/
	public static void main(String[] args) 
	{
		String s="121";
		
		System.out.println(countFunction(s));
	}

	private static int countFunction(String s) 
	{
		int count =0;
		
		if (s.length()==0) {
			return 0;
		}
		if (s.length()==1)
		{
			return 1;
		}
		
		if (s.charAt(s.length()-1)!='0') {
			count=countFunction(s.substring(0,s.length()-1));
		}
		
		if (s.charAt(s.length()-2)=='1' || (s.charAt(s.length()-2)=='2' && s.charAt(s.length()-1)<='6')) {
			count++;
		}
		return count;
	}

}
