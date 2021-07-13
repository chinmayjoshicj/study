package practice;

public class SortedRotatedArrayPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 7, 8, 1, 2, 3, 4, 5, 6 };
		int val=4;
		int pivot=findPivot(arr,val,0,arr.length-1);
		System.out.println(pivot);

	}

	private static int findPivot(int[] arr, int ele ,int start, int end) {
		// TODO Auto-generated method stub
		if (start < end) {
			int mid = (start + end) / 2;
			if (mid != 0 && arr[mid] < arr[mid - 1]) {
				return mid;
			} else if (arr[mid] > arr[mid + 1]) {
				return (mid + 1);
			} else {
				return findPivot(arr, ele, 0, mid - 1);
			}
		}
		return 0;
	}

}
