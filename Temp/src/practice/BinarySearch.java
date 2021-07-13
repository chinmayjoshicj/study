package practice;

public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {2,3,4,10,40};
		int  x= 10;
		System.out.println(binartSearch(arr,0,arr.length-1,x));
		binarySearchPractice(arr,0,arr.length-1,x);

	}

	private static int binartSearch(int[] arr, int start, int end, int x) {
		int mid=(start+end)/2;
		if(start<=end) {
			if(x>arr[mid])
			{
				return binartSearch(arr, mid+1, end, x);
			}
			if(x<arr[mid])
			{
				return binartSearch(arr, start, mid-1, x);
			}
			if(arr[mid]==x)
			{
				return mid;
			}
		}
			return -1;
	}

	private static void binarySearchPractice(int[] arr, int start, int end, int val) {
		int mid=((start+end)/2);
		if(start<0 || end >arr.length-1 || start>end)
		{
			return;
		}
		if(arr[mid]==val) {
			System.out.println("Found at index "+mid);
		}
		else if(val<arr[mid]) {
			binarySearchPractice(arr, start, mid-1, val);
		}
		else {
			binarySearchPractice(arr, mid+1, end, val);
		}
	}
}
