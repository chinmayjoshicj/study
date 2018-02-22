package recursion;

public class fibo {

	//static int n=7;
	public static int compute(int n) {
		
		if (n==0)
		{
			return 0;
		}
		if (n==1)
		{
			return 1;
		}
		return compute(n-1)+compute(n-2);
		
	}
	public static void main(String[] args) {
		//System.out.print("0 1 ");
		System.out.println(compute(7));		
	}
}
