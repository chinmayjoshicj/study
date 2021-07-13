package freshPractice;

//Any number of times
public class BuyAndSellStocksPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int price[]= {100,180,260,310,40,535,695};
		System.out.println(maxProfit(price,0, price.length-1));
	}

	private static int maxProfit(int[] price, int start, int end) {
		int max_profit=0;
		if(start<end)
		{
			for (int i = start; i <end; i++) {
				for (int j = i+1; j <=end; j++) {
					int currProfit=price[j]-price[i]+maxProfit(price, start, i-1)+maxProfit(price, j+1, end);
					max_profit=Math.max(max_profit, currProfit);
				}
			}
		}
		
		return max_profit;
	}
}
