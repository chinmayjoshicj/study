package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Sum_3_LeetCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int nums[]= {-1,0,1,2,-1,-4};
//		int nums[]= {-1,0,1,0};
//		int nums[]= {1,-1,-1,0};
		int nums[]= {-1,0,1,2,-1,-4,-2,-3,3,0,4};
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i]+" ");
		}
		System.out.println();
		HashSet<List<Integer>> set= new HashSet<List<Integer>>();
		//New Array [-4,-1,-1,0,1,2]
		
		for (int i = 0; i < nums.length-2; i++) {
				 int start=i+1;
				 int end=nums.length-1;
				 
//			if(num[i])
				 while(start<end) {
					 int sum=nums[i]+nums[start]+nums[end];
					 if(sum==0) {
						 set.add(Arrays.asList(nums[i],nums[start],nums[end]));
						 start++;
						 end--;
//						 System.out.println(list);	
					 }
					 else if(nums[i]+nums[start]+nums[end]<0) {
						 start++;
					 }
					 else {
						 end--;
					 }
				 }
//			 }
		}
		List<List<Integer>> list= new ArrayList<List<Integer>>();
		for (List<Integer> ele : set) {
            // Print HashSet data
			list.add(ele);
        }
		System.out.println(list);
	}

}
