package freshPractice;

public class Max1sInARowSortedMatrixPractice {

	public static void main(String[] args) {
//		int arr[][] = { { 0, 0, 0, 0 },
//						{ 0, 0, 1, 1 }, 
//						{ 0, 1, 1, 1 }, 
//						{ 0, 1, 1, 1 } 
//					  };
		
		int arr[][] = { { 0, 0, 1, 1 },
						{ 0, 0, 0, 1 }, 
						{ 0, 1, 1, 1 }, 
						{ 1, 1, 1, 1 } 
			  							};
		
		System.out.println("Row with max 1's is :"+rowWithMax1s(arr,4,4));
	}
	static int rowWithMax1s(int arr[][], int n, int m) {
		int rowWithMax1 = 0;
		int row=0;
		int col=3;
		
		while (row<4 && col<4 && row>=0 && col>=0) {
			if(arr[row][col]==1) {
				col--;
				rowWithMax1=row;
			}
			else {
				row++;
			}
		}
		
		return rowWithMax1;
	}
}
