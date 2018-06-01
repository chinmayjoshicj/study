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
			  { '*','*','T','K','Y','*','*','H'},
			  { '*','*','*','*','S','*','*','O'},
			  { 'Q','R','*','*','T','Z','K','T'},
			  { 'D','R','F','S','S','Z','K','Y'}};
		
		int k=2;
//		findSquare(row,column);
		for (int row = 0; row < 8-k+1; row++)
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
		/*if (k > 8) return;
        
        // row number of first cell in 
        // current sub-square of size k x k
        for (int i = 0; i < 8-k+1; i++)
        {
             
            // column of first cell in current 
            // sub-square of size k x k
            for (int j = 0; j < 8-k+1; j++)
            {
                 
                // Calculate and print sum of 
                // current sub-square
                int sum = 0;
                for (int p = i; p < k+i; p++){
                    for (int q = j; q < k+j; q++){
                       System.out.print(board[p][q]+" ");
                    }System.out.println();}
                System.out.println();
                //System.out.print(sum+ " ");
            }
         
            // Line separator for sub-squares 
            // starting with next row
            System.out.println();
        }*/
	}
}
}
