package freshPractice;

import java.util.Arrays;

public class NoOfPlatformsPractice {

	static int arr[] = { 900, 940, 950, 1100, 1500, 1800 };
	static int dept[] = { 910, 1200, 1120, 1130, 1900, 2000 };

	public static void main(String[] args) {
		Arrays.sort(arr);
		Arrays.sort(dept);
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		for (int i = 0; i < arr.length; i++) {
			System.out.print(dept[i]+" ");
		}
		System.out.println();
		int iArr=1;
		int jDept=0;
		int noOfPlatForms=1;
		int maxPlatForms=1;
		
		while (iArr<arr.length && jDept<arr.length) {
			if(arr[iArr]>dept[jDept]) {
				jDept++;
				noOfPlatForms--;
				System.out.println("minus "+noOfPlatForms);
			}
			else {
				iArr++;
				noOfPlatForms++;
				System.out.println("added "+noOfPlatForms);
				maxPlatForms=Math.max(noOfPlatForms, maxPlatForms);
			}
		}	
		
		System.out.println("Max Platforms "+maxPlatForms);
	}
}
