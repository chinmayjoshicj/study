package practice;

import java.util.ArrayList;

public class ProducerConsumer {

	public static void main(String[] args) 
	{
		ProduceAndConsume p= new ProduceAndConsume();
		Thread t1= new Thread(new Runnable() {
			
			@Override
			public void run() 
			{
				try {
					p.produce();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		Thread t2= new Thread(new Runnable() {
			@Override
			public void run() 
			{
				try {
					p.consume();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		t1.start();
		t2.start();
	}
}
class ProduceAndConsume
{
	static ArrayList<Integer> list= new ArrayList<>();
	static int capacity=2;
	static Integer counter=0;
	
	public void produce() throws InterruptedException 
	{
		while(true)
		{
			synchronized (this)
			{
				if (list.size()<2)
				{
					list.add(counter);
					System.out.println("Added: "+counter++);
					notify();
					Thread.sleep(1000);
				}
				else
				{
					wait();
				}
			}
		}
	}
	public void consume() throws InterruptedException 
	{
		while(true)
		{
			synchronized (this)
			{
				if (list.size()>0)
				{
					System.out.println("consumed: "+list.get(list.size()-1));
					list.remove(list.size()-1);
					counter--;
					notify();
					Thread.sleep(1000);
				}
				else
				{
					wait();
				}
			}
		}
	}
}