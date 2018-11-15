package practice;
/*Need Some modification*/
public class QuickSort {

	public static void main(String[] args)
	{
		int arr[]={2,4,1,6,8,5,3,7};
		performQuickSort(arr,0,arr.length-1);
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
	}

	private static void performQuickSort(int[] arr, int low, int high) 
	{
		if(low<high)
		{
			int part=performPartitions(arr,low,high);
			performQuickSort(arr, low, part-1);
			performQuickSort(arr, part+1, high);
		}
	}

	private static int performPartitions(int[] arr, int low, int high) 
	{
		int pivot=arr[high];
		int i=low-1;
		
		for (int j = low; j < high; j++) 
		{
			if (arr[j]<=pivot)
			{
				i++;
				int temp=arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
			}
		}
		int temp=arr[i+1];
		arr[i+1]=arr[high];
		arr[high]=temp;
		return i+1;
	}
}
