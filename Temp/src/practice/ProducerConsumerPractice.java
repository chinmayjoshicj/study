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

class Executor {
	ArrayList<Integer> list = new ArrayList<>();
	int count = 0;

	public void producer() throws InterruptedException {
		while (true) {
			synchronized (this) {
				while (list.size() > 6) {
					wait();
				}
				System.out.println("Adding " + count);
				list.add(count++);
				Thread.sleep(1000);
				notify();
			}
		}
	}

	public void consume() throws InterruptedException {
		while (true) {
			synchronized (this) {
				while (list.size() <= 0) {
					wait();
				}
				System.out.println("Removing " + --count);
				list.remove(list.size() - 1);
				Thread.sleep(1000);
				notify();
			}
		}
	}
}
