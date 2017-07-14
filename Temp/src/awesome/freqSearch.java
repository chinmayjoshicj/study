package awesome;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	static int  count=0;
    public static void count(int arr[],int low, int high, int x)
    {
    	int i;
    	int j;
    	i=first(arr,low,high,x);
    	System.out.println(i);
    }
	private static int first(int[] arr, int low, int high, int x) 
	{
		int mid=(high+low)/2;
			if (high>=low)
			{
				if (arr[mid] == x) 
				{
					if (mid == 0 || x > arr[mid - 1])
					{
						return mid;
					} 
					else if (x <=arr[mid + 1]) 
					{
						return first(arr, low, mid - 1, x);
					}
				} else if (x < arr[mid]) {
					return first(arr, low, mid - 1, x);
				} else {
					return first(arr, mid + 1, high, x);
				} 
			}
		return -1;
	}
	public static void main (String[] args) 
	{
	   int arr[] = {2, 2, 2, 2, 2, 2, 3};
       int n = arr.length;
       int x = 2;
       count(arr, 0, n-1, x);
	}
	
}
