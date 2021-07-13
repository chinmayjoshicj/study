package practice;

import java.util.ArrayList;

import javax.swing.plaf.SliderUI;

public class ProducerConsumerPractice {

	ArrayList<Integer> ll = new ArrayList<Integer>();
	int count = 0;
	static ProducerConsumerPractice pc= new ProducerConsumerPractice();
	public static void main(String args[]) {

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					pc.produce();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
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
	}

	public void produce() throws InterruptedException {
		while (true) {
			synchronized (this) {
				if(ll.size()==5) {
					wait();
				}
				else {
					System.out.println("Producing "+count);
					ll.add(count++);
					Thread.sleep(1000);
					notify();
				}
			}
		}
	}

	public void consume() throws InterruptedException{
		while (true) {
			synchronized (this) {
				if(ll.size()==0) {
					wait();
				}else {
					System.out.println("Removing "+ll.get(ll.size()-1));
					ll.remove(ll.size()-1);
					count--;
					Thread.sleep(1000);
					notify();
				}
			}
		}
	}
}
