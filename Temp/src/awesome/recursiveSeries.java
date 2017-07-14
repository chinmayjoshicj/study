package awesome;

public class recursiveSeries {
	
	public static int a (int n, int i) {
		int prod=1;
		if(n==1)
			return n;
		else if(i>n)
		{
			return 1;
		}
		else
		{
			int k=i;
			for (int j = i; j >0 ;j--) {
				prod=prod*k++;
			}
			a(n,i++);
			return prod;	
		}
	}

	public static void main(String[] args)
	{
		System.out.println(a(4,1));
		/*int n=5;
		int k=1;
		for (int i = 1; i <= n; i++) 
		{
			int prod = 1;
			if(n==1)
			{
				prod=1;
				System.out.println(prod);
			}
			else
			{
				for (int j = i; j>0; j--) 
				{
					
					prod= prod *(k++);
				}
			}
			System.out.println(prod);
		}
		*/
	}

}
