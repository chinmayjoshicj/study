package leetCode;

import java.util.Arrays;

public class NoOfPlatformsPractice {

	static int arr[] = { 900, 940, 950, 1100, 1500, 1800 };
	static int dept[] = { 910, 1200, 1120, 1130, 1900, 2000 };

	public static void main(String[] args) {
		Arrays.sort(arr);
		Arrays.sort(dept);

		int maxPlatForms = 0;
		int currNoOfPlatforms=0;

		int arrPointer = 0;
		int deptpointer = 0;

		while (arrPointer < arr.length && deptpointer < dept.length) {
			if (arr[arrPointer] < dept[deptpointer]) {
//				arrPointer++;
				currNoOfPlatforms++;
				System.out.println("Current No. of platforms "+ arr[arrPointer++] + "<"+dept[deptpointer] +" "+currNoOfPlatforms);
			}
			else {
//				deptpointer++;
				currNoOfPlatforms--;
				System.out.println("Current No. of platforms "+ arr[arrPointer] + "<"+dept[deptpointer++] +" "+currNoOfPlatforms);
			}
			maxPlatForms=Math.max(currNoOfPlatforms, maxPlatForms);
		}
		System.out.println(maxPlatForms);
	}
}
