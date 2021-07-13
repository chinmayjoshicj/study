package freshPractice;

public class NumberOfPalandromeSubstrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="abccbc";
		boolean dp[][]= new boolean[s.length()][s.length()];
		int count=0;
		
		for (int g = 0; g < dp.length; g++) {
			for (int i = 0, j=g; j < dp.length && i< dp.length; i++, j++) {
				
				if(g==0) {
					dp[i][j]=true;	
				}
				else if(g==1) {
					if(s.charAt(i)==s.charAt(j)){
						dp[i][j]=true;
					}
				}
				else {
					if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]) {
						dp[i][j]=true;
					}
				}
				if(dp[i][j]==true) {
					count++;
				}
			}
			
		}
		System.out.println("count "+count);
	}

}
