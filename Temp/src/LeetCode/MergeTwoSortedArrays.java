package leetCode;

public class MergeTwoSortedArrays {

	static int num3[] = null;;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int num1[] = { 1, 2, 3, 0, 0, 0 };
//		int num1[] = { 1};
		int num1[] = { 2, 0 };
//		int num2[] = { 2, 5, 6 };
//		int num2[] = { };
		int num2[] = { 1 };

		MergeTwoSortedArrays ms = new MergeTwoSortedArrays();
		ms.merge(num1, num1.length, num2, num2.length);
		for (int i = 0; i < num1.length; i++) {
			System.out.println(num1[i]);
		}
	}

	public void merge(int[] num1, int m, int[] num2, int n) {
//		if(num2.length==0) {
//			return;
//		}
		num3 = new int[num1.length];
		int num1Pointer = 0;
		int num2Pointer = 0;
		int num3Pointer = 0;
		while (num1Pointer + num2Pointer < num1.length) {
//			System.out.println("comparing "+num1[num1Pointer] +" < "+num2[num2Pointer]);
			if (num2Pointer >= num2.length || num1[num1Pointer] <= num2[num2Pointer]) {
				if (num1Pointer + num2.length >= num1.length) {
					num3[num3Pointer++] = num2[num2Pointer];
					System.out.println("Adding " + num2[num2Pointer]);
					num2Pointer++;
					continue;
				}
				num3[num3Pointer++] = num1[num1Pointer];
				System.out.println("Adding " + num1[num1Pointer]);
				num1Pointer++;
			} else if (num1Pointer < num1.length && num2Pointer < num2.length
					&& num1[num1Pointer] > num2[num2Pointer]) {
//				System.out.println("comparing "+num1[num1Pointer] +" > "+num2[num2Pointer]);
				num3[num3Pointer++] = num2[num2Pointer];
				System.out.println("Adding " + num2[num2Pointer]);
				num2Pointer++;
			}
		}
		for (int i = 0; i < num3.length; i++) {
			num1[i] = num3[i];
		}
	}

	//2nd Method
	public static void mergeArrays(int[] arr1, int[] arr2, int n1, int n2, int[] arr3) {
		int i = 0, j = 0, k = 0;

	// Traverse both array
			while (i < n1 && j < n2) {
	// Check if current element of first
	// array is smaller than current element
	// of second array. If yes, store first
	// array element and increment first array
	// index. Otherwise do same with second array
				if (arr1[i] < arr2[j])
					arr3[k++] = arr1[i++];
				else
					arr3[k++] = arr2[j++];
			}
	
	// Store remaining elements of first array
			while (i < n1)
				arr3[k++] = arr1[i++];
	
	// Store remaining elements of second array
			while (j < n2)
				arr3[k++] = arr2[j++];
		}
}
