package practice;

public class NQueenProblem {

	public static void main(String[] args) {
		int arr[][] = new int[8][8];
		boolean possible = false;
		for (int i = 0; i < arr.length; i++) {
			possible = NQueenUtils(arr, i);
		}
		if (possible) {
			System.out.println(possible);
			drawMatrix(arr);
		}
	}

	private static void drawMatrix(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static boolean NQueenUtils(int[][] arr, int row) {
		if (row == arr.length) {
			return true;
		}
		boolean posAllowed = true;
		int col;
		for (col = 0; col < arr.length; col++) {
			// System.out.println("Checking for Row "+row+" Column "+col);
			posAllowed = checkPosition(row, col, arr);
			if (!posAllowed) {
				continue;
			}
			if (posAllowed) {
				arr[row][col] = 1;
				// drawMatrix(arr);
				// System.out.println();
				if (NQueenUtils(arr, row + 1)) {
					return true;
				} else {
					arr[row][col] = 0;
				}
			}
		}
		return false;
	}

	private static boolean checkPosition(int row, int col, int arr[][]) {
		int tempCol = col;
		int tempRow = 0;
		for (tempRow = 0; tempRow < arr.length && tempCol < arr.length; tempRow++) {
			if (tempRow == row) {
				continue;
			}
			if (arr[tempRow][tempCol] == 1) {
				return false;
			}
		}
		tempRow = row;
		tempCol = 0;
		for (tempCol = 0; tempCol < arr.length && tempRow < arr.length; tempCol++) {
			if (tempCol == col) {
				continue;
			}
			if (arr[tempRow][tempCol] == 1) {
				return false;
			}
		}
		tempRow = row;
		tempCol = col;
		for (; tempCol < arr.length && tempRow < arr.length; tempCol++, tempRow++) {
			if (tempCol == col) {
				continue;
			}
			if (arr[tempRow][tempCol] == 1) {
				return false;
			}
		}
		tempRow = row;
		tempCol = col;
		for (; tempCol >= 0 && tempRow >= 0; tempCol--, tempRow--) {
			if (tempCol == col) {
				continue;
			}
			if (arr[tempRow][tempCol] == 1) {
				return false;
			}
		}
		tempRow = row;
		tempCol = col;
		for (; tempCol < arr.length && tempRow >= 0; tempCol++, tempRow--) {
			if (tempCol == col) {
				continue;
			}
			if (arr[tempRow][tempCol] == 1) {
				return false;
			}
		}
		tempRow = row;
		tempCol = col;
		for (; tempCol >= 0 && tempRow < arr.length; tempCol--, tempRow++) {
			if (tempCol == col) {
				continue;
			}
			if (arr[tempRow][tempCol] == 1) {
				return false;
			}
		}
		return true;
	}
}
