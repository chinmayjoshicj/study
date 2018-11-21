package practice;

import java.util.ArrayList;

class Executor
{
	ArrayList<Integer> list= new ArrayList<>();
	int capacity=2;
	int count=0;
	public void produce() throws InterruptedException {
		while (true)
		{
			synchronized(this)
			{
				if (list.size()<capacity) {
					System.out.println("Adding "+count);
					list.add(count++);
					notify();
					Thread.sleep(2000);
				}
				else
					wait();
			}
		}
	}
	public void consume() throws InterruptedException {
		while (true)
		{
			synchronized(this)
			{
				if (list.size()>0) {
					System.out.println("Removing "+list.get(list.size()-1));
					list.remove(list.size()-1);
					count--;
					notify();
					Thread.sleep(2000);
				}
				else
					wait();
			}
		}
	}
}
public class ProducerConsumerPractice 
{
	public static void main(String args[]) 
	{
		Executor e= new Executor();
		Thread t1= new Thread(new Runnable() {
			public void run() {
				try {
					e.consume();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		Thread t2= new Thread(new Runnable() {
			public void run() {
				try {
					e.produce();
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
