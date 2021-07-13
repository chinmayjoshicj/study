package freshPractice;

import java.util.Arrays;

public class PrintLargestNumWithNDigitsAndSumS {

	static int max = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 2;
		int sum = 3;

		printLargestNumSumS(n, sum);
	}

	private static void printLargestNumSumS(int n, int sum) {
		// TODO Auto-generated method stub
		char numArr[] = new char[n];
		for (int i = 1; i <= 9; i++) {
			numArr[0] = (char) (i + '0');
			printLargestNumUtils(numArr, sum - i, n, 1);
		}
	}

	private static void printLargestNumUtils(char[] num, int sum, int n, int index) {
		// TODO Auto-generated method stub
		if (index > n || sum < 0) {
			return;
		}
		if (index == n) {
			if (sum == 0) {
				System.out.print(Integer.parseInt(String.valueOf(num)) + " ");
				max = Math.max(Integer.parseInt(String.valueOf(num)), max);
			}
			return;
		}
		for (int i = 0; i <= 9; i++) {
			num[index] = (char) (i + '0');
			printLargestNumUtils(num, sum - i, n, index + 1);
		}
	}
}
