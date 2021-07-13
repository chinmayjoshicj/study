package freshPractice;

public class WaysToGetSumNFromArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[]= {1,5,6};
		int sum=7;
		int count[]=new int[sum+1];
		count[0]=1;
		
		for (int i = 1; i <=sum; i++) {
			for (int j = 0; j < arr.length; j++) {
				if(i>=arr[j]) {
					count[i]=count[i]+count[i-arr[j]];
				}
			}
			
		}	
		for (int i = 0; i < count.length; i++) {
			System.out.print(count[i]+" ");
		}
	}

}
