package freshPractice;

import java.util.HashSet;

public class UniquePairOfSumInUnsortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {4,3,1,2,5};
		
		int sum=7;
		
		HashSet<Integer> hs= new HashSet<Integer>();
		
		for (int i = 0; i < arr.length; i++) {
			if(hs.contains(arr[i])) {
				System.out.println("Pairs are "+arr[i]+" "+(sum-arr[i]));
			}
			else {
				hs.add(sum-arr[i]);
			}
		}

	}

}
