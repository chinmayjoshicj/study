package ConpanySpecific;

import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class RowerProblem implements Callable<String>
{
	private String pos;
	private char[] route;

	public RowerProblem(String pos1, char[] route2) {
		this.pos = pos1;
		this.route = route2;
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException 
	{
		System.out.println("Enter the top right Coordinates of Plateau");
		Scanner sc= new Scanner(System.in);
		String topRight=sc.nextLine();
		int xTopRight=Integer.parseInt(topRight)%10;
		int yTopLeft=Integer.parseInt(topRight)-xTopRight%10;
		//System.out.print(drive()+"\n"+drive());
	
		ExecutorService service = Executors.newCachedThreadPool();
		System.out.println("Enter position of rover1");
		String pos1=sc.nextLine();
		System.out.println("Enter route1");
		char route1[]=sc.nextLine().toCharArray();
		RowerProblem rowerProblem1 = new RowerProblem(pos1, route1);
		System.out.println("Enter position of rover2");
		String pos2=sc.nextLine();
		System.out.println("Enter route2");
		char route2[]=sc.nextLine().toCharArray();
		RowerProblem rowerProblem2 = new RowerProblem(pos2, route2);
		
		Future<String> f1 = service.submit(rowerProblem1);
		Future<String> f2 = service.submit(rowerProblem2);
		String string1 = f1.get();
		String string2 = f1.get();
		
		System.out.println(string1+"--"+string2);
	
	}
	
	private String drive() 
	{
		
		int xPos=Integer.parseInt(""+pos.toCharArray()[0]);
		int yPos=Integer.parseInt(""+pos.toCharArray()[1]);
		int head = 0;
//		System.out.println("Initially x and y "+xPos+","+yPos);
		if (pos.toCharArray()[2]=='E' || pos.toCharArray()[2]=='e')
		{
			head=1;
		}
		if (pos.toCharArray()[2]=='W' || pos.toCharArray()[2]=='w')
		{
			head=2;
		}
		if (pos.toCharArray()[2]=='N' ||pos.toCharArray()[2]=='n')
		{
			head=3;
		}
		if (pos.toCharArray()[2]=='S' || pos.toCharArray()[2]=='s')
		{
			head=4;
		}
		
		int countX=xPos;
		int countY=yPos;
		for (int i = 0; i < route.length; i++) {
			if (route[i] == 'M') {
				if (head == 1) {
					xPos++;
					/*System.out.println("Pointing East");
					System.out.println("x and y "+xPos+","+yPos);*/
					continue;
				}
				if (head == 2) {
					xPos--;
					/*System.out.println("Pointing West");
					System.out.println("x and y "+xPos+","+yPos);*/
					continue;
				}
				if (head == 3) {
					yPos++;
					/*System.out.println("Pointing North");
					System.out.println("x and y "+xPos+","+yPos);*/
					continue;
				}
				if (head == 4) {
					yPos--;
					/*System.out.println("Pointing South");
					System.out.println("x and y "+xPos+","+yPos);*/
					continue;
				}
			}
			if (route[i] == 'L') {
				if (head == 1) {
					head = 3;
					/*System.out.println(getPosition(head));
					System.out.println("x and y "+xPos+","+yPos);*/
					continue;
				}
				if (head == 2) {
					head = 4;
					/*System.out.println(getPosition(head));
					System.out.println("x and y "+xPos+","+yPos);*/
					continue;
				}
				if (head == 3) {
					head = 2;
					/*System.out.println(getPosition(head));
					System.out.println("x and y "+xPos+","+yPos);*/
					continue;
				}
				if (head == 4) {
					head = 1;
//					System.out.println(getPosition(head));
//					System.out.println("x and y "+xPos+","+yPos);
					continue;
				}
			}
			if (route[i] == 'R') {
				if (head == 1) {
					head = 4;
					/*System.out.println(getPosition(head));*/
					continue;
				}
				if (head == 2) {
					head = 3;
					/*System.out.println(getPosition(head));*/
					continue;
				}
				if (head == 3) {
					head = 1;
					/*System.out.println(getPosition(head));*/
					continue;
				}
				if (head == 4) {
					head = 2;
					/*System.out.println(getPosition(head));*/
					continue;
				}
			}
		}
		return xPos+""+""+yPos+""+getPosition(head);
	}

	private static String getPosition(int head) 
	{
		String direction="N";
		if (head == 1) {
			direction="E";
		}
		if (head == 2) {
			direction="W";
		}
		if (head == 3) {
			direction="N";
		}
		if (head == 4) {
			direction="S";
		}
		return direction;
	}

	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
