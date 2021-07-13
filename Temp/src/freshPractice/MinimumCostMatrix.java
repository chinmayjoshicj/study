package freshPractice;

public class MinimumCostMatrix {

	public static void main(String[] args) {
		int arr[][] = 
			{{ 1,  2,  3 },
			 { 4,  8,  2 }, 
			 { 1,  5,  3 }
			 };
		
	System.out.println(getMinimumCostFromMatrix(arr,2,2));
		
		
	}	
	static int getMinimumCostFromMatrix(int arr[][],int m, int n) {
		
		if(m<0 || n<0) {	
			return Integer.MAX_VALUE;
		}
		else if(m==0 && n==0){
			return arr[m][n];
		}
		else {
			return arr[m][n]+getMinimum(getMinimumCostFromMatrix(arr, m-1, n), 
										getMinimumCostFromMatrix(arr, m-1, n-1),
										getMinimumCostFromMatrix(arr, m, n-1));
		}
				
	}
	static int getMinimum(int x,int y, int z){
		if(x<y) {
			return x<z?x:z;
		}
		else
			return y<z?y:z;		
	}
	
	

}
