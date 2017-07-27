package awesome;

public class RainWaterTrappingProblem {

	static int trap[][] = null;
	static int count = 0;

	public static void main(String[] args) {
		int arr[] = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		/* int arr[]={3,0,0,2,0,4}; */
		/* int arr[]={0,0,0,0,0,0,0}; */
		int max = findMax(arr);
		trap = new int[max][arr.length];
		buildTrap(arr);

		printTrap(max, arr.length);
		System.out.println();
		System.out.println("count " + calculateTrappedWater(arr));
	}

	private static void printTrap(int rows, int columns) {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				System.out.print(trap[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void buildTrap(int[] arr) {
		for (int j = 0; j < arr.length; j++) {
			if (arr[j] != 0) {
				build(arr, j);
			}
		}
	}

	private static void build(int[] arr, int j) {
		int temp = trap.length - 1;
		for (int i = 0; i < arr[j]; i++) {
			trap[temp--][j] = 1;
		}

	}

	private static int findMax(int[] arr) {
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			if (max < arr[i]) {
				max = arr[i];
			}
		}
		return max;
	}

	private static int calculateTrappedWater(int[] arr) {
		int count = 0;
		for (int i = 0; i < trap.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (trap[i][j] == 0) {
					count = count + check(arr, i, j);
				}
			}
		}
		return count;
	}

	private static int check(int arr[], int row, int column) {
		int ones = 0;
		int i;
		int j;
		for (j = column - 1; j >= 0; j--) {
			if (trap[row][j] == 1) {
				ones++;
				break;
			}
		}
		for (i = column + 1; i < arr.length; i++) {
			if (trap[row][i] == 1) {
				ones++;
				break;
			}
		}
		if (ones >= 2) {
			 System.out.println("row "+row+"column "+j+" and "+row+" "+i+"-->"+row+" "+column);
			return 1;
		}
		return 0;
	}
}
