package practice;

public class LLPractice 
{
	static List RootNode= new List(10); 
	public static void main(String[] args) 
	{
		CreateLL();
		printLL();
		
		findMiddleElement();
		System.out.println();
		System.out.print("After Duplicate Removal :");
		removeDuplicates();
		
		printLL();
		reverseLinkedList();
		System.out.println();
		System.out.print("Reversed Linked List: ");
		printLL();
	}
	private static void reverseLinkedList() 
	{
		List curr=RootNode;
		List prev=null;
		List next=null;
		
		while(curr!=null)
		{
			next=curr.next;
			curr.next=prev;
			prev=curr;
			curr=next;
		}
		RootNode=prev;
	}
	private static void removeDuplicates()
	{
		List prev=RootNode;
		List temp=RootNode.next;
		while(temp!=null)
		{
			if (temp.data==prev.data)
			{
				prev.next=temp.next;
			}
			prev=temp;
			temp=temp.next;
		}
	}
	private static void findMiddleElement()
	{
		List slow=RootNode;
		List fast=RootNode;
		
		while(fast!=null && fast.next!=null)
		{
			slow=slow.next;
			fast=fast.next.next;
		}
		System.out.print("Middle Element is :"+slow.data);
	}
	private static void printLL() 
	{
		List temp=RootNode;
		while(temp!=null)
		{
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
		System.out.println();
	}
	private static void CreateLL() 
	{
		addElement(20);
		addElement(20);
		addElement(30);
		addElement(100);
		addElement(40);
		addElement(50);
		addElement(60);
		
		System.out.print("Initially List: ");
		/*addElement(60);*/
	}
	private static void addElement(int i) {
		List node=RootNode;
		while (node.next!=null) {
			node=node.next;
		}
		List temp= new List(i);
		node.next=temp;
	}
}
