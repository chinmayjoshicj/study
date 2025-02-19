package leetCode;

public class JumpGame {
	
//	You are given an integer array nums. You are initially positioned at the array's first index,
//	and each element in the array represents your maximum jump length at that position.
//	Return true if you can reach the last index, or false otherwise.

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int nums[]= {2,3,1,1,4};
//		int nums[]= {3,2,1,0,4};
		int finalDest=nums.length-1;
		// Say we are at last position, and then start solving
		for (int i = nums.length-1; i >=0; i--) {
			if(i+nums[i]>=finalDest) {
				finalDest=i;
			}
		}
		System.out.println(finalDest==0);
	}
}
