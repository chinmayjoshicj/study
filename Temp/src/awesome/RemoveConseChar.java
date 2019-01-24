package awesome;

public class RemoveConseChar {

	public static void main(String[] args)
	{
		StringBuffer b=new StringBuffer("abcdefghijklmnopqrstuvwxyz");
//		StringBuffer b=new StringBuffer("abcdlxyzmno");
//		StringBuffer b=new StringBuffer("acegik");
		for (int i = 0; i < b.length(); i++) 
		{
			int start = i;
			for (int j = i+1; j < b.length(); j++)
			{
				if (b.charAt(j-1)+1!= b.charAt(j))
				{
					if(j-1>start) {
						b.delete(start, j);
						i=-1;
						break;
					}
					start = j;
				} 
				
				if(j == b.length()-1) {
					if(j-1>start) {
						b.delete(start, b.length());
					}
				}
			}
		}
		System.out.println(b);
	}


	/*private static void checkSeq(int curr, int next, char[] charArray)
	{
		if (curr+next<charArray.length) {
			if (curr+1==next) {
				if (charArray[next+1]==next+1) {
					checkSeq(curr, next+1, charArray);
				}
			}
		}
		charArray[next]='*';
	}
*/
}
