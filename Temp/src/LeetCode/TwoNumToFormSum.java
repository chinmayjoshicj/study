package leetCode;

import java.util.LinkedHashMap;

public class TwoNumToFormSum {

	public static void main(String[] args) {
//		int []nums= {2,4,7,8,3,1};
		int []nums= {3,3};
		int target=6;
		
		TwoNumToFormSum t= new TwoNumToFormSum();
		int[] twoSum = t.twoSum(nums, target);
		System.out.println(twoSum[0]);
		System.out.println(twoSum[1]);
	}

	public int[] twoSum(int[] nums, int target) {
		int twoNum[]= new int[2];
		LinkedHashMap<Integer, Integer> map= new LinkedHashMap<Integer, Integer>();
		
		
		for (int i = 0; i < nums.length; i++) {
			if(map.containsKey(nums[i])) {
				System.out.println("If Loop");
				twoNum[0]=findLocation(nums,map.get(nums[i]));
				twoNum[1]=i;
				break;		
			}
			else {
				System.out.println("Adding "+(target-nums[i])+" "+nums[i]);
				map.put(target-nums[i],nums[i]);
			}
		}
		return twoNum;
	}
	int findLocation(int[] nums, int x) {
		for (int i = 0; i < nums.length; i++) {
			if(x==nums[i])
			{
				return i;
			}
		}
		return -1;
	}
}
