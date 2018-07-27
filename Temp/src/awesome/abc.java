package awesome;

public class abc 
{
	public static void main(String[] args) 
	{
		/*int i = Integer.parseInt("1001", 2);
		int mask = 9;

		System.out.println(Integer.toHexString(1212));

		System.out.println((i & mask) == 9);
	}*/
		System.out.println(Math.pow(2, 64));
		
		String a1="abc";
		String a2="abc";
		
		String a3=new String("abc");
		String a4=new String("abc");
		
		System.out.println();
		
		System.out.println(a1==a2);
		System.out.println(a1.equals(a2));
		
		System.out.println();
		
		System.out.println(a3==a4);
		System.out.println(a3.equals(a4));
	}
}
