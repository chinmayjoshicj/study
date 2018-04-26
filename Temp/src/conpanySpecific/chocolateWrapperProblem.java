package conpanySpecific;

public class chocolateWrapperProblem
{
	public static void main(String[] args) 
	{
		int money=20;
		int price=3;
		int wrap=5;
		
		int count=0;
		int remWrap=0;
		
		int Chocolates=money/price;
		count=Chocolates;
		
		Chocolates=Chocolates/wrap;
		
		while(Chocolates+remWrap>=wrap)
		{
			int tempChoc=Chocolates;
			count+=Chocolates;
			Chocolates=((Chocolates+remWrap)/wrap);
			remWrap=tempChoc%wrap;
		}
		count+=Chocolates;
		System.out.println(count);
	}
}
