package awesome;

public class InsertionSort {
	public int insertSort(int arr[], int n) {
				
		int temp;
		for (int i = 0; i < arr.length-1; i++) {
			if(arr[i]>arr[i+1])
			{
				temp=arr[i];
				arr[i]=arr[i+1];
				arr[i+1]=temp;
			}
			for (int j = i; j>=0; j--) {
				
				if(arr[j]>arr[i])
				{
					temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		return 0;
	}
	public static void main(String[] args) 
	{
				InsertionSort pa = new InsertionSort();
		        int arr[] = {1,2,8,1,3,6,9};
		        int n = arr.length;
		        System.out.println("Sorted elements are : ");
		        pa.insertSort(arr, n);
	}

}
