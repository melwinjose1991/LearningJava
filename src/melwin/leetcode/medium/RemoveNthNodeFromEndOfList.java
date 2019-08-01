package melwin.leetcode.medium;

// Linked List | N Step Pointer | Medium

public class RemoveNthNodeFromEndOfList {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null || head.next == null)
			return null;
		ListNode front = head;
		for (int i = 0; i < n; i++) {
			front = front.next;
		}
		if (front == null) {
			return head.next;
		} else {
			ListNode back = head;
			while (front != null && front.next != null) {
				front = front.next;
				back = back.next;
			}
			back.next = back.next.next;
			return head;
		}

	}

	public static void main(String[] args) {
	}

}
