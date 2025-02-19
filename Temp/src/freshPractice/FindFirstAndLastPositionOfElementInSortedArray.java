package freshPractice;

import java.util.ArrayList;

public class FindFirstAndLastPositionOfElementInSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int nums[]= {5,7,7,8,8,10};
		int target=8;
		
		ArrayList<Integer> list= new ArrayList<Integer>();
		int finalArr[]=new int[2];
		
		for (int i = 0; i < nums.length; i++) {
			if(nums[i]==target)
			{
				list.add(i);
			}
		}
		if(list.isEmpty()) {
			finalArr[0]=-1;
			finalArr[1]=-1;
		}
		System.out.println(list.get(0)+" "+list.get(list.size()-1));
		finalArr[0]=list.get(0);
		finalArr[1]=list.get(list.size()-1);
		
		
	}

}
