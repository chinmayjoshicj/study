package threads;

public class Aaa extends Thread
{  
	public void run()
	{  
		System.out.println("thread is running...");  
	}  
	public static void main(String args[]) throws InterruptedException
	{  
		Aaa t1=new Aaa();  
		Aaa t2=new Aaa();
		Aaa t3=new Aaa();
		t1.start();  
//		sleep(1000);
		t2.start(); 
		t3.start(); 
	 }  
}


class Parent {
	protected static void sample(){
		System.out.println("parent"); 
	}
}

class Child extends Parent{
	public static void sample(){
		System.out.println("child"); 
	}
	public static void main(String args[]){ 
		Parent p = new Child();
		p.sample();
	} 
}
