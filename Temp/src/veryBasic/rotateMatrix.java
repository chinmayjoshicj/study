package veryBasic;

public class rotateMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] arr = { { '*', '*', '*', '^', '*', '*', '*' },
						 { '*', '*', '*', '|', '*', '*', '*' },
						 { '*', '*', '*', '|', '*', '*', '*' }, 
						 { '*', '*', '*', '|', '*', '*', '*' } };
		
//		char[][] arr = {{'1','2','3','4'},  
//                {'5','6','7','8'}, 
//                {'9','10','11','12'},
//                {'1','2','3','4'}}; 
//		
		char[][] temp=new char[arr[0].length][arr.length];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();

		}

		for (int i = 0; i < arr[0].length; i++) {
			for (int j = 0; j < arr.length; j++) {
				temp[i][j]=arr[arr.length-j-1][i];
			}
		}
		System.out.println();
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp[0].length; j++) {
				System.out.print(temp[i][j]);
			}
			System.out.println();

		}
	}

}
