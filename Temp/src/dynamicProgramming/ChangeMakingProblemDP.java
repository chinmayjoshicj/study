package dynamicProgramming;

//Incomplete
public class ChangeMakingProblemDP {

	static int arr[] = { 1, 5, 6 };
	static int amount = 5;

	public static void main(String[] args) {

		int dp[][] = new int[arr.length + 1][amount + 1];

		// Fill first row
		for (int i = 0; i < dp[0].length; i++) {

			if (i == 0) {
				dp[0][i] = 1;
				continue;
			}
			dp[0][i] = 0;
		}
		
		// Fill first column
		for (int i = 0; i < dp.length; i++) {
			dp[i][0] = 1;
		}

//		System.out.println(dp.length);
//		System.out.println(dp[0].length);
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				System.out.println(i+" "+j+" j-arr[i-1] "+(j-arr[i-1]));
				if(arr[i]>=0){
					dp[i][j]=dp[i-1][j]+dp[i][j-arr[i-1]];
				}else {
					dp[i][j]=dp[i-1][j];
				}
			}
			System.out.println();
		}
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
	}
}
