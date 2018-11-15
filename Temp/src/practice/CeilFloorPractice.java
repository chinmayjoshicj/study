package practice;

public class CeilFloorPractice {

	public static void main(String[] args) 
	{
		int arr[]={2,4,6,10,11,12,13,17};
		findCeilFloor(arr,3,0,arr.length-1);
	}

	private static void findCeilFloor(int[] arr, int num, int start, int end) 
	{
		if (start<=end) 
		{
			int mid=(start+end)/2;
			if (arr[mid]==num) {
				System.out.print(arr[mid]+" Both ");
				System.out.println();
				return;
			}
			if (start+1==end && num>arr[start] && num<arr[end])
			{
				System.out.println("ceil "+arr[end]);
				System.out.println("floor "+arr[start]);
			}
			if (num<arr[mid])
			{
				findCeilFloor(arr, num, start, mid-1);
			}
			if (num>arr[mid]) 
			{
				findCeilFloor(arr, num, mid+1, end);
			}
		}
	}
}
