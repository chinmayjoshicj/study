package freshPractice;

public class NoOfIslandsPractice {

	static int noOfIslands = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[][] = { { 1, 1, 0, 0, 0 }, 
						{ 0, 1, 0, 0, 1 },
						{ 1, 0, 0, 1, 1 },
						{ 0, 0, 0, 0, 0 }, 
						{ 1, 0, 1, 0, 1 } };
//		int arr[][]={		{ 0,1,1,1,0,0,0},
//							{ 0,0,1,1,0,1,0}};

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j] == 1) {
					countNoOfIslands(arr, i, j);
					noOfIslands++;
				}
			}
		}

		System.out.println(noOfIslands);
	}

	private static void countNoOfIslands(int[][] arr, int row, int col) {
		if (row < 0 || col < 0 || row > arr.length-1 || col > arr[0].length-1 ||  arr[row][col] == 0 || arr[row][col] == 2 ) {
			return;
		}
		if (arr[row][col] == 1) {
			arr[row][col] = 2;
			countNoOfIslands(arr, row - 1, col - 1);
			countNoOfIslands(arr, row - 1, col);
			countNoOfIslands(arr, row - 1, col + 1);
			countNoOfIslands(arr, row, col + 1);
			countNoOfIslands(arr, row + 1, col + 1);
			countNoOfIslands(arr, row + 1, col);
			countNoOfIslands(arr, row + 1, col - 1);
			countNoOfIslands(arr, row, col - 1);
		}
	}

}
