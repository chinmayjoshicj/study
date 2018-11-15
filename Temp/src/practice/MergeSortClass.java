package practice;

public class MergeSortClass
{
	public static void main(String[] args) 
	{
		int arr[]={2,4,1,6,8,5,3,7};
		split(arr,0,arr.length-1);
		System.out.println();
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
	}
	private static void split(int[] arr, int start, int end) 
	{
		if (start<end) 
		{
			int mid=(start+end)/2;
			split(arr, start, mid);
			split(arr, mid+1, end);
			merge(arr,start,mid,end);
		}
	}
	private static void merge(int[] arr, int start, int mid, int end) 
	{
		int lLength=mid-start+1;
		int rLength=end-mid;
		int l[]= new int[lLength];
		int r[]= new int[rLength];
		
		int lIndex=0;
		int rIndex=0;
		int k=0;
		
		for (int i=0; i<lLength; ++i) 
			l[i] = arr[start + i]; 
		for (int j=0; j<rLength; ++j) 
			r[j] = arr[mid+j+1]; 
		k=start;
		while (lIndex<lLength && rIndex<rLength)
		{
			if (l[lIndex]>r[rIndex]) {
				arr[k++]=l[lIndex++];
			}
			else
			{
				arr[k++]=r[rIndex++];
			}
		}
		while (lIndex<lLength) {
			arr[k++]=l[lIndex++];
		}
		while (rIndex<rLength)
		{
			arr[k++]=r[rIndex++];
		}
	}
}
