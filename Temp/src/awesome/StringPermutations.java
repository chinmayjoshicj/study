package awesome;

public class StringPermutations 
{
	static int a=0;	
	public static void main(String[] args) 
	{
		String s="ABC";
		System.out.println(permute(s,0,s.length()-1));
	}
	private static String permute(String s, int left, int right)
	{
		if (left==right) 
		{
			System.out.println("The required ----------------------->"+s);
		}
		else
		{
			for (int i = left; i <= right; i++) 
			{
				s=swap(s,left,i);
				permute(s, left+1, right);
				s=swap(s,left,i);
				System.out.println("End "+ a++);
			}
		}
		return "";
	}
	private static String swap(String s, int left, int i) 
	{
		char temp;
		char[] charArray=s.toCharArray();
		System.out.println(s);
		System.out.println("Swapping "+charArray[left]+" and "+charArray[i]);
		temp=charArray[left];
		charArray[left]=charArray[i];
		charArray[i]=temp;
		return String.valueOf(charArray);
	}

}
