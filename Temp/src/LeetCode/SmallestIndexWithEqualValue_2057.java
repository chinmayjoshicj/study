package leetCode;

import java.util.TreeSet;

public class SmallestIndexWithEqualValue_2057 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int nums[]= {0,1,2};
		int nums[]= {4,3,2,1};
		
		TreeSet<Integer> set= new TreeSet<Integer>();
		
		for (int i = 0; i < nums.length; i++) {
			if(i%10==nums[i]) {
				set.add(i);
			}
		}
		if (set.isEmpty()) {
			System.out.println("-1");
		}
		else {
			System.out.println(set.getFirst());
		}
	}

}
