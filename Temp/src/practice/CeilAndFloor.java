package practice;

public class CeilAndFloor 
{
	public static void main(String[] args)
	{
		int arr[]={3,4,6,10,11,12,13,17};
		findCeilFloor(arr,2,0,arr.length-1);
	}
	private static void findCeilFloor(int[] arr,int num, int start, int end) 
	{
		if (start<end)
		{
			int mid=(start+end+1)/2;
			if (arr[mid]==num) 
			{
				System.out.println("Ceil and Floor is: "+arr[mid]);
			}
			if (num<arr[mid] && num>arr[mid-1]) {
				System.out.println("Ceil "+arr[mid]);
				System.out.println("floor "+arr[mid-1]);
				return;
			}
			if (arr[end]<num) 
			{
				System.out.println("Ceil is: "+arr[end]);
				if (end+1<arr.length-1) {
					System.out.println("Floor is: "+arr[end+1]);
				}
			}
			if (arr[end]>num && end-start==1) 
			{
				System.out.println("Floor is: "+arr[end]);
				if (end+1<arr.length-1) {
					System.out.println("Ceil is: "+arr[end+1]);
				}
			}
			if (num<arr[mid])
			{
				findCeilFloor(arr, num,start,mid-1);
			}
			else if(num>arr[mid])
			{
				findCeilFloor(arr, num, mid+1, end);
			}
		}
	}
}
