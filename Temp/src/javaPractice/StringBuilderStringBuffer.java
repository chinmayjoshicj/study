package javaPractice;

public class StringBuilderStringBuffer extends Thread
{
	StringBuffer b=new StringBuffer("Ravi");
	StringBuilder a= new StringBuilder("Chinmay");
	
	public void transaction() 
	{
		
	}
	public static void main(String[] args) 
	{
		StringBuilderStringBuffer c= new StringBuilderStringBuffer();
		
		Thread a1=new Thread(c);
		a1.setName("First");
		a1.start();
		Thread a2=new Thread(c);
		a2.setName("Second");
		a2.start();
	}
	@Override
	public void run() 
	{
		if (Thread.currentThread().getName().equals("First"))
		{
			while(true)
			{
				b.delete(0, 1);
				b.append("s");
			}
		}
		else
			System.out.println(b+":"+Thread.currentThread().getName());
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Hello from a thread!"+ Thread.currentThread().getName());
	}

}
