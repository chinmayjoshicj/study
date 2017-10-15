package dynamicProgramming;

public class MinCostOfTravelDynamicProgramming 
{

	
	public static void main(String[] args) 
	{
		int cost[][]={{	0, 10, 75, 94},
				  	  {-1, 	0, 35, 50},
				  	  {-1, -1,  0, 80},
				  	  {-1, -1, -1, 0}};
		
		System.out.println(calculateMinCostOftravel(cost,0,3));
	}

	private static int calculateMinCostOftravel(int[][] cost, int s, int d) 
	{
		int minCost[]=new int[cost.length];
		minCost[0]=cost[0][0];
		minCost[1]=cost[0][1];
		
		for (int i = 2; i < cost.length; i++) 
		{
			minCost[i]=cost[0][i];
			for (int j = 1; j < i; j++) 
			{
				if (minCost[i]>minCost[j]+cost[j][i])
				{
					minCost[i]=minCost[j]+cost[j][i];
				}
			}
		}
		for (int is : minCost)
		{
			System.out.print(is+" ");
		}
		System.out.println();
		return minCost[d];
	}

}
