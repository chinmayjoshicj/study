package practice;

public class LLPractice {
	static List RootNode = new List(10);

	public static void main(String[] args) {
		CreateLL();
		printLL();
		System.out.println();
		System.out.println("Middle Element is: ");
		findMiddleElement();
		System.out.println();
		System.out.print("After Duplic	ate Removal :");
		removeDuplicates();

		printLL();
		reverseLinkedList();
		System.out.println();
		System.out.print("Reversed Linked List: ");
		printLL();
	}

	private static void CreateLL() {
		addElement(20);
		addElement(30);
		addElement(30);
		addElement(40);
		addElement(50);
		addElement(50);
		addElement(60);
		addElement(70);
	}

	private static void addElement(int i) {
		List temp = RootNode;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = new List(i);
	}

	private static void reverseLinkedList() {
		List curr=RootNode;
		List next=null;
		List prev=null;
		
		while(curr!=null) {
			next=curr.next;
			curr.next=prev;
			prev=curr;
			curr=next;
		}
		RootNode=prev;
		
	}

	private static void removeDuplicates() {
		if(RootNode==null) {
			return;
		}
		List temp=RootNode;
		while (temp!=null) {
			if(temp.next!=null && temp.data==temp.next.data) {
				temp.next=temp.next.next;
			}
			temp=temp.next;
		}
	}

	private static void findMiddleElement() {
		List slow=RootNode;
		List fast=RootNode.next;
		
		while (fast!=null && slow!=null) {
			slow=slow.next;
			
			if(fast.next!=null) {
				fast=fast.next.next;
			}
		}
		System.out.println(slow.data);
	}

	private static void printLL() {
		List temp = RootNode;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}

}
