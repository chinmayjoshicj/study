package awesome;

import java.util.Arrays;

public class bubbleSort 
{
	public int insertSort(int arr[], int n) {
		int temp=0;
		 for (int i = 0; i < arr.length-1; i++) {
			for (int j = i+1; j <= arr.length-1; j++) {
				if(arr[i]>arr[j])
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
				bubbleSort pa = new bubbleSort();
		        int arr[] = {1,2,3,1,3,6,6};
		        int n = arr.length;
		        System.out.println("Duplicates in arrays are : ");
		        pa.insertSort(arr, n);
	}


}
