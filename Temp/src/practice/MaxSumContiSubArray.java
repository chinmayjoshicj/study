package practice;

public class MaxSumContiSubArray {

	public static void main(String[] args) {
		
		int arr[]= {-2,1,-3,4,-1,2,1,-5,4};
		int sol[]=new int[arr.length];
		int currSum=arr[0];
		for (int i = 0; i < arr.length; i++) {
			System.out.println("currSum+arr[i]"+(currSum+arr[i])+ " > "+arr[i]+" ?");
			if((currSum+arr[i])>arr[i]) {
				System.out.println("Yes Greater , Extent the sum from previous Value!!");
				sol[i]=currSum+arr[i];
			}
			else
			{
				sol[i]=arr[i];
			}
			currSum=sol[i];
		}
		for (int i = 0; i < sol.length; i++) {
			System.out.print(sol[i]+" ");
		}
	}

}
