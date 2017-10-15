package threads;

public class CreatingThreads {
	public static void main(String[] args) 
	{
		//Creating a thread using a class that implements Runnable
		Thread t1=new Thread(new HelloRunnable());
		t1.start();
		
		//creating a thread using a class that extends Thread
		HelloThread t2= new HelloThread();
		t2.start();
		
		Runnable r1 = new Runnable()
        {
            @Override
            public void run()
            {
                //perform some work inside the thread
                System.out.println("Hello from "+
                        Thread.currentThread().getName()
                        + " NOT USING LAMBDA");
            }
        };
        //Create a runnable object using lambda notation
        Runnable r2 = () -> System.out.println("Hello from "
                + Thread.currentThread().getName()+" USING LAMBDA "
                + "notation");
        /*Create and start a thread using the first runnable object
         *This thread is also given a name in the arguments */
        Thread t3 = new Thread(r1, "Thread t1");
        t3.start();
        
        /*Create and start a second thread using the runnable object with 
         *lambda notation and not given a name */
        Thread t4 = new Thread(r2);
        
        t4.start();
	}
}
