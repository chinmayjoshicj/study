package practice;

import java.util.ArrayList;

class List
{
	int data;
	List next=null;
	
	public List(int data) 
	{
		super();
		this.data = data;
		this.next = null;
	}
}
public class LinkedList 
{
	static List head=new List(11);
	static ArrayList<Integer> a= new ArrayList<>();
	public static void main(String[] args)
	{
		addElement(11);
		addElement(11);
		addElement(21);
		addElement(43);
		addElement(43);
		addElement(60);
		/*printList();
		System.out.println();
		delete(2);
		printList();*/
		findMiddleElement();
		System.out.println();
		removeDuplicates();
		
		printList();
		reverseLinkedList();
	}
	private static void reverseLinkedList() 
	{
		List curr_node=head;
		List prev_node=null;
		List next_node=null;
		
		while (curr_node!=null) 
		{
			next_node=curr_node.next;
			curr_node.next=prev_node;
			prev_node=curr_node;
			curr_node=next_node;
		}
		head=prev_node;
		printList();
	}
	private static void removeDuplicates()
	{
		List curr_node=head;
		while (curr_node.next!=null)
		{
			if (curr_node.data==curr_node.next.data)
			{
				curr_node.next=curr_node.next.next;
				continue;
			}
			curr_node=curr_node.next;
		}
	}
	private static void findMiddleElement() 
	{
		List slow=head;
		List fast=head;
		
		while (fast!=null && fast.next!=null)
		{
				slow=slow.next;
				fast=fast.next.next;
		}	
		System.out.println(slow.data);
	}
	private static void delete(int i)
	{
		List temp=head;
		int counter=1;
		while (counter<i-1)
		{
			if (temp==null) 
			{
				break;
			}
			temp=temp.next;
			counter++;
		}
		if (temp==null)
		{
			System.out.println("No of elements are less");
		}
		else
		{
			temp.next=temp.next.next;			
		}
	}
	private static void printList() 
	{
		List temp=head;
		
		while (temp!=null)
		{
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
		System.out.println();
	}
	private static void addElement(int i) 
	{
		List temp=head;
		if (temp==null)
		{
			temp.data=i;
			temp.next=null;
		}
		while(temp.next!=null)
		{
			temp=temp.next;
		}
		temp.next=new List(i);
	}
}
