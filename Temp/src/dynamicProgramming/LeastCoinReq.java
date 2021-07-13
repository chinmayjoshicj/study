	package dynamicProgramming;

public class LeastCoinReq {

	public static void main(String[] args) {
		int coins[]= {1,2,5};
		int amount= 5;
		
		System.out.println(leastCoint(coins,amount));

	}
	private static int leastCoint(int[] coins, int amount) {
		if (amount<1) {
			return 0;
		}
		return changeCoinsTopDown(amount,new int[amount+1],coins);
		
	}
	private static int changeCoinsTopDown(int amountRemaining,int dp[], int[] coins) {
		if (amountRemaining==0) {
			return 0;
		}
		if (amountRemaining<0) {
			return -1;
		}
		if (dp[amountRemaining]!=0) {
			return dp[amountRemaining];
		}
		int mininum=Integer.MAX_VALUE;
		for (int coin :coins) {
			int changeResult=changeCoinsTopDown(amountRemaining-coin, dp, coins);
			if (changeResult>=0 && changeResult<mininum) {
				mininum=1+changeResult;
			}
		}
		dp[amountRemaining]=(mininum==Integer.MAX_VALUE)?-1:mininum;
		return dp[amountRemaining];
		
	}

}
