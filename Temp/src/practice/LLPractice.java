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
		System.out.print("After Duplicate Removal :");
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
		addElement(40);
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
		List curr = RootNode;
		List prev = null;
		List next = null;

		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		RootNode = prev;
	}

	private static void removeDuplicates() {

	}

	private static void findMiddleElement() {
		int len=0;
		List temp = RootNode;
		while (temp != null) {
			len++;
			temp=temp.next;
		}
		len=len/2;
		temp = RootNode;
		while (len!=0) {
			len--;
			temp=temp.next;
			if (len==0) {
				System.out.print(temp.data);
			}
		}
	}

	private static void printLL() {
		List temp = RootNode;
		while (temp != null) {
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
	}

}
