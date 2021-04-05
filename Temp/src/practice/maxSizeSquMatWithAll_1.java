package practice;

public class maxSizeSquMatWithAll_1 {
	public static void main(String[] args) {
		int arr[][] = { { 0, 1, 1, 0, 1 },
						{ 1, 1, 0, 1, 0 }, 
						{ 0, 1, 1, 1, 0 }, 
						{ 1, 1, 1, 1, 0 }, 
						{ 1, 1, 1, 1, 1 },
						{ 0, 0, 0, 0, 0 } };

		int temp[][] = new int[arr.length][arr[0].length];
		int max = 0;
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp[0].length; j++) {
				if (i == 0 || j == 0) {
					temp[i][j] = arr[i][j];
				} 
			}
		}
		
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp[0].length; j++) {
				if (i == 0 || j == 0) {
					temp[i][j] = arr[i][j];
				} else {
					temp[i][j] = arr[i][j]+getMin(temp[i - 1][j - 1], temp[i - 1][j], temp[i][j - 1]);
					if (temp[i][j] > max) {
						max = temp[i][j];
					}
				}
			}
		}
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp[0].length; j++) {
				System.out.print(temp[i][j]); 
			}
			System.out.println();
		}
		System.out.println("Max " + max);
	}

	private static int getMin(int num1, int num2, int num3) {
		int temp = num1 < num2 ? num1:num2;
        int result = num3 < temp ? num3:temp;
        return result;
	}
}
