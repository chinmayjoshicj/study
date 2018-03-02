package crackingCodingInterview;

class Node
{
	int data;
	Node next;
	
	Node(int data)
	{
		this.data=data;
		next=null;
	}
}
public class DetectACycle {

	static Node head=new Node(1);
	public Node createLinkedList(int data) 
	{
		Node newNode= new Node(data);
		newNode.next=head;
		return head=newNode;
	}
	public static void main(String[] args) 
	{
		DetectACycle c=new DetectACycle();
		
		/*c.createLinkedList(0);
		c.createLinkedList(1);
		c.createLinkedList(2);
		Node a=c.createLinkedList(3);
		Node b=c.createLinkedList(4);
		b.next=a;*/
		
		/*head.next=new Node(1);
		head.next.next=new Node(2);
		head.next.next.next=new Node(3);
		head.next.next.next.next=new Node(4);
		head.next.next.next.next.next=head.next.next.next.next;*/
		
		System.out.println(hasCycle(head));
	}

	private static boolean hasCycle(Node head)
	{
		 
		/*Solution 1 using floyd cycle*/
		
		if (head==null || head.next==null)
		{
			return false;
		}
		Node slow=head;
		Node fast=head.next;
		while(true)
		{
			if (slow==null || fast==null) {
				return false;
			}
			slow=slow.next;
			if (fast.next!=null)
			{
				fast=fast.next.next;
			}
			else
				return false;
			
			if (slow==fast) {
				return true;
			}
		}
		
	}
}
		
		/*
		 * Solution 2
		 * 
		 * // TODO Auto-generated method stub
		HashSet<Node> a=new HashSet<>();
		while(head!=null)
		{
			if (a.contains(head)) 
			{
				return true;
			}
			else
				a.add(head);
			
			head=head.next;
		}
		return false;*/
//}
