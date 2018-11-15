package practice;

public class KthSmallestElementArray 
{
	public static void main(String[] args) 
	{
		int arr[] = { 7, 10, 4, 3, 20, 15 };
		
		methodMinHeap(arr);
		
		for (int i : arr) 
		{
			System.out.print(i+" ");
		}
		System.out.println();
		
		/*TreeMap<Integer, Integer> map = new TreeMap<>();
		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i]) + 1);
			} else
				map.put(arr[i], 1);
		}
		int count = 2;
		for (Entry<Integer, Integer> set : map.entrySet()) {
			int val = set.getValue();
			while (val != 0) {
				count--;
				if (count == 0) {
					System.out.println(set.getKey());
					// break;
				}
				val--;
			}

		}*/
	}
	private static void methodMinHeap(int[] arr) 
	{
		int i=arr.length/2;
		
		while (i>=0) 
		{
			heapify(arr,i);
			i--;
		}
	}
	private static void heapify(int[] arr, int i) 
	{
		int l=2*i+1;
		int r=2*i+2;
		
		int smallest=i;
		if (l<arr.length && arr[l]<arr[i]) {
			smallest=l;
		}
		if (r<arr.length && arr[r]<arr[smallest]) {
			smallest=r;
		}
		if (smallest!=i)
		{
			int temp=arr[i];
			arr[i]=arr[smallest];
			arr[smallest]=temp;
			heapify(arr, smallest);
		}
	}
}
