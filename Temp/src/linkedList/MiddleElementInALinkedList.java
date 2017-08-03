package linkedList;
class Node1
{
	int data;
	Node1 next;
	
	Node1(int data)
	{
		this.data=data;
		next=null;
	}
}
public class MiddleElementInALinkedList 
{
	public static void main(String[] args)
	{
		Node1 root= new Node1(1);
		root.next=new Node1(2);
		root.next.next=new Node1(3);
		root.next.next.next=new Node1(4);
		root.next.next.next.next=new Node1(5);
		root.next.next.next.next.next=new Node1(6);
		root.next.next.next.next.next.next=new Node1(7);
		
		System.out.println(findMiddleElement(root).data);
	}

	private static Node1 findMiddleElement(Node1 root) 
	{
		//By slow pointer Fast Pointer Concept
		Node1 slow=root;
		Node1 fast=root;
		/*while(fast!=null)//My Solution
		{
			fast=fast.next;
			if (fast!=null)
			{
				fast=fast.next;
				slow=slow.next;
			}
			else
				fast=null;
		}*/
		while(fast!=null && fast.next!=null)
		{
			fast=fast.next.next;
			slow=slow.next;
				if (slow!=null || fast!=null) 
				{
					if (slow==null)
					{
						System.out.println("Slow "+"Null"+"Fast "+fast.data);						
					}
					else if (fast==null) 
					{
						System.out.println("Slow "+slow.data+"Fast "+"Null");	
					}
					else
					{
						System.out.println("Slow "+slow.data+"Fast "+fast.data);
			    	}
				}
			}
			return slow;
	}

}
