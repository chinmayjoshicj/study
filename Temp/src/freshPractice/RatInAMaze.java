package freshPractice;

public class RatInAMaze {

	public static void main(String[] args) {
		int arr[][] = 
			{   { 1, 1, 1, 0, 1 },
				{ 1, 1, 0, 1, 0 }, 
				{ 0, 1, 1, 1, 0 }, 
				{ 1, 0, 0, 1, 0 }, 
				{ 1, 1, 1, 1, 0 }};

		int sol[][] = new int[arr.length][arr[0].length];
			System.out.println(RatInAMazeUtils(arr,0,0,sol));
			for (int i = 0; i < sol.length; i++) {
				for (int j = 0; j < sol[0].length; j++) {
					System.out.print(sol[i][j]); 
				}
				System.out.println();
			}

	}
	private static boolean RatInAMazeUtils(int arr[][],int x,int y,int sol[][]) {
		
		if(x==arr.length-1 && y==arr[0].length-1 && arr[x][y]==1) {
			sol[x][y]=1;
			return true;
		}
		
		if(checkIfValidPosition(x,y,arr.length,arr.length,arr)) {
			sol[x][y]=1;
			
			if(RatInAMazeUtils(arr,x+1,y,sol)) {
				return true;
			}
			if(RatInAMazeUtils(arr,x,y+1,sol)) {
				return true;
			}
			sol[x][y]=0;
			return false;
		}
		return false;
	}
	private static boolean checkIfValidPosition(int x, int y, int length, int breadth, int[][] arr) {
		
		if(x>=0 && x<length && y>=0 && y<breadth
				 && arr[x][y]==1) {
			return true;
		}
		else
			return false;
	}

}
