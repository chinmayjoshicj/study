package practice;

import java.util.Hashtable;

public class StopWatch {
	private static  Hashtable<String, Long> tasks = new Hashtable<String, Long>();

	public static void main(String[] args) throws InterruptedException {
		startWatch("Global");
		Thread.sleep(20);
//		System.out.println(tasks.size());
		stopWatch("Global");
		System.out.println(tasks.size());
	}

	private static void startWatch(String key) {
		tasks.put(key, System.currentTimeMillis());
		System.out.println("Starting stop watch "+System.currentTimeMillis());		
	}
	private static void stopWatch(String key) {
//		tasks.put(key, System.currentTimeMillis());
		System.out.println("Stoping stop watch "+System.currentTimeMillis());		
		System.out.println("Total time "+((long)System.currentTimeMillis()-tasks.remove(key)));		
	}
}
