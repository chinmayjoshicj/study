package threads;

public class HelloThread extends Thread
{

	@Override
	public void run() 
	{
			System.out.println("Hello from "+Thread.currentThread().getName()+" created by extending a Thread!");
	}
	
}
