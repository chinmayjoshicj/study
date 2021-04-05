package LeetCode;

import java.math.BigInteger;

class ListNode {
	int val;
	ListNode next = null;

	public ListNode(int val) {
		super();
		this.val = val;
		this.next = null;
	}
}

public class AddTwoNumbers {
	static ListNode head1 = new ListNode(2);
	static ListNode head2 = new ListNode(5);

	public static void main(String[] args) {
//		addElementList(2,head1);
		addElementList(4,head1);
		addElementList(3,head1);
//		addElementList(9,head1);
//		addElementList(9,head1);
//		addElementList(9,head1);

//		addElementList(5,head2);
		addElementList(6,head2);
		addElementList(4,head2);
//		addElementList(9,head2);
//		addElementList(9,head2);
//		addElementList(9,head2);
//		addElementList(9,head2);
//		addElementList(9,head2);
//		addElementList(9,head2);
//		addElementList(9,head2);
//		addElementList(9,head2);
//		addElementList(9,head2);

		AddTwoNumbers a = new AddTwoNumbers();
		ListNode addTwoNumbers = a.addTwoNumbers(head1, head2);
		
		while (addTwoNumbers!=null) {
			System.out.print(addTwoNumbers.val+" ");
			addTwoNumbers=addTwoNumbers.next;
		}

	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		    ListNode dummyHead = new ListNode(0);
		    ListNode p = l1, q = l2, curr = dummyHead;
		    int carry = 0;
		    while (p != null || q != null) {
		        int x = (p != null) ? p.val : 0;
		        int y = (q != null) ? q.val : 0;
		        int sum = carry + x + y;
		        carry = sum / 10;
		        curr.next = new ListNode(sum % 10);
		        curr = curr.next;
		        if (p != null) p = p.next;
		        if (q != null) q = q.next;
		    }
		    if (carry > 0) {
		        curr.next = new ListNode(carry);
		    }
		    return dummyHead.next;
		}

	private static void addElementList(int i, ListNode head) {
		ListNode temp = head;
		if (temp == null) {
			temp.val = i;
			temp.next = null;
		}
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = new ListNode(i);
	}

}
