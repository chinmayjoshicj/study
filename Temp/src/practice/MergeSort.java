package practice;
/*Need Some modification*/
public class MergeSort {

	public static void main(String[] args) 
	{
		int arr[]={2,4,1,6,8,20,3,7};
		perFormMergeSort(arr,0,arr.length-1);
		for (int i = 0; i < arr.length; i++) 
		{
			System.out.print(arr[i]+" ");
		}
	}

	private static void perFormMergeSort(int[] arr, int l, int r) 
	{
		if (l<r)
		{
			int m=(l+r)/2;
			perFormMergeSort(arr, l, m);
			perFormMergeSort(arr, m+1, r);
			merge(arr,l,m,r);
		}
		
	}

	private static void merge(int[] arr, int left, int mid, int right) {
		// TODO Auto-generated method stub
		
		int i=0;
		int j=0;
		int k=left;
		
		int n1 = mid-left+1;
		int leftArr[]=new int[n1];
		int n2 = right-mid;
		int rightArr[]=new int[n2];
		
		for (int i2 = 0; i2 < n1; i2++) {
			leftArr[i2]=arr[i2];
		}
		
		for (int i2 = mid; i2 < n2; i2++) {
			rightArr[i2-mid]=arr[i2];
		}
		
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
			for (int i2 = left; i2 < leftArr.length; i++) 
			{
				arr[k++]=leftArr[i];
			}
		}
		if (left>leftArr.length) 
		{
			for (int i2 = right; i2 < rightArr.length; i2++) 
			{
				arr[k++]=rightArr[i2];
			}
		}
	}
}
