package javaPractice;

public class StaticVariableExample {

	static int a =10;
	static int b=0;
	public static void main(String[] args)
	{
	        StaticVariableExample s1 = new StaticVariableExample();
	        StaticVariableExample s2 = new StaticVariableExample();
	        System.out.println("s1.a value :"+s1.a);
	        System.out.println("s2.a value :"+s2.a);
	        //Change s1 a value alone
	        s1.a=20;
	        b=10;
	        System.out.println("s1.a value :"+s1.a);
	        System.out.println("s2.a value :"+s2.a);
	}

}
