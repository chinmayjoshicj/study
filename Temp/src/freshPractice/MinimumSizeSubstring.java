package freshPractice;

import java.util.HashMap;

public class MinimumSizeSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s="ADOBECODEBANC";
		String t="ABC";
		s="AB";
		t="A";
		s="cabwefgewcwaefgcf";
		t="cae";
		
		int count=0;
		int start=0;
		int end=0;
		int minLength=Integer.MAX_VALUE;
		int startIndex=0;
		
		HashMap<Character, Integer> map= new HashMap<Character, Integer>();
		for (int i = 0; i < t.length(); i++) {
			if(map.containsKey(t.charAt(i))) {
				map.put(t.charAt(i), map.get(t.charAt(i))+1);
			}
			else {
				map.put(t.charAt(i), 1);
			}
		}
		
		while (end<s.length()) {
			System.out.println("Start "+start+" Count "+count+" End "+end);
			if(map.containsKey(s.charAt(end))){
				if(map.get(s.charAt(end))>0) {
					count++;
				}
				map.put(s.charAt(end), map.get(s.charAt(end))-1);
			}
			else {
				map.put(s.charAt(end), -1);
			}
			while (count==t.length()) {
				int currMin=end-start+1;
				
				if(minLength>currMin) {
					minLength=currMin;
					startIndex=start;
				}
				if(map.containsKey(s.charAt(start))){
//					System.out.println("Start "+start+" Count "+count+" End "+end);
//					System.out.println(map+" s.charAt(start) "+s.charAt(start));
					map.put(s.charAt(start), map.get(s.charAt(start))+1);
					if(map.get(s.charAt(start))>0) {
						count--;
					}
				}
				start++;
			}
			end++;
		}
		System.out.println(minLength==Integer.MAX_VALUE?"":s.substring(startIndex,startIndex+minLength));
	}

}
