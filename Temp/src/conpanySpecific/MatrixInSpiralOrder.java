package conpanySpecific;

public class MatrixInSpiralOrder 
{
	public static void main(String[] args) 
	{
		char[][] board = new char[][]{
			{ 'a','b','c','d'},
			{ 'l','m','n','e'},
			{ 'k','p','o','f'},
			{ 'j','i','h','g'}};
			
//			  { 'V', 'L','K','P','N','I','I','O','R','V','B','S','N','Q','U'},
//			  { 'G','A','G','D','D','T','B','S','K','F','B','X','R','F','C' },
//			  { 'A','U','N','B','O','C','Z','V','X','Y','K','P','V','X','R' },
//			  { 'X','M','H','V','Y','G','R','Q','W','H','U','K','Z','M','D' },
//			  { 'E','O','K','O','F','K','A','L','R','T','C','G','H','Z','X' },
//			  { 'U','E','Z','H','S','K','S','W','W','A','L','Z','D','G','A' },
//			  { 'R','A','T','K','Y','D','Z','H','Y','V','S','U','K','I','Q' },
//			  { 'E','X','U','O','S','Q','X','O','T','A','S','G','V','G','P' },
//			  { 'Q','R','S','C','T','Z','K','T','Y','M','I','U','N','I','F' },
//			  { 'D','R','F','S','S','Z','K','Y','T','E','Z','Z','M','A','R' }};
			  
			  int rs=0;
			  int re=3;
			  int cs=0;
			  int ce=3;
			  
			  int iterator=0;
			  
			  while(rs<=re && cs<=ce)
			  {
				 int cs_temp=cs;
				 int ce_temp=ce;
				 int rs_temp=rs;
				 int re_temp=re;
				 
				 while(cs_temp<=ce_temp) {
					 System.out.print(board[rs_temp][cs_temp]+" ");
					 cs_temp++;
				 }
				 System.out.println();
				 rs++;
				 rs_temp=rs;
				 cs_temp=cs;
				 
				 while(rs_temp<=re_temp) {
					 System.out.print(board[rs_temp][ce_temp]+" ");
					 rs_temp++;
				 }
				 System.out.println();
				 ce--;
				 ce_temp=ce;
				 rs_temp=rs;
				 
				 while(ce_temp>=cs_temp) {
					 System.out.print(board[re_temp][ce_temp]+" ");
					 ce_temp--;
				 }
				 System.out.println();
				 re--;
				 re_temp=re;
				 ce_temp=ce;
				 
				 while(re_temp>=rs_temp) {
					 System.out.print(board[re_temp][cs_temp]+" ");
					 re_temp--;
				 }
				 System.out.println();
				 cs++;
				 cs_temp=cs;
				 re_temp=re;
			  }
	}
}
