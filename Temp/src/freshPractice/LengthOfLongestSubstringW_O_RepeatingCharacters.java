package freshPractice;

import java.util.HashSet;

public class LengthOfLongestSubstringW_O_RepeatingCharacters {

	//Accepted by LeetCode
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s= "abcabcbb";
		int count=0;
		
		for (int i = 0; i < s.length(); i++) {
			int start=i;
			HashSet<Character> set= new HashSet<Character>();
			
			while (start<s.length()) {
				if(!set.contains(s.charAt(start))) {
					set.add(s.charAt(start));
					count=Math.max(count, set.size());
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
