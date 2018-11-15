package practice;

//package learning.datatype.array;
//
//import learning.datatype.linkedlist.TreeNode;
//import learning.datatype.linkedlist.TreePrinter;

public class HeapSort {

	public static void main(String[] args) throws Exception {

		int[] arr = { 4, 10, 3, 5, 1, 9, 7, 2, 6 };

		sort(arr);
	}

	private static void sort(int[] arr) {
		print(arr);
		for (int k = 1; k < arr.length; k++) 
		{
			System.out.println("k="+k);
			for (int i = 1; i * 2 <= arr.length - k; i++) 
			{
				System.out.println("i="+i);

				int j = 2 * i;
				if (arr[i - 1] < arr[j - 1])
					swap(arr, i - 1, j - 1);
				if (j <= arr.length - k && arr[i - 1] < arr[j])
					swap(arr, i - 1, j);

				print(arr);
			}
			System.out.println("swap first to last - " + (k - 1));
			swap(arr, 0, arr.length - k);
			print(arr);
		}
	}

	private static void print(int[] arr) {
//		for (int i = 0; i < arr.length; i++) {
//			System.out.print(arr[i] + " ");
//		}
//		System.out.println();
		TreePrinter.print(TNode.populateData(arr));
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
