package practice;

public class CeilFloorPractice {

	public static void main(String[] args) 
	{
		int arr[]={2,4,6,10,11,12,13,17};
		findCeilFloor(arr,17,0,arr.length-1);
	}

	private static void findCeilFloor(int[] arr, int num, int start, int end) 
	{
//		int arr[]={2,4,6,10,11,12,13,17};
		while (start<=end) {
			int mid=(start+end)/2;
			if (num==arr[mid]) {
				if (mid!=arr.length-1 && mid!=0) {
					System.out.println("ceil "+arr[mid+1]);					
					System.out.println("Floor "+arr[mid-1]);	
					return;
				}
				else if(mid==0)
				{
					System.out.println("ceil "+arr[mid+1]);					
					System.out.println("Floor "+arr[mid]);
					return;
				}
				else {
					System.out.println("ceil "+arr[mid-1]);					
					System.out.println("Floor "+arr[mid]);
					return;
				}
			}
			if (num>arr[mid] && num<arr[mid+1]) {
				System.out.println("Floor "+arr[mid]+" Ceil "+arr[mid+1]);
				return;
			}
			if(num<arr[mid])
			{
				findCeilFloor(arr, num, start, mid);
				return;
			}
			else
			{
				findCeilFloor(arr, num, mid+1, end);
				return;
			}
			
		}
	}
}
