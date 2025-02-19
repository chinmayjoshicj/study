package leetCode;

import java.text.CollationElementIterator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

//Given two integers n and k, return all possible combinations of k numbers 
//chosen from the range [1, n].
//
//You may return the answer in any order.
//
//Example 1:
//
//Input: n = 4, k = 2
//Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
//Explanation: There are 4 choose 2 = 6 total combinations.
//Note that combinations are unordered, i.e., 
//[1,2] and [2,1] are considered to be the same combination.

public class Combinations_77_Practice {

	static List<List<Integer>> resultList = new ArrayList<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int input=4;
		int k=2;
//		input=5;
//		k=4;
		printCombinations(1,k,input,new ArrayList<Integer>());
		System.out.println(resultList);
		
		
	}
	private static void printCombinations(int index, int k, int input, ArrayList<Integer> cuArrayList) {
		if(cuArrayList.size()==k) {
			Collections.sort(cuArrayList);
			System.out.println("Addind it to result List ");
			resultList.add(new ArrayList<Integer>(cuArrayList));
			return;
		}
		for (int i = index; i <=input; i++) {
			if(!cuArrayList.contains(i)) {
				cuArrayList.add(index);
			}
			printCombinations(index+1, k, input, cuArrayList);			
			cuArrayList.remove(cuArrayList.size()-1);
		}
	}

}
