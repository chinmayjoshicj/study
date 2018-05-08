package regularExpression;

public class ValidateIPAddress 
{
	public static void main(String[] args)
	{
		String ip="10.184.1652.23";
		
		String sp[]=ip.split("\\.");
		
		for (int i = 0; i < sp.length; i++) 
		{
			System.out.println(sp[i]);
		}
		boolean flag=true;
		for (int j = 0; j < sp.length; j++) 
		{
			if (Integer.parseInt(sp[j])<0 || Integer.parseInt(sp[j])>255) {
				flag=false;
			}
		}
		System.out.println(flag);
	}
}
