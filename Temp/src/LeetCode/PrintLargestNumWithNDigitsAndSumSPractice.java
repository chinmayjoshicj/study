package leetCode;

public class PrintLargestNumWithNDigitsAndSumSPractice {

		// TODO Auto-generated method stub
		static int max=0;
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			int n=2;
			int sum=3;
			
			printLargestNumSumS(n,sum);
			System.out.println();
			System.out.println("CurrMax "+max);
		}

	private static void printLargestNumSumS(int n, int sum) {
		
		char c[]= new char[n];
		for (int i = 1; i <=9; i++) {
			c[0]=(char)(i+'0');
			printLargestNumSumSUtils(c, sum-i, n, 1);
		}
	}

	private static void printLargestNumSumSUtils(char[] c, int sum,int n, int index) {
		if(index>n || sum<0) {
			return;
		}
		if(index==n) {
			if(sum==0) {
				System.out.println(c);				
			}
			return;
		}
		for (int i = 0; i <=9; i++) {
			c[index]=(char)(i+'0');
			printLargestNumSumSUtils(c, sum-i, n, index+1);
		}
	}
}
