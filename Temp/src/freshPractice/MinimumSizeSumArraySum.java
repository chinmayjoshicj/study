package freshPractice;

public class MinimumSizeSumArraySum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		int nums[]= {2,3,1,2,4,3};
//		int target=7;
//		int nums[]= {1,2,3,4,5};
//		int target=15;
//		int nums[]= {1,1,1,1,1,1,1,1};
//		int target=11;
//		int nums[]= {1,2,3,4,5};
//		int nums[]= {1,4,4};
		int nums[]= {5,1,3,5,10,7,4,9,2,8};
		int target=15;
		int sumArr[]=new int[nums.length];
		
		/* Brute Force
		 * int minCount=Integer.MAX_VALUE; for (int i = 0; i < nums.length; i++) { int
		 * sum=nums[i]; if(sum>=target) { minCount=1; break; } for (int j = i+1; j <
		 * nums.length; j++) { sum+=nums[j]; if(sum>=target) { if(j-i+1<minCount) {
		 * minCount=j-i+1; } break; } } } System.out.println(minCount);
		 */
		
		int currSum=0;
		int minWindowSize=Integer.MAX_VALUE;
		int start=0;
		int end=0;
		
		while (start<=end && end<nums.length) {
			currSum+=nums[end];
			end++;
			while(currSum>=target) {
				int currSizeWin=end-start;
				currSum=currSum-nums[start];
				start++;
				minWindowSize= Math.min(currSizeWin, minWindowSize);
			}
		}
		System.out.println(minWindowSize==Integer.MAX_VALUE?0:minWindowSize);

	}

}
