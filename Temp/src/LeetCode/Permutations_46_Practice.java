package leetCode;

import java.util.ArrayList;

public class Permutations_46_Practice {

	static ArrayList<ArrayList<Integer>> resultList= new ArrayList<ArrayList<Integer>>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[]= {1,2,3,4};
		printPermution(nums,new ArrayList<Integer>());
		System.out.println(resultList);
		System.out.println(resultList.size());
	}

	private static void printPermution(int[] nums, ArrayList<Integer> cuArrList) {
		// TODO Auto-generated method stub
		if(nums.length==cuArrList.size()) {
			resultList.add(new ArrayList<Integer>(cuArrList));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if(!cuArrList.contains(nums[i])) {
				cuArrList.add(nums[i]);
				printPermution(nums, cuArrList);
				cuArrList.remove(cuArrList.size()-1);
			}
		}
	}

}
