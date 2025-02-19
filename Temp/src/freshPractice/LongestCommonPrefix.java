package freshPractice;

import java.util.Arrays;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] sArr = {"flower","flow","flight", "fanilla"};
//		String[] sArr = {""};
		Arrays.sort(sArr);
		String s1=sArr[0];
		String s2=sArr[sArr.length-1];
		int minLength = Math.min(s1.length(), 
				s2.length());

		
		for (int i = 0; i < sArr.length; i++) {
			System.out.print(sArr[i]+ " ");
		}
		System.out.println();
		int index=0;
		while (index<minLength && index<=s1.length() && index<=s2.length()) {
			if(s1.charAt(index)==s2.charAt(index))
			{
				index++;
			}
			else {
				break;
			}
		}		
		System.out.println(s1.substring(0, index));
	}

}
