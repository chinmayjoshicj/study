package dynamicProgramming;

public class MinCostOfTravelMemoization {

	static int memo[][]=null;
	public static void main(String[] args)
	{
		int cost[][]={{0, 10, 75, 94},
				  {-1, 0, 35, 50},
				  {-1,-1, 0,  80},
				  {-1,-1, -1,  0}};
		
		memo=new int[cost.length][cost.length];
	
		System.out.println(calculateMinCostOftravel(cost,0,3));
	}

	private static int calculateMinCostOftravel(int[][] cost, int s, int d) 
	{
		if (s==d || s==d-1)
		{
			memo[s][d]=cost[s][d];
			return memo[s][d];
		}
		memo[s][d]=cost[s][d];
		for (int i = s+1; i < d; i++)
		{
			int temp=calculateMinCostOftravel(cost, s, i)+calculateMinCostOftravel(cost, i, d);
			if (temp<memo[s][d])
			{
				memo[s][d]=temp;
			}
		}
		return memo[s][d];
	}

}
