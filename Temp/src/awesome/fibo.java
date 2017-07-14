package awesome;

public class fibo {

	//static int n=7;
	public static int compute(int n) {
		
		if(n==1)
		{
			return 1;
		}
		else if(n==0)
		{
			return 0;
		}		
		else
		{
			n=compute(n-2)+compute(n-1);
			System.out.print(n +" ");
			return n;
		}
	}
	public static void main(String[] args) {
		System.out.print("0 1 ");
		compute(7);		
	}
}
