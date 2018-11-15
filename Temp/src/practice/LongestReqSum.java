package practice;

public class LongestReqSum {

	public static void main(String[] args) 
	{
		int arr[]= {2,4,5,5,2,5,7,-3};
		
		int reqSum=11;
		int end=0;
		int index[][]= new int[arr.length][2];
		int start=0;
		for (int i = start; i < arr.length; i++) 
		{
			int sum = 0;
			end=i;
			while (end<arr.length) {
				sum+=arr[end];
				if (sum==reqSum) {
					index[i][0]=i;
					index[i][1]=end;
					break;
				}
				end++;
			}
		}
		for (int i = 0; i < index.length; i++) {
			System.out.println(index[i][0]+" "+index[i][1]);
		}
	}
}
