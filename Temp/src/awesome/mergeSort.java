package awesome;

public class mergeSort {
	int c[]=new int[7];
	public int[] divide(int arr[],int n) {
		
		if(n==1)
			return arr;
		int arr1[]=new int[n/2];
		int arr2[];
		if(n%2==0)
			arr2=new int[n/2];
		else
			arr2=new int[n/2+1];
		
		arr1=divide(arr1,arr1.length);
		arr2=divide(arr2,arr2.length);
		
		return 	merge(arr1,arr2);	
	}
	public int[] merge(int a[], int b[]) {
		
		int i=0;
		int l1=a.length;
		int l2=b.length;
		while(l1<0 && l2<0)
		{
			if(a[i]<b[i])
			{
				c[c.length-i]=a[i];
				i++;
			}
			else
			{
				a[c.length-i]=b[i];
				i++;
			}
			l1--;
			l2--;
		}
		for (int j : c) {
			System.out.println(j);
		}
		return c;
		
	}
	public static void main(String[] args) 
	{
		mergeSort pa = new mergeSort();
        int arr[] = {7,2,3,1,3,6,6};
        int n = arr.length;
        System.out.println("Sorted Array is : ");
        pa.divide(arr, n);
	}

}
