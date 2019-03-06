package matrix;

public class DiagMatrixPrint {

	public static void main(String[] args) {
		int mat[][] = { { 10, 20, 30, 40 }, { 15, 25, 35, 45 }, { 27, 29, 37, 48 }, { 32, 33, 39, 50 } };

		print(mat, 4);
	}

	private static void print(int[][] mat, int order) {
		int row = 0;
		int col = 0;
		while (row < order) {
			int temp = row;
			while (row >= 0 && col <= 3) {
				System.out.print(mat[row][col] + " ");
				col++;
				row--;
			}
			System.out.println();
			col = 0;
			row = temp + 1;

		}
		row = 3;
		col = 1;
		while (col < order) {
			int temp = col;
			while (col <= 3 && row >= 0) {
				System.out.print(mat[row][col] + " ");
				col++;
				row--;
			}
			System.out.println();
			row = 3;
			col = temp + 1;

		}
	}

}
