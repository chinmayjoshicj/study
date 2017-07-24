package recursion;

public class TowerOfHanoi {

	public static void main(String[] args)
	{
		char s = 's';
		char e = 'e';
		char d = 'd';
		int n=4;
		
		towerOfHanoiSolution(s,d,e,n);
	}

	private static void towerOfHanoiSolution(char s, char d, char e, int n) 
	{
		if (n<=0)
		{
			return;
		}
			towerOfHanoiSolution(s, e, d, n-1);
			System.out.println("Move Disk-"+n+" From "+s+" To "+d);
			towerOfHanoiSolution(e, d,s, n-1);
	}

}
