package freshPractice;

public class Segerate0_1_2 {

	public static void main(String[] args) {
//		 TODO Auto-generated method stub
		int arr[]= {0,1,0,2,1,0,2};
		 int zeros=0;
		 int ones=0;	
		 int twos=arr.length-1;
		 int temp=0;
		 while(ones<=twos) {
			 if(arr[ones]==0) {
				 temp=arr[zeros];
				 arr[zeros]=arr[ones];
				 arr[ones]=temp;
				 zeros++;
				 ones++;
				 continue;
			 }
			 if(arr[ones]==1) {
				 ones++;
				 continue;
			 }
			 if(arr[ones]==2) {
				 temp=arr[ones];
				 arr[ones]=arr[twos];
				 arr[twos]=temp;
				 twos--;
				 continue;
			 }
			 
		 }
		 for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		int count=10;
		
//		for (int i = 0; i < count; i++) {
//			System.out.print(printFibonacci(i)+" ");			
//		}
//		 
	}

//	private static int  printFibonacci(int i) {
//		// TODO Auto-generated method stub
//		if(i<=1) {
//			return i;
//		}
//		return printFibonacci(i-1)+printFibonacci(i-2);
//	}

}
