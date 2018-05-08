package conpanySpecific;

import sorting.countingSquares;

public class RatMazeProblem {

	
	/*Count number of ways to reach destination in a Maze
	Given a maze with obstacles, count number of paths to reach rightmost-bottommost cell from topmost-leftmost cell. A cell in given maze has value -1 if it is a blockage or dead end, else 0.

	From a given cell, we are allowed to move to cells (i+1, j) and (i, j+1) only.
	*/
	public static void main(String[] args)
	{
		int maze[][] = {{0, 0, 0, 0},
                		{0, 0, -1, 0},
                		{0, 0, 0, 0},
                		{0, 0, -1, 0}};
		
		int flag=0;
		
		for (int i = 0; i < maze.length; i++) 
		{
			for (int j = 0; j < maze.length; j++) 
			{
				if (i==0)
				{
					if (maze[i][j]!=-1) {
						maze[i][j]=1;
					}
				}
				else if (j==0)
				{
					if (maze[i][j]!=-1 && maze[i-1][j]!=-1) {
						maze[i][j]=1;
					}
				}
				else if(maze[i][j]!=-1)
				{
						maze[i][j]=(maze[i-1][j]>0?maze[i-1][j]:0)+(maze[i][j-1]>0?maze[i][j-1]:0);
				}
			}
			
		}
		for (int j = 0; j < maze.length; j++) 
		{
			for (int j2 = 0; j2 < maze.length; j2++) {
				System.out.print(maze[j][j2]+" ");
			}
			System.out.println();
		}
	}

}
