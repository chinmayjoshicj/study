package awesome;

public class FixedPointInArray {
	static int  count=0;
    public static int fixedPt(int arr[], int high, int low)
    {
        int index=-1;
        int mid=(high+low)/2;
		if(high>=low)
		{
			if(arr[mid]==index)
			{
				
			}
		}
		return index;
    }
	public static void main (String[] args) 
	{
	   int arr[] = {-10, -5, 3, 4, 7, 9};
       int high = arr.length;
       //int x = 4;
       int low=0;
       int index = fixedPt(arr,high,low);
       if(index <=0)
         System.out.println("Does not exist");
       else
         System.out.println("Occurence "+index);
	}
}
