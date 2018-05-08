package linkedList;

public class ReversingLinkedList 
{
	static Node head;

		public static void reverse(Node head1)
		{
			Node curr=head1;
			Node next=null;
			Node prev=null;
			
			while (curr!=null) {
				next=curr.next;
				curr.next=prev;
				prev=curr;
				curr=next;
			}		
			head=prev;
			
		}
		public void createLinkedList(int data) 
		{
			Node newNode= new Node(data);
			newNode.next=head;
			head=newNode;
		}
		public void traverse(Node head2) 
		{
			while (head2!=null) {
				System.out.print(head2.data+" ");
				head2=head2.next;
			}
			System.out.println();
		}
		private Node recursivelyReverse(Node head, Node prev) 
		{
			if (head==null)
			{
				this.head=prev;
				return null;
			}
			recursivelyReverse(head.next, head);
			head.next=prev;
			return head;
		}
		public static void main(String[] args) 
		{
			ReversingLinkedList c=new ReversingLinkedList();
			c.createLinkedList(4);
			c.createLinkedList(3);
			c.createLinkedList(2);
			c.createLinkedList(1);
			c.createLinkedList(0);
						
			//c.traverse(c.head);
			c.reverse(c.head);
			c.traverse(c.head);
			
			//Node a=c.recursivelyReverse(c.head,null);
			reverse(c.head);
			c.traverse(head);
		}
	
}
