package freshPractice;

public class SpiralTraverseMatrixPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[][] = { { 1,   2,   3,  4, 5 },
						{ 16, 17,  18, 19, 6 }, 
						{ 15, 24,  25, 20, 7 },
						{ 14, 23,  22, 21, 8 },
						{ 13, 12,  11, 10, 9 }};
		
		int rowStart=0;
		int rowEnd=arr.length-1;
		int colStart=0;
		int colEnd=arr[0].length-1;
		
		while (rowStart<=rowEnd && colStart<=colEnd) {
			int tColStart=colStart;
			while (tColStart<=colEnd) {
				System.out.print(arr[rowStart][tColStart++]+" ");
			}
			System.out.println();
			rowStart++;
			
			int tRowStart=rowStart;
			while (tRowStart<=rowEnd) {
				System.out.print(arr[tRowStart++][colEnd]+" ");
			}
			System.out.println();
			colEnd--;
			
			int tColEnd=colEnd;
			while (tColEnd>=colStart) {
				System.out.print(arr[rowEnd][tColEnd--]+" ");
			}
			rowEnd--;
			
			System.out.println();
			int tRowEnd=rowEnd;
			while (tRowEnd>=rowStart) {
				System.out.print(arr[tRowEnd--][colStart]+" ");
			}
			colStart++;
			System.out.println();
		}


	}

}
