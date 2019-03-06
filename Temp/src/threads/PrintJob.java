package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PrintJob implements Runnable {

	String name = "";

	public PrintJob(String name) {
		super();
		this.name = name;
	}

	public static void main(String[] args) {
		PrintJob[] jobs = { new PrintJob("A"), new PrintJob("B"), new PrintJob("C"), new PrintJob("D"),
				new PrintJob("E"), new PrintJob("F") };
		ExecutorService service = Executors.newFixedThreadPool(3);
		for (PrintJob job : jobs) {
			service.submit(job);
		}
		service.shutdown();
	}

	@Override
	public void run() {
		System.out.println(name + " Job Started by " + Thread.currentThread().getName());
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println(name + " Job Ended by " + Thread.currentThread().getName());
	}

}
