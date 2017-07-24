package recursion;

public class SumAllPreviousElementsInAnArray 
{
	static int arr1[]= new int[6];
	public static void main(String[] args) 
	{
		int arr[]={1,2,3,4,5,6};
		sumRecursive(arr);
		printArr(arr1);
	}

	private static void printArr(int[] arr12) 
	{
		for (int i = 0; i < arr1.length; i++) 
		{
			System.out.print(arr1[i]+" ");
		}
	}

	private static void sumRecursive(int[] arr) 
	{
		sum(arr,arr.length-1);
	}

	private static int sum(int[] arr, int i) 
	{
		if (i==-1)
		{
			return 0;
		}
		arr1[i]=arr[i]+sum(arr, i-1);
		return arr1[i];
	}

}
