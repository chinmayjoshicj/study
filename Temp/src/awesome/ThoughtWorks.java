package awesome;

import java.util.Scanner;

public class ThoughtWorks {

	/*
	 * static boolean check(int arr[], int n, int sum) { if (sum == 0) return
	 * true; if (n == 0 && sum != 0) return false;
	 * 
	 * if (arr[n - 1] > sum) return check(arr, n - 1, sum);
	 * 
	 * return check(arr, n - 1, sum) || check(arr, n - 1, sum - arr[n - 1]); }
	 */
	static boolean check(int arr[], int n, int sum) {
		boolean subset[][] = new boolean[2][sum + 1];

		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= sum; j++) {

				if (j == 0)
					subset[i % 2][j] = true;

				else if (i == 0)
					subset[i % 2][j] = false;
				else if (arr[i - 1] <= j)
					subset[i % 2][j] = subset[(i + 1) % 2][j - arr[i - 1]] || subset[(i + 1) % 2][j];
				else
					subset[i % 2][j] = subset[(i + 1) % 2][j];
			}
		}

		return subset[n % 2][sum];
	}

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		int noOftestcases = sc.nextInt();
		int arr[] = null;
		for (int i = 0; i < noOftestcases; i++) {
			int noOfboxes = sc.nextInt();
			arr = new int[noOfboxes];
			for (int j = 0; j < noOfboxes; j++) {
				arr[j] = sc.nextInt();
			}
			if (check(arr, arr.length, sc.nextInt()) == true)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
}
