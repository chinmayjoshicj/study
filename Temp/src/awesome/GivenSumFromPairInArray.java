package awesome;

import java.util.Arrays;
import java.util.HashSet;

public class GivenSumFromPairInArray {
	public static void methodN()
	{
		int arr[]= {1,4,45,6,10,-8};
		int num=14;
		HashSet<Integer> hs= new HashSet<Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (hs.contains(arr[i])) {
				System.out.println("True N "+arr[i]);
				return;
			}
			else {
				hs.add(num-arr[i]);
//				System.out.println("Adding "+(num-arr[i]));
			}
		}
	}
	public static void methodNLogN()
	{
		int arr[]= {1,4,45,6,10,-8};
		int num=14;
		int l=0;
		int r=arr.length-1;
		Arrays.sort(arr);
		for (int i = 0; l<r && i<arr.length; i++) {
//			System.out.println("+ "+i+" l"+" r "+r );
			if (arr[l]+arr[r]==num) {
				System.out.println("True LogN");
				break;
			}
			else
			{
				if (arr[l]+arr[r]<num) {
					l++;
				}else {
					r--;
				}
			}
		}
	}

	public static void main(String[] args) {
		methodN();
		methodNLogN();
	}
}
