package freshPractice;

public class MinimumTimeReqToRotAllOranges {
	
	public final static int R=3;
	public final static int C=5;
	
	static class Element{
		int x=0;
		int y=0;
		
		Element(int x, int y){
			this.x=x;
			this.y=y;
		}
	}
	
	static boolean isValid(int i, int j) {
		return (i>=0 && j>=0 && i<R && j<C);
	}
	
	static boolean isDelim(Element temp) {
		return (temp.x==-1 && temp.y==-1);
	}
	static boolean checkAll(int arr[][]) {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(arr[i][j]==1) {
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int arr[][] = { { 2, 1, 0, 2,1 },
						{ 0, 2, 1, 2,1 }, 
						{ 1, 2, 2, 2,1 }};
		
		

	}

}
