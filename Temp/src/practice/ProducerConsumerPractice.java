package practice;

import java.util.ArrayList;import threads.statesOfThread;

class Executor
{
	ArrayList<Integer> list= new ArrayList<>();
	int capacity=2;
	int count=0;
	
	public void produce() throws InterruptedException 
	{
		while (true)
		{
			synchronized (this)
			{
				while (list.size()==capacity) {
					wait();
				}
				System.out.println("Adding "+count);
				list.add(count++);
				notify();
			}
		}
	}

	public void consume() throws InterruptedException 
	{
		while (true)
		{
			synchronized (this)
			{
				while (list.size()==0) {
					wait();
				}
				System.out.println("deleting "+list.remove(list.size()-1));
				count--;
				notify();
			}
		}
	}
}
public class ProducerConsumerPractice 
{
	static Executor pc=new Executor();
	public static void main(String args[]) {
		Thread t1= new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					pc.produce();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		Thread t2= new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					pc.consume();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		t1.start();
		t2.start();
	}
}
