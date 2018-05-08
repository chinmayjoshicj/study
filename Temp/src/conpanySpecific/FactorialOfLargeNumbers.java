package conpanySpecific;

public class FactorialOfLargeNumbers {

	static int size=Integer.MAX_VALUE;
	static int res[]=new int[size];
	public static void main(String[] args) 
	{
		int n=28;
		int res_size=1;
		for (int i = 2; i < n; i++)
		{
			multiply(i,res_size);
		}
	}
	private static void multiply(int i, int res_size)
	{
		int carry=0;
		for (int j = 0; j < res_size ; j++) {
			int prod=i*res[j]+carry;
			
			res[i]=prod%10;
			carry=prod/10;
		}
		while (carry==0)
		{
			res[res_size]=carry%10;
			carry=carry/10;
			res_size++;
		}
	}

}
