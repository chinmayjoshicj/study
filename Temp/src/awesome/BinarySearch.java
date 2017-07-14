package awesome;

public class BinarySearch {

	/*public  int bs1(int arr[],int start,int end,int value) {*/
		public int table(int i, int j) {
			if(i>=10)
			{
				return 0;
			}
			System.out.println(j+"*"+i+"="+j*i);
			i=i+1;
			table(i,j);
			return 0;
			

		/*if(start<=end)
		{
			int mid=(end+start+1)/2;
			if(arr[mid]==value)
			{
				return mid;
			}
			if (start==end) {
				
			}
			if(value>arr[mid])
			{
				start=mid+1;
				return bs1(arr,start,end,value);
			}
			if(value<arr[mid])
			{
				end=mid-1;
				return bs1(arr,start,end,value);	
			}
		}
		return -1;*/
			
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 /*int value=2;
		 BinarySearch bs=new BinarySearch();
		 int arr[] = {2,3,4,10,40,66,77,99};
		 int start=0;
		 int end=arr.length-1;
		 int a=bs.bs1(arr,start,end,77);
		 System.out.println("floor "+arr[a-1]+" ceil "+arr[a]);*/
		int i=0;
		int j=1;
		/*BinarySearch bs=new BinarySearch();
		int i=0;
		int a=bs.table(i,j);*/
		for (int k = 0; k < 10; k++)
		{
			if (k==0) {
				
			}
		}
		
	}

}
