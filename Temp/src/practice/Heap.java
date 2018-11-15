package practice;

public class Heap {

	static int a[]={9,6,5,0,8,2,1,3};
	public static void main(String[] args)
	{
		for (int i = a.length/2 ; i < 0; i--) 
		{
			max_Heapify(i);
		}
		for (int i = 0; i < a.length; i++) 
		{
			System.out.print(a[i]+" ");
		}
	}
	private static void max_Heapify(int i) 
	{
		if (a[i]<a[i+1])
		{
			swap(i,i+1);
		}
		if (a[i]<a[i+2])
		{
			swap(i,i+2);
		}
	}
	private static void swap(int i, int j) 
	{
		int temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}
}
