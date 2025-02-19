package leetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;


//Given an array nums of distinct integers, return all the possible 
//permutations
//. You can return the answer in any order.
public class Permutations_46 {

	static ArrayList<ArrayList<Integer>> resultList= new ArrayList<ArrayList<Integer>>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int nums[]= {1,2,3,4};
		
//		for (int i = 0; i < nums.length; i++) {
			printPermution(nums,new ArrayList<Integer>());
//		}
		HashSet<List<Integer>> set= new HashSet<>();
		for (List<Integer> list : resultList) {
			set.add(list);
		}
		List<List<Integer>> list = set.stream().collect(Collectors.toList());
		System.out.println(list);
		System.out.println(list.size());
	}

	private static void printPermution(int[] nums, ArrayList<Integer> cuArrList) {
		// TODO Auto-generated method stub
		
		if(cuArrList.size()==nums.length) {
			resultList.add(new ArrayList<>(cuArrList));
			return;
		}
		for (int j = 0; j < nums.length; j++) {
			if(cuArrList.contains(nums[j])) {
				continue;
			}
			cuArrList.add(nums[j]);
			printPermution(nums, cuArrList);
			if(!cuArrList.isEmpty()) {
				cuArrList.remove(cuArrList.size()-1);
			}
		}
		
	}

}
