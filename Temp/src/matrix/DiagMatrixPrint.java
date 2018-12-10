package matrix;

public class DiagMatrixPrint {

	public static void main(String[] args) {
		int mat[][] = { { 10, 20, 30, 40 }, 
						{ 15, 25, 35, 45 }, 
						{ 27, 29, 37, 48 }, 
						{ 32, 33, 39, 50 } };

		print(mat, 4);
	}

	private static void print(int[][] mat, int n) {
		int i = 0;
		int j = 0;

		boolean isUp = true;
		for (int k = 0; k < n * n;) {
			if (isUp) {
				for (; i >= 0 && j < n; j++, i--) {
					System.out.print(mat[i][j] + " ");
					k++;
				}

				// Set i and j according to direction
				if (i < 0 && j <= n - 1)
					i = 0;
				if (j == n) {
					i = i + 2;
					j--;
				}
			} else {
				for (; j >= 0 && i < n; i++, j--) {
					System.out.println(mat[i][j]);
					k++;
				}
				if (j < 0 && i <= n - 1) {
					j = 0;
				}
				if (i == n) {
					j = j + 2;
					i--;
				}
			}
			isUp = !isUp;
		}
	}
}
