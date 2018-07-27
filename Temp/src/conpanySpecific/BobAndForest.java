package conpanySpecific;

public class BobAndForest 
{
	public static void main(String[] args) 
	{
		int count=0;
		char[][] board = new char[][]
		{
			  { '*','*','K','P','N','I','I','O'},
			  { '*','*','*','D','D','T','B','S'},
			  { 'A','U','N','B','O','C','Z','V'},
			  { 'X','M','H','V','Y','G','R','Q'},
			  { 'E','O','*','*','F','K','A','L'},
			  { 'U','E','*','*','S','K','S','W'},
			  { '*','*','*','*','Y','*','*','H'},
			  { '*','*','*','*','S','*','*','O'},
			  { '*','*','*','*','T','Z','K','T'},
			  { 'D','R','F','S','S','Z','K','Y'}};
		
		int k=3;
//		findSquare(row,column);
		for (int row = 0; row < 9-k+1; row++)
		{
			for (int column = 0; column < 8-k+1; column++) 
			{
				int noOfCells=0;
				for (int i = row; i < k+row; i++)
				{
					for (int j = column; j < k+column; j++)
					{
						if (board[i][j]=='*')
						{
							System.out.println("board["+i+"]["+j+"] Yes");
							noOfCells++;
						}
						else
						{
							System.out.println("board["+i+"]["+j+"] No");
						}
					}
				}
				if (noOfCells==k*k) 
				{
					System.out.println("Row: "+row+"Column: "+column);
					count++;
				}
				System.out.println();
		}
		System.out.println(count);
	}
}
}
