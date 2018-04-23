package queue;

import java.util.Scanner;

public class Queue {

	static int rear=-1;
	static int front=-1;
	static int a[]=new int[10];
	
	//1 enqueue
	//2 deqeque
	
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int inputs=sc.nextInt();
		for (int i = 0; i < inputs; i++) 
		{
			int request=sc.nextInt();
			if (request==1)
			{
				enqueue(sc.nextInt());
			}
			if (request==2)
			{
				dequeue();
			}
		}
	}

	private static void dequeue() {
		if (rear==-1 && front==-1) {
			System.out.println("Queue is empty");
		}
		else
			System.out.println(a[front--]);
	}

	private static void enqueue(int num) {
		if (a.length==front+1) {
			System.out.println("Queue is Full");
		}
		else
		{
			if(rear==-1 && front==-1)
			{
				rear++;
				front++;
				a[front]=num;
			}
			else
			{
				a[++front]=num;
			}
		}
	}

}
