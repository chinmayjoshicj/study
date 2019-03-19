package practice;

public class SortedRotatedArray {
	static int ele = 10;

	public static void main(String[] args) {
		int arr[] = { 7, 8, 1, 2, 3, 4, 5, 6 };
		int findPivot = findPivot(arr, 5, 0, arr.length - 1);
		System.out.println("Pivot is " + findPivot);
		if (findPivot == 0) {
			binarySearch(arr, 0, arr.length - 1);
		} else {
			binarySearch(arr, 0, findPivot);
			binarySearch(arr, findPivot + 1, arr.length - 1);
		}
	}

	private static void binarySearch(int[] arr, int start, int end) {
		if (start <= end) {
			int mid = (start + end + 1) / 2;
			if (arr[mid] == ele) {
				System.out.println("found at Index " + mid);
			} else if (ele < arr[mid]) {
				binarySearch(arr, start, mid - 1);
			} else
				binarySearch(arr, mid + 1, end);
		}
	}

	private static int findPivot(int[] arr, int ele, int start, int end) {
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
