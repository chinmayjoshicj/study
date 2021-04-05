package practice;

public class EvenOddThreadPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EvenOddPrinter printer= new EvenOddPrinter();
		Thread t1= new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					printer.even();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		Thread t2= new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					printer.odd();
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

class EvenOddPrinter
{
	int number=0;
	public void even() throws InterruptedException {
		while (true) {
			synchronized (this) {
				if (number%2==0) {
					System.out.println(number++);
					notify();
				}else
					wait();
			}
			Thread.sleep(1000);
		}
	}
    public void odd() throws InterruptedException {
    	while (true) {
			synchronized (this) {
				if (number%2!=0) {
					System.out.println(number++);
					notify();
				}else
					wait();
			}
			Thread.sleep(1000);
		}
	}
}
