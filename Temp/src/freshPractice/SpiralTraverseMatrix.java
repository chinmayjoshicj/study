package freshPractice;

public class SpiralTraverseMatrix {

	public static void main(String[] args) {
		int arr[][] = { { 1, 2, 3, 4, 5 }, { 16, 17, 18, 19, 6 }, { 15, 24, 25, 20, 7 }, { 14, 23, 22, 21, 8 },
				{ 13, 12, 11, 10, 9 } };

		int rowStart = 0, rowEnd = arr.length - 1, colStart = 0, colEnd = arr.length - 1, i = 0;

		while (rowStart <= rowEnd && colStart <= colEnd) {
			
			for (i = colStart; i <= colEnd; i++) {
				System.out.print(arr[rowStart][i] + " ");
			}
			System.out.println();
			rowStart++;

			for (i = rowStart; i <= rowEnd; i++) {
				System.out.print(arr[i][colEnd] + " ");
			}
			System.out.println();
			colEnd--;
			
			if (rowStart < rowEnd) {
				for (i = colEnd; i >= colStart; i--) {
					System.out.print(arr[rowEnd][i] + " ");
				}
				rowEnd--;
			}
			System.out.println();

			if (colStart < colEnd) {
				for (i = rowEnd; i >= rowStart; i--) {
					System.out.print(arr[i][colStart] + " ");
				}
				colStart++;
			}
			System.out.println();
		}

	}

}
