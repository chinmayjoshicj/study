package linkedList;
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
public class CreationOfLinkedList 
{
	Node head;
	public void createLinkedList(int data) 
	{
		Node newNode= new Node(data);
		newNode.next=head;
		head=newNode;
	}
	public void traverse(Node head2) 
	{
		while (head2!=null) {
			System.out.println(head2.data);
			head2=head2.next;
		}
	}
	public static void main(String[] args) 
	{
		CreationOfLinkedList c=new CreationOfLinkedList();
		c.createLinkedList(0);
		c.createLinkedList(1);
		c.createLinkedList(2);
		c.createLinkedList(3);
		c.createLinkedList(4);
		
		c.traverse(c.head);
	}

}
