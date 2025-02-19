package leetCode;

import java.util.Arrays;
//any 3 numbers in array whose sum is equal to 0
public class Sum_3_LeetCode_Practice {

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
		for (int i = 0; i < nums.length; i++) {
			
			int currSum=nums[i];
			int start=i+1;
			int end=nums.length-1;		
			while (start<end) {
				currSum=nums[i]+nums[start]+nums[end];
				if(currSum==0) {
					System.out.println("Ans: "+nums[i]+" "+nums[start]+" "+nums[end]);
					start++;
					end--;
				}
				else if(currSum<0){
					start++;
				}
				else {
					end--;
				}
			}
		}
		
		
//		System.out.println(list);
	}

}
