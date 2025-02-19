package freshPractice;

import java.util.Arrays;
import java.util.TreeSet;

public class ClosestSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int nums[]= {-1,2,1,-4};
		int target=1;
//		int nums[]= {0,1,2};
//		target=0;
//		int nums[]= {4,0,5,-5,3,3,0,-4,-5};
//		target=-2;
//		int nums[]= {0,0,0};
		target=1;
		int nums[]= {2,3,8,9,10};
		target=16;
		
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i]+" ");
		}
		TreeSet<Integer> treeSet=new TreeSet<>();
		for (int i = 0; i < nums.length-2; i++) {
				 int start=i+1;
				 int end=nums.length-1;
				 
				 while(start<end) {
					 int sum=nums[i]+nums[start]+nums[end];
					 if(sum==target) {
						 treeSet.add(target);
						 start++;
						 end--;
					 }
					 else if(sum<target) {
						 treeSet.add(nums[i]+nums[start]+nums[end]);
						 start++;
					 }
					 else {
						 treeSet.add(nums[i]+nums[start]+nums[end]);
						 end--;
					 }
				 }
//			 }
		}
		Integer floor = treeSet.floor(target);
		Integer ceil = treeSet.ceiling(target);
		
		if(floor==null) {
			floor=target;
			System.out.println(ceil);
			return;
		}
		if(ceil==null) {
			ceil=target;
			System.out.println(floor);
			return;
		}
		Integer min = Math.min(Math.abs(target-floor), Math.abs(target-ceil));
		if(Math.abs(target-floor)==min) {
			System.out.println(floor);
//			return floor;
		}
		else {
			System.out.println(ceil);
//			return ceil;
		}
//		
	}

}
