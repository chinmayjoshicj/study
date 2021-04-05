package freshPractice;

public class DiagMatrixTrav {

	public static void main(String[] args) {
		int arr[][] = 
			{   { 1,    2,   3,   4, 5 },
				{ 16,  17,  18,  19, 6 }, 
				{ 15,  24,  25,  20, 7 }, 
				{ 14,  23,  22,  21, 8 }, 
				{ 13,  12,  11,  10, 9 }};
		
		for (int i = 0; i < arr.length; i++) {
			int temp_i=i;
			for (int j = 0; j <=i; j++) {
				if(temp_i<0) {
					break;
				}
				System.out.print(arr[temp_i][j]+" ");
				temp_i--;
			}
			System.out.println();
		}

		for (int j = 1; j<arr.length; j++) {
			int temp_j=j;
			for (int i = arr.length-1;; i--) {
				if(temp_j>arr.length-1) {
					break;
				}
				System.out.print(arr[i][temp_j++]+" ");
			}
			System.out.println();
		}
	}
}
