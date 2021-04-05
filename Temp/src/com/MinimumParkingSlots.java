package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class MinimumParkingSlots {
	static int minParkingSpaces(int[][] parkingStartEndTimes) {
		// YOUR CODE HERE
		int startTimeOrig[] = new int[parkingStartEndTimes.length];
		int endTimeOrig[] = new int[parkingStartEndTimes.length];
		
		for (int i = 0; i < startTimeOrig.length; i++) {
			startTimeOrig[i] = parkingStartEndTimes[i][0];
		}
		
		Arrays.sort(startTimeOrig);
		for (int i = 0; i < startTimeOrig.length; i++) {
			int j = 0;
			while (j < startTimeOrig.length) {
				if (parkingStartEndTimes[j][0] == startTimeOrig[i]) {
					endTimeOrig[i] = parkingStartEndTimes[j][1];
					break;
				} else {
					j++;
				}
			}
		}
////	4
//		5,10 0,20 25,40 35,45
//
//		3
//		0,2 2,4 4,6
//
//		3
//		0,50 2,60 3,40

		int maxCount = 0;
		ArrayList<Integer> areParkedEndTime = new ArrayList<Integer>();
		for (int i = 0; i < startTimeOrig.length; i++) {
			if (i == 0) {
				areParkedEndTime.add(endTimeOrig[i]);
				maxCount = 1;
				continue;
			}
			boolean seperateSlot = true;
			for (int j = 0; j < areParkedEndTime.size(); j++) {
				if (startTimeOrig[i] >= areParkedEndTime.get(j)) {
					seperateSlot = false;
				}
			}
			if (seperateSlot) {
				maxCount++;
			}
		}
		return maxCount;

	}

	// DO NOT MODIFY ANYTHING BELOW THIS LINE!!

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter wr = new PrintWriter(System.out);
		int n = Integer.parseInt(br.readLine().trim());
		int[][] parkingStartEndTimeList = new int[n][2];
		String[] parkingStartEndTimes = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			String[] parkingStartEndTime = parkingStartEndTimes[i].split(",");
			for (int j = 0; j < parkingStartEndTime.length; j++) {
				parkingStartEndTimeList[i][j] = Integer.parseInt(parkingStartEndTime[j]);
			}
		}

		int out = minParkingSpaces(parkingStartEndTimeList);
		System.out.println(out);

		wr.close();
		br.close();
	}
}