package awesome;

public class RainWaterTrappingProblem {

	public static void main(String[] args) 
	{
		int arr[]={0,1,0,2,1,0,1,3,2,1,2,1};
		int max = 0;
		int index=0;
		for (int i = 0; i < arr.length; i++) 
		{
			if (max<arr[i])
			{
				max=arr[i];
				index=i;
			}
		}
		int count=calculateTrappedWater(arr,0,index);
		count=count+calculateTrappedWater(arr, index, arr.length-1);
		System.out.println(count);
	}

	private static int calculateTrappedWater(int[] arr, int i, int index) 
	{
		int count=0;
		for (int j = i; j < index; j++) 
		{
			
		}
		return count;
	}
}
