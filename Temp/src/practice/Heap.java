package practice;

public class Heap {

	static int a[] = { 9, 6, 5, 0, 8, 2, 1, 3 };

	public static void main(String[] args) {
		for (int i = a.length / 2 - 1; i >= 0; i--) {
			max_Heapify(i);
		}
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

	private static void max_Heapify(int i) {
		int largest = Integer.MIN_VALUE;
		int l = 2 * i;
		int r = 2 * i + 1;
		if (l < a.length && a[l] > a[i]) {
			largest = l;
		} else {
			largest = i;
		}
		if (r < a.length && a[r] > a[largest]) {
			largest = r;
		}
		if (largest != i) {
			swap(largest, i);
			max_Heapify(largest);
		}
	}

	private static void swap(int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
