package leetCode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;


//Given an array of distinct integers candidates and a target integer target, 
//return a list of all unique combinations of candidates where the chosen numbers sum to target.
//You may return the combinations in any order.//
//The same number may be chosen from candidates an unlimited number of times.
//Two combinations are unique if the 
//frequency of at least one of the chosen numbers is different.
////The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
public class CombinationSum_39_Practice {// BackTracking

	static ArrayList<List<Integer>> result = new ArrayList<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int candidates[]= {2,3,5,7,8};
		int target=8;
		findCombination(candidates,0,target,new ArrayList<Integer>());
		HashSet<List<Integer>> set= new HashSet<>();
		for (List<Integer> list : result) {
			set.add(list);
		}
        List<List<Integer>> list = set.stream().collect(Collectors.toList());
        System.out.println(list);
    }

    
    private static void findCombination(int[] candidates, int index, int target, ArrayList<Integer> current) {
		// TODO Auto-generated method stub
		if(target==0) {
			Collections.sort(current);
			System.out.println("Adding "+current);
			result.add(new ArrayList<Integer>(current));
			return;
		}
		for (int i = index; i < candidates.length; i++) {
			if(target-candidates[i]>=0) {
				current.add(candidates[i]);
				findCombination(candidates, i, target-candidates[i], current);
				current.remove(current.size()-1);
			}
		}
	}

}
