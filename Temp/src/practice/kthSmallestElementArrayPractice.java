package practice;

public class kthSmallestElementArrayPractice 
{
	public static void main(String[] args) 
	{
		int arr[] = { 7, 10, 4, 3, 20, 15 };
		int length=arr.length;
		for (int i = length/2; i >= 0; i--) 
		{
			heapify(arr,i);
		}
		for (int i = 0; i < arr.length; i++) 
		{
			System.out.print(arr[i]+" ");
		}
	}

	private static void heapify(int[] arr, int i) 
	{
		int left=2*i+1;
		int right=2*i+2;
		
		int smallest = i;
		
		if (left<arr.length && arr[left]<arr[i]) {
			smallest=left;
		}
		if (right<arr.length && arr[right]<arr[smallest]) {
			smallest=right;
		}
		/*if (arr[left]<arr[i])
		{
			smallest=left;
		}
		if (arr[right]<arr[smallest])
		{
			smallest=right;
		}*/
		if (smallest!=i)
		{
			int temp=arr[i];
			arr[i]=arr[smallest];
			arr[smallest]=temp;
			heapify(arr, smallest);
		}
	}
}
