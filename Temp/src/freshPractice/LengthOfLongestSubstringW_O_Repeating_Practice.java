package freshPractice;

import java.util.HashSet;

public class LengthOfLongestSubstringW_O_Repeating_Practice {

	//Accepted by LeetCode
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s= "abcabcbb";
		s= "bbbbb";
		s= "pwwkew";
		int count=0;
		
		for (int i = 0; i < s.length(); i++) {
			int start=i;
			HashSet<Character> hs= new HashSet<Character>();
			while (start<s.length()) {
				if(!hs.contains(s.charAt(start))) {
					hs.add(s.charAt(start));
					count=Math.max(count, hs.size());
					start++;
				}
				else {
					break;
				}
			}
		}
		System.out.println(count);
	}

}
