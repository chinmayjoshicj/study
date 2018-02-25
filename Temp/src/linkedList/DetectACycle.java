package linkedList;

import java.util.HashSet;

/*class Node
{
	int data;
	Node next;
	
	Node(int data)
	{
		this.data=data;
		next=null;
	}
}*/
public class DetectACycle {

	static Node head=new Node(1);
	public void createLinkedList(int data) 
	{
		Node newNode= new Node(data);
		newNode.next=head;
		head=newNode;
	}
	public static void main(String[] args) 
	{
		DetectACycle c=new DetectACycle();
		c.createLinkedList(0);
		c.createLinkedList(1);
		c.createLinkedList(2);
		c.createLinkedList(3);
		c.createLinkedList(4);
		System.out.println(hasCycle(head));
	}

	private static boolean hasCycle(Node head)
	{
		// TODO Auto-generated method stub
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
		return false;
	}

}
