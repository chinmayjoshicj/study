package freshPractice;

public class NoOfIslands {

	static int noOfIslands = 0;

	public static void main(String[] args) throws java.lang.Exception {
		int m[][] = new int[][] { { 1, 1, 0, 0, 0 }, { 0, 1, 0, 0, 1 }, { 1, 0, 0, 1, 1 }, { 0, 0, 0, 0, 0 },
				{ 1, 0, 1, 0, 1 } };
				
//				int m[][]={{ 0,1,1,1,0,0,0},
//						{ 0,0,1,1,0,1,0}};
//				
//				System.out.println(m.length);
//				System.out.println(m[0].length);

		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				if (m[i][j] == 1) {
					countIslands(m, i, j);
					noOfIslands++;
				}
			}
		}
		System.out.println("No of Islands :"+noOfIslands);
	}

	private static void countIslands(int[][] m, int row, int col) {
		// TODO Auto-generated method stub
		if (row < 0 || col < 0 || row > m.length-1 || col > m[0].length-1 || m[row][col] == 2 || m[row][col] == 0) {
			return;
		}
		if (m[row][col] == 1) {
			m[row][col] = 2;
			countIslands(m, row + 1, col);
			countIslands(m, row, col + 1);
			countIslands(m, row + 1, col + 1);
			countIslands(m, row - 1, col);
			countIslands(m, row, col - 1);
			countIslands(m, row - 1, col - 1);
			countIslands(m, row + 1, col - 1);
			countIslands(m, row - 1, col + 1);
		}
	}

}
