package leetCode;

import java.util.Arrays;

public class NoOfPlatforms {

	static int arr[]= {900,940,950,1100,1500,1800};
	static int dept[]= {910,1200,1120,1130,1900,2000};
	
	public static void main(String[] args) {
		Arrays.parallelSort(arr);
		Arrays.sort(dept);
		
		int maxPlatforms=1;	
		int currentPlatformsUsed=1;
		
		int iArr=1;	
		int	jDept=0;	
		
		while (iArr< arr.length && jDept< dept.length) {
			if(arr[iArr]<dept[jDept]) {
				currentPlatformsUsed++;
				if(maxPlatforms<currentPlatformsUsed) {
					maxPlatforms=currentPlatformsUsed;
				}
				iArr++;
			}
			else {
				currentPlatformsUsed--;
				jDept++;
			}
		}
		System.out.println(maxPlatforms);
	}

}
