package freshPractice;

public class MinimumCostMatrixPractice {

	static int minCost = Integer.MAX_VALUE;

	public static void main(String[] args) {
		int arr[][] = { 
							{ 1, 2, 3 }, 
							{ 4, 8, 2 }, 
							{ 1, 5, 3 } 
					  };

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();

		System.out.println(getMinimumCostFromMatrix(arr, 2, 2));

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static int getMinimumCostFromMatrix(int[][] arr, int row, int col) {

		for (int i = 1; i < arr.length; i++) {
			arr[0][i]+=arr[0][i-1];
		}
		
		for (int i = 1; i < arr.length; i++) {
			arr[i][0]+=arr[i-1][0];
		}
		
		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j < arr.length; j++) {
				arr[i][j]+=min(arr[i][j-1],arr[i-1][j-1],arr[i-1][j]);
			}
		}
		return arr[arr.length - 1][arr.length - 1];
	}

	public static int min(int a, int b, int c) {
		if (a <= b && a <= c)
			return a;

		else if (b <= a && b <= c)
			return b;

		else
			return c;

	}
}
