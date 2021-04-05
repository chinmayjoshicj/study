package freshPractice;

public class Max1sInARow_SortedRow {

	public static void main(String[] args) {
		int arr[][] = { { 0, 0, 0, 0 },
						{ 0, 0, 1, 1 }, 
						{ 0, 0, 0, 1 }, 
						{ 0, 1, 1, 1 } 
					  };
		int max_1_row_Index=0;
		int col_first_1_found=arr[0].length-1;
		
		for (int i = 0; i < arr.length; i++) {
			if(arr[0][i]==1) {
				col_first_1_found=i;
				break;
			}
		}
		
		for (int i = 1; i < arr.length; i++) {
			for (int j =col_first_1_found-1 ; j < arr[0].length; j++) {
				if(col_first_1_found<=j)
				{
					continue;
				}
				if(col_first_1_found==0) {
					System.out.println("Row "+max_1_row_Index);
					return;
				}
				if(arr[i][j]==1 && j<col_first_1_found) {
					max_1_row_Index=i;
					col_first_1_found=j;
					if(col_first_1_found==1) {
						System.out.println("Row "+i);
						return;
					}
					break;
				}
				
			}
		}
		System.out.println("Row "+max_1_row_Index);
		
		
	}
}
