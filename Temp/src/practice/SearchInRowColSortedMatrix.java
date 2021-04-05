package practice;

public class SearchInRowColSortedMatrix {

	public static void main(String[] args) {
		int arr[][]= {{10,20,30,40},
					  {15,25,35,45},
					  {27,29,37,48},
					  {32,33,39,50}};
		
		int rowIndex=0;
		int colIndex=3;
		int x=29;
		
		while (rowIndex<arr.length-1|| colIndex>=0) {
			
			if(x>arr[rowIndex][colIndex]) {
				rowIndex++;
			}
			else if(x<arr[rowIndex][colIndex]) {
				colIndex--;
			}
			else if (x==arr[rowIndex][colIndex]) {
				System.out.println(rowIndex+" "+colIndex);
				break;
			}
		}
	}

}
