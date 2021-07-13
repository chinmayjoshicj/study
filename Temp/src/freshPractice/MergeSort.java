package freshPractice;

public class MergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 12, 11, 13, 5, 6, 7 };
		int low=0;
		int high=arr.length-1;
		
		
		divideArray(arr,low,high);
		printArray(arr);	

	}
	/* A utility function to print array of size n */
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

	private static void divideArray(int[] arr, int low, int high) {
		
		if(low<high) {
			int mid=low+ (high-low)/2;
			divideArray(arr, low, mid);
			divideArray(arr, mid+1, high);
			merge(arr,low,mid,high);
		}
	}

	private static void merge(int[] arr, int low, int mid, int high) {
		// TODO Auto-generated method stub
		int n1=mid-low+1;
		int n2=high-mid;
		
		
		int leftArray[]= new int[n1];
		int rightArray[]= new int[n2];
		
		
		for (int i = 0; i < leftArray.length; i++) {
			leftArray[i]=arr[low+i];
		}
		for (int j = 0; j < rightArray.length; j++) {
			rightArray[j]=arr[mid+j+1];
		}
		
//		/*Copy data to temp arrays*/
//        for (int i = 0; i < n1; ++i)
//            L[i] = arr[l + i];
//        for (int j = 0; j < n2; ++j)
//            R[j] = arr[m + 1 + j];
		
		int i=0;
		int j=0;
		int k=low;
		
		while (i<n1 && j<n2) {
			if(leftArray[i]<=rightArray[j]) {
				arr[k]=leftArray[i];
				i++;
			}
			else {
				arr[k]=rightArray[j];
				j++;
			}
			k++;
		}
		
		// copy remaining values in left and right array
		while (i<n1) {
			arr[k]=leftArray[i];
			i++;
			k++;
		}
		while (j<n2) {
			arr[k]=rightArray[j];
			j++;
			k++;
		}
	}

}
