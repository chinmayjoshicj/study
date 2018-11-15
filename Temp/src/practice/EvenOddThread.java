package practice;
class print
{
	int number;
	public void printEven()
	{
		while (number<=10) {
			
			synchronized (this) {
				while (number%2!=0 ) {
					try {
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println("Even: "+number++);
				notify();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	public void printOdd()
	{
		while (number<=10) {
			
			synchronized (this) {
				while (number%2==0) {
					try {
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println("Odd: "+number++);
				notify();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
public class EvenOddThread {

	public static void main(String[] args) 
	{
		print p= new print();
		Thread t1= new Thread(new Runnable() {
			
			@Override
			public void run() {
				p.printEven();
			}
		});
		Thread t2= new Thread(new Runnable() {
			
			@Override
			public void run() {
				p.printOdd();
			}
		});
		
		t1.start();
		t2.start();
	}

}
