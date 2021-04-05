package practice;

import java.util.ArrayList;

public class ProducerConsumerPractice {
	public static void main(String args[]) {

		Executor e = new Executor();
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					e.producer();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					e.consume();
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

class Executor extends Thread {
	ArrayList<Number> list = new ArrayList<Number>();
	int count = 0;
	int capacity = 2;

	public void producer() throws InterruptedException {
		while (true) {
			synchronized (this) {
				if(list.size()<capacity) {
					System.out.println("Adding "+count);
					list.add(count++);
					sleep(1000);
				}
				else {
					wait();
				}
			}
		}
	}

	public void consume() throws InterruptedException {
		while (true) {
			synchronized (this) {
				if(list.size()>0) {
					System.out.println("removing "+ list.get(list.size() - 1));
					list.remove(list.size()-1);
					count--;
					notify();
					sleep(1000);
				}
			}
		}
	}

}
