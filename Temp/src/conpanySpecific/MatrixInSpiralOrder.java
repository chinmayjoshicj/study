package conpanySpecific;

public class MatrixInSpiralOrder 
{
	public static void main(String[] args) 
	{
		char[][] board = new char[][]{
			
			//rs----re 
			
			  { 'V', 'L','K','P','N','I','I','O','R','V','B','S','N','Q','U'},
			  { 'G','A','G','D','D','T','B','S','K','F','B','X','R','F','C' },
			  { 'A','U','N','B','O','C','Z','V','X','Y','K','P','V','X','R' },
			  { 'X','M','H','V','Y','G','R','Q','W','H','U','K','Z','M','D' },
			  { 'E','O','K','O','F','K','A','L','R','T','C','G','H','Z','X' },
			  { 'U','E','Z','H','S','K','S','W','W','A','L','Z','D','G','A' },
			  { 'R','A','T','K','Y','D','Z','H','Y','V','S','U','K','I','Q' },
			  { 'E','X','U','O','S','Q','X','O','T','A','S','G','V','G','P' },
			  { 'Q','R','S','C','T','Z','K','T','Y','M','I','U','N','I','F' },
			  { 'D','R','F','S','S','Z','K','Y','T','E','Z','Z','M','A','R' }};
			  
			  int rs=0;
			  int re=15;
			  int cs=0;
			  int ce=10;
			  
			  int iterator=0;
			  
			  while(rs<re && cs<ce)
			  {
				  while(iterator<re)
				  {
					  System.out.print(board[rs][iterator]+" ");
					  iterator++;
				  }
				  System.out.println();
				  rs++;
				  iterator=rs;
				  while (iterator<ce) {
					System.out.print(board[iterator][ce]+" ");
					iterator++;
				}
			  }
	}
}
