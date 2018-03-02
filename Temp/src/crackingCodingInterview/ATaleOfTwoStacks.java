package crackingCodingInterview;

import java.util.Scanner;
import java.util.Stack;

public class ATaleOfTwoStacks 
{
	public static class MyQueue<T>
	{
        /*Stack<T> stackNewestOnTop = new Stack<T>();
        Stack<T> stackOldestOnTop = new Stack<T>();

        public void enqueue(T value)
        { // Push onto newest stack
        	while (!stackOldestOnTop.isEmpty()) 
        	{
				stackNewestOnTop.push(stackOldestOnTop.pop());
			}
            stackNewestOnTop.push(value);
        }
        public T peek() 
        {
        	while(!stackNewestOnTop.isEmpty())
        	{
        		stackOldestOnTop.push(stackNewestOnTop.pop());
			}
        	return stackOldestOnTop.peek();
        }
        public T dequeue() 
        {
        	while(!stackNewestOnTop.isEmpty())
        	{
        		stackOldestOnTop.push(stackNewestOnTop.pop());
        	}
        	if (!stackOldestOnTop.isEmpty()) {
        		return stackOldestOnTop.pop();
			}
			return null;
        }*/
		
		Stack<T> stackNewestOnTop = new Stack<T>();
        Stack<T> stackOldestOnTop = new Stack<T>();
        
        public void enqueue(T value)
        { 
        	while (!stackOldestOnTop.isEmpty()) 
        	{
				stackNewestOnTop.push(stackOldestOnTop.pop());
			}
             stackNewestOnTop.push(value);
        }
        public T peek() 
        {
            if(stackNewestOnTop!=null){ 
                return stackNewestOnTop.peek();
         } 
            return null;
        }
        
        public T dequeue() {
            T current=null;
            if(stackNewestOnTop.size()<0 ||stackOldestOnTop.size()<0){
                return current;
            }
          while( stackNewestOnTop.size()>0){
               stackOldestOnTop.push(stackNewestOnTop.pop());
           }     
            while( stackOldestOnTop.size()>0){
               current=stackOldestOnTop.pop();
           }
          return current;
         }
    }
	
	public static void main(String[] args)
	{
		MyQueue<Integer> queue = new MyQueue<Integer>();
        
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        
        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();
	}
}
