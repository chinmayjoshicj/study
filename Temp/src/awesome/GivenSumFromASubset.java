package awesome;

import java.util.Arrays;

public class GivenSumFromASubset {
//	static int ispossible[];
	static int []ispossible = new int[8];
	public static void main(String[] args) {
		int[] arr = { 2, 3 }; 
	    int N = arr.length; 
	    int x = 7;
	    check(arr, x);
	    for (int i = 0; i < ispossible.length; i++) {
			System.out.print(ispossible[i]+" ");
		}
//	    if (ispossible[x]== 1) 
//	        System.out.println(x+" is possible."); 
//	    else
//	        System.out.println(x+" is not possible."); 

	}

	private static void check(int[] arr, int x) {
//		ispossible=new int[x+1];
//		System.out.println(ispossible.length);
//		ispossible[0]=1;
//		
//		System.out.println();
//		for (int i = 0; i < arr.length; i++) {// for arr array
//			int val=arr[i];
//			if (ispossible[val]==1) {
//				continue;
//			}
//			for (int j = 0; j+val<= x; j++) {// for possiblity array
//				if(ispossible[j]==1)
//				{
//					ispossible[j+val]=1;
//				}
//			}
//		}
		
		ispossible[0] = 1; 
	    Arrays.sort(arr); 
	  
	    for (int i = 0; i < arr.length; ++i) { 
	        int val = arr[i]; 
	  
	        // if it is already possible 
	        if (ispossible[val] == 1) 
	            continue; 
	  
	        // make 1 to all it's next elements 
	        for (int j = 0; j + val < ispossible.length; ++j) 
	            if (ispossible[j]== 1) 
	                ispossible[j + val] = 1; 
	    } 
		
	}

}
