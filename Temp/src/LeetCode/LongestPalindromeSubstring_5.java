package leetCode;

public class LongestPalindromeSubstring_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="babbad";
		int start=0;
		int maxLen=1;
		
		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j <=1; j++) {
				int low=i;
				int hi=i+j;
				
				while (low>=0 && hi<s.length() && s.charAt(low)==s.charAt(hi))
				 {
					
					int currLen=hi-low+1;
					if(currLen>maxLen) {
						maxLen=currLen;
						start=low;
					}
					low--;
					hi++;
				}
			}
		}
//		return s.substring(start,start+maxLen);
		System.out.println(s.substring(start,start+maxLen));
		
					
	}

}
