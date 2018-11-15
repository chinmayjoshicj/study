package practice;
/*Need Some modification*/
public class MergeSort {

	public static void main(String[] args) 
	{
		int arr[]={2,4,1,6,8,5,3,7};
		perFormMergeSort(arr);
		for (int i = 0; i < arr.length; i++) 
		{
			System.out.print(arr[i]+" ");
		}
	}

	private static void perFormMergeSort(int[] arr) 
	{
		int length=arr.length;
		int mid=arr.length/2;

		if (length<2) {
			return;
		}
		int leftArr[]=new int[mid];
		int rightArr[]=new int[length-mid];
		
		for (int i = 0; i < mid; i++) {
			leftArr[i]=arr[i];
		}
		
		for (int i = mid; i < arr.length; i++) {
			rightArr[i-mid]=arr[i];
		}
		perFormMergeSort(leftArr);
		perFormMergeSort(rightArr);
		merge(leftArr,rightArr,arr);
	}

	private static void merge(int[] leftArr, int[] rightArr, int[] arr) 
	{
		int left=0;
		int right=0;
		int k=0;
		
		while (left<leftArr.length && right<rightArr.length) 
		{
			if (leftArr[left]<=rightArr[right])
			{
				arr[k]=leftArr[left++];
			}
			else
			{
				arr[k]=rightArr[right++];
			}
			k++;
		}
		
		if (right>rightArr.length) 
		{
			for (int i = left; i < leftArr.length; i++) 
			{
				arr[k++]=leftArr[i];
			}
		}
		if (left>leftArr.length) 
		{
			for (int i = right; i < rightArr.length; i++) 
			{
				arr[k++]=rightArr[i];
			}
		}
	}
}
