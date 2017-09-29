package stringManupulations;

/*Julius Caesar protected his confidential information by encrypting it in a cipher. 
Caesar's cipher rotated every letter in a string by a fixed number, , making it unreadable by his enemies.
Given a string, , and a number, , encrypt  and print the resulting string.*/

public class CaesarCipher 
{
	public static void main(String[] args) 
	{
		String str="Middle-Outz";
		StringBuffer b= new StringBuffer(str);
		
		String finalString=new String(str);
		int k=2;
		
		for (int i = 0; i < str.length(); i++)
		{
			if (str.charAt(i)>=65 && str.charAt(i)<=90) 
			{
				b.replace(i, i,((int)str.charAt(i)+k)+"");
			}
		}
		System.out.println(b.toString());
	}
}
