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
		addElements(20);
		addElements(20);
		addElements(30);
		addElements(40);
		addElements(50);
		addElements(60);
	}

	private static void addElements(int i) {
		List temp = RootNode;
		while (true) {
			if (temp.next == null) {
				temp.next = new List(i);
				break;
			} else
				temp = temp.next;
		}
	}

	private static void findMiddleElement() {
		if (RootNode == null) {
			return;
		}
		List first = RootNode;
		List second = RootNode.next;
		while (first != null && second != null) {
			first = first.next;
			second = second.next;
			if (second != null) {
				second = second.next;
			}
		}
		System.out.println(first.data);
	}

	private static void removeDuplicates() {
		List curr = RootNode;
		List next = RootNode.next;
		while (curr != null && next != null) {
			if (curr.data == next.data) {
				curr.next = next.next;
				next = curr.next;
			}
			curr = curr.next;
			next = next.next;
		}
	}

	private static void reverseLinkedList() {
		List curr = RootNode;
		List next = null;
		List prev = null;

		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		RootNode = prev;
	}

	private static void printLL() {
		List temp = RootNode;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}
}
