package freshPractice;

import java.util.Arrays;

public class NoOfPlatformsPractice {

	static int arr[] = { 900, 940, 950, 1100, 1500, 1800 };
	static int dept[] = { 910, 1200, 1120, 1130, 1900, 2000 };

	public static void main(String[] args) {
		Arrays.sort(arr);
		Arrays.sort(dept);

		int arrPt=0;
		int deptPt=0;
		int maxPlatForms = 0;
		int currPlatforms=0;
		while (arrPt<=arr.length-1 && deptPt<=arr.length-1) {
			if(arr[arrPt]<=dept[deptPt]) {
				arrPt++;
				currPlatforms++;
			}
			else if(arr[arrPt]>=dept[deptPt]) {
				currPlatforms--;
				deptPt++;
			}
			maxPlatForms=Math.max(maxPlatForms, currPlatforms);
		}
		
		System.out.println(maxPlatForms);
	}
}
