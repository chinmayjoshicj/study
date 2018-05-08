package conpanySpecific;

import java.util.LinkedList;
import java.util.Queue;

class PC
{
	Queue<Integer> q= new LinkedList<>();
	int capacity=2;
	
	public void produce() throws InterruptedException
	{
		int value=0;
		
		while (true) 
		{
			synchronized (this) 
			{
				if (q.size()==capacity)
				{
					wait();
				}
				q.add(value);
				System.out.println("Producer Produced "+value++);
				
				notify();
				Thread.sleep(1000);
			}
		}
	}

	public void consume() throws InterruptedException 
	{
		synchronized (this) 
		{
			if (q.size()==0)
			{
				wait();
			}
			System.out.println("Consumer Consumed "+ q.remove());
			
			notify();
			Thread.sleep(1000);
		}
	}
}

public class ProducerConsumer 
{
	public static void main(String[] args) throws InterruptedException 
	{
		PC pc=new PC();
		
		Thread t1 =new Thread(new Runnable() {
			
			@Override
			public void run() 
			{
				try {
					pc.produce();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		Thread t2=new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					pc.consume();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
	}
}
