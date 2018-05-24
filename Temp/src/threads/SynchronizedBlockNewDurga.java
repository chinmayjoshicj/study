package threads;

class Display
{
	public void m1(String name)
	{
		;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;//thousand statements just to understand
		synchronized (this) 
		{
			for (int i = 0; i < 1; i++) 
			{
				System.out.print("Good Morning:");
				try 
				{
					Thread.sleep(1);
					System.out.println(name);
				} 
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}
		}
		;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;//thousand statements just to understand
	}
}
class SyncBlockDemo extends Thread
{
	Display d;
	String name;
	public  SyncBlockDemo(Display d,String name)
	{
		this.d=d;
		this.name=name;
	}
	public void run()
	{
		d.m1(name);
	}
}
public class SynchronizedBlockNewDurga 
{
	public static void main(String[] args)
	{
		Display d=new Display();
		SyncBlockDemo s1=new SyncBlockDemo(d, "Chinmay");
		SyncBlockDemo s2=new SyncBlockDemo(d, "Eshan");
		s1.start();
		s2.start();
	}
}