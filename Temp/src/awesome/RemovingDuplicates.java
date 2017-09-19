package awesome;

public class RemovingDuplicates 
{
	static String a="Pradeed";
	public static void main(String[] args) 
	{
		RemoveDup(a);
		System.out.println(a);
	}

	private static String RemoveDup(String a) 
	{
		char b[]=a.toCharArray();
		for (int i = 0; i < a.length()-1; i++)
		{
			if (b[i]==b[i+1])
			{
				System.out.println(a.charAt(i)+" "+a.charAt(i+1));
				System.out.println(b[i]+" "+b[i+1]);
				swap(i,i+1);
			}
		}
		return b.toString();
	}
	private static void swap(int i, int j) 
	{
		for (int j2 = j; j2 <= a.length(); j2++) 
		{
			System.out.println(a.charAt(i)+" "+a.charAt(j2));
			a.replace(a.charAt(i), a.charAt(j2));
			i++;
		}
	}
}
