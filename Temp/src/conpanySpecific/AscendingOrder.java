package conpanySpecific;

import java.util.ArrayList;
import java.util.Collections;

/*Print number in ascending order which contains 1, 2 and 3 in their digits.
Given an array of numbers, the task is to print those numbers in ascending order 
separated by commas which have 1, 2 and 3 in their digits. 
If no number containing digits 1, 2, and 3 present then print -1.*/

/*Input : numbers[] = {123, 1232, 456, 234, 32145}
Output : 123, 1232, 32145

Input : numbers[] = {9821, 627183, 12, 1234}
Output : 1234, 627183

Input : numbers[] = {12, 232, 456, 234}
Output : -1*/

public class AscendingOrder {

	public static void main(String[] args) 
	{
		int arr[]={9821, 627183, 12, 1234};
		ArrayList<Integer> l=new ArrayList<>();
		for (int i = 0; i < arr.length; i++) 
		{
			int count1=0;
			int count2=0;
			int count3=0;
			char a[]=Integer.toString(arr[i]).toCharArray();
			for (int j = 0; j < a.length; j++) 
			{
				if (a[j]=='1') {
					count1++;
				}
				if (a[j]=='2') {
					count2++;
				}
				if (a[j]=='3') {
					count3++;
				}
			}
			if (count1 >0 && count2>0 && count3>0) {
				l.add(arr[i]);
			}
			
		}
		Collections.sort(l);
		if (l.size()==0) {
			System.out.println("-1");
			return;
		}
		System.out.println(l);
	}

}
