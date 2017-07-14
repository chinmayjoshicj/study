package awesome;

public class selectionSort {
	
	public int selectionSort(int arr[], int n) {
		int temp=0;
		int min=0;
			//int min=0;
			for (int i = min; i <= arr.length - 2; i++) 
			{
				for (int j = i+1; j <= arr.length-1; j++) 
				{
					if (arr[j] < arr[min]) 
					{
						temp = arr[j];
						arr[j] = arr[min];
						arr[min] = temp;
					}
				}
				min++;
			}
		for (int i1 = 0; i1 < arr.length; i1++) {
			System.out.println(arr[i1]);
		}
		return 0;
	}
	public static void main(String[] args) 
	{
				selectionSort pa = new selectionSort();
		        int arr[] = {7,2,3,1,3,6,6};
		        int n = arr.length;
		        System.out.println("Sorted Array is : ");
		        pa.selectionSort(arr, n);
		        
	}
}
