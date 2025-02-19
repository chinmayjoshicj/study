package freshPractice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class CombinationSum_39 {// BackTracking

	static ArrayList<List<Integer>> result = new ArrayList<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int candidates[]= {2,3,5,7};
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
			result.add(new ArrayList<Integer>(current));
			return;
		}
		for (int i = index; i < candidates.length; i++) {
			if(candidates[i]<=target) {
				current.add(candidates[i]);
				findCombination(candidates, index, target-candidates[i], current);
				current.remove(new Integer(candidates[i]));
			}
		}
		
	}

}
