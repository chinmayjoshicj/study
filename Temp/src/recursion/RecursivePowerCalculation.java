package recursion;

public class RecursivePowerCalculation {

	 static int output=1;
	public static void main(String[] args) 
	{
		int number=5;
		int n=3;
		 System.out.println(calculatePower(number,n));
	}

	private static int calculatePower(int number, int n) 
	{
		if (n==0)
		{
			return 1;
		}
		output=  number*calculatePower(number, n-1);
		return output;
	}

}
