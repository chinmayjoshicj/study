package awesome;

public class reverse {

	public static void reverse(String name[], int len)
	{
		if(len>=name.length)
		{
			return;
		}
		else
		{
				reverse(name,len+1);
				System.out.println(name[len]);
		}
	}
	public static void main(String[] args) {
		String name="Chinmay";
		String a[]=name.split("");
		reverse(a,0);
	}
}
	