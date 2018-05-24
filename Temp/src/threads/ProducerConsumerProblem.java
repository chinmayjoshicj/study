package threads;

import java.util.ArrayList;

class Producer extends Thread {
	ArrayList<Integer> a;
	int capacity = 2;

	public Producer(ArrayList<Integer> a) {
		this.a = a;
	}

	public void run() {
		try {
			this.produce();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void produce() throws InterruptedException {
		while (true) {
			synchronized (a) {
				if (a.size() == capacity) {
					System.out.println("Producer is waiting...");
					a.wait();
				}
				a.add(1);
				System.out.println("Producer produced 1 and size of buffer is " + a.size());
				a.notify();
				Thread.sleep(1000);
			}
		}
	}
}

class Consumer extends Thread {
	ArrayList<Integer> a;

	public Consumer(ArrayList<Integer> a) {
		this.a = a;
	}

	public void run() {
		this.consume();
	}

	private void consume() {
		while (true) {
			synchronized (a) {
				while (a.isEmpty()) {
					try {
						System.out.println("Consumer is waiting...");
						a.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				a.remove(a.size() - 1);
				System.out.println("Consumer consumed 1 and size of buffer is " + a.size());
				a.notify();
			}
		}
	}
}

public class ProducerConsumerProblem {
	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<>();

		Producer p = new Producer(a);
		Consumer c = new Consumer(a);

		p.start();

		c.start();
	}
}
