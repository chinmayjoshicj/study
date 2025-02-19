package leetCode;

public class RemoveDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {-3,-1,0,0,0,3,3,4,5,5};
		int val= 0;
//		removeDuplicateFromSortedArray(nums);
		removeAValue(nums,val);
		findOccuranceOfString();
	}
	

	private static void findOccuranceOfString() {
		// TODO Auto-generated method stub
		String string1= "sadbutsad";
		String string2= "sad";
		
		char s1[]=string1.toCharArray();
		char s2[]=string2.toCharArray();
		
		int count1=s1.length;
		int count2=s2.length;
		
		while (count1>0) {
			if(s2[count2]==s1[count1]) {
				count1++;
				count2++;
			}
			else {
				
			}
		}
	}


	private static void removeAValue(int[] nums, int val) {
		// TODO Auto-generated method stub
		int count=0;
		for (int i = 0; i < nums.length; i++) {
			if(nums[i]!=val) {
				nums[count++]=nums[i];
			}
		}
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i]+" ");
		}
	}

	private static int removeDuplicateFromSortedArray(int []nums) {
		// TODO Auto-generated method stub
		int leftPointer=1;
		for (int i = 1; i < nums.length; i++) {
			if(nums[i]!=nums[i-1]) {
				nums[leftPointer]=nums[i];
				leftPointer++;
			}
		}
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i]+" ");
		}
		System.out.println();
		System.out.println(leftPointer);
		return 0;
	}

}
