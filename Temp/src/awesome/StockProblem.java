package awesome;

import java.util.ArrayList;
import java.util.Scanner;

public class StockProblem {
	static ArrayList<Integer> arr = null;
	static int min = 10000;
	static int budget = -1;
	static int count = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter no of Days");
		int n = sc.nextInt();
		arr = new ArrayList<Integer>();
		System.out.println("Enter stock price one by one");
		for (int i = 0; i < n; i++) {
			arr.add(sc.nextInt());
		}
		System.out.println("Enter budget");
		budget = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int index = getMinValue();
			printArr();
			purchase(index + 1);
			arr.set(index, Integer.MAX_VALUE-1);
			min = Integer.MAX_VALUE;
		}
		System.out.println("Count is " + count);
	}

	private static void printArr() {
		System.out.println("The Array List is");
		for (Integer a : arr) {
			System.out.print(a + " ");
		}
		System.out.println();
	}

	private static void purchase(int index) {
		while (budget >= min && index != 0) {
			count++;
			budget = budget - min;
			index--;
		}
	}

	private static int getMinValue() {
		int index = 0 ;
		for (int i = 0; i < arr.size(); i++) {
			if (arr.get(i) < min) {
				min = arr.get(i);
				index = i;
				// System.out.println(min+"qqq");
			}
		}
		// System.out.println("Inside "+arr.indexOf(min));
		return index;
	}
}
