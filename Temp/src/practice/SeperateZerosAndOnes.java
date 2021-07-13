package practice;

public class SeperateZerosAndOnes {

	static int arr[]= {0,1,0,1,1,1,0,0,1};
	public static void main(String[] args) {
		int start=0;
		int end=arr.length-1;
		
		while(start<end) {
			if(arr[start]==0) {
				start++;
				continue;
			}
			if(arr[end]==1) {
				end--;
				continue;
			}
			swap(start,end);
			start++;
			end--;
		}
		for (int num : arr) {
			System.out.print(num+" ");
		}
	}

	private static void swap(int start, int end) {
		int temp=arr[start];
		arr[start]=arr[end];
		arr[end]=temp;		
	}

}
