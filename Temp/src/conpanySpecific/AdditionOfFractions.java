package conpanySpecific;

public class AdditionOfFractions {

	public static void main(String[] args)
	{
		int n1=3;
		int d1=4;
		int n2=5;
		int d2=6;
		
		int lcm=findLCM(d1,d2);
		
		int finalNum=(n1*(lcm/d1))+(n2*(lcm/d2));
		System.out.println(finalNum+"/"+lcm);
		
	}
	static int gcd(int a, int b)
	{
		// Everything divides 0 
		if (a == 0 || b == 0)
			return 0;
		
		// base case
		if (a == b)
			return a;
		
		// a is greater
		if (a > b)
			return gcd(a-b, b);
		return gcd(a, b-a);
	}

	private static int findLCM(int d1, int d2) 
	{
		return d1*d2/gcd(d1,d2);
	}
}
