package stringManupulations;

public class MarsExploration
{
	public static void main(String[] args) 
	{
		String str="SOSSPSSQSSOR";
		int count=0;
		for (int i = 0; i < str.length(); i=i+3) 
		{
			if (str.charAt(i)=='S' && str.charAt(i+1)=='O' && str.charAt(i+2)=='S') 
			{
				continue;
			}
			else
			{
				if (str.charAt(i)!='S') 
				{
					count++;
				}
				if(str.charAt(i+1)!='O') 
				{
					count++;
				}
				if (str.charAt(i+2)!='S') 
				{
					count++;
				}
			}
		}
		System.out.println(count);
	}

}
