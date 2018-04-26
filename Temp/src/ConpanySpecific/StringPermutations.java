package ConpanySpecific;

public class StringPermutations {

	static String s="abc";
	public static void main(String[] args)
	{
		
		permute(s,0,s.length()-1);
	}

	private static void permute(String s, int l, int r) 
	{
		if (l==r)
		{
			System.out.println(s);
		}
		for (int i = l; i < r; i++) 
		{
			swap(l,i);
			permute(s, l, r);
			
		}
	}

	private static void swap(int l, int r) 
	{
		
	}

}
