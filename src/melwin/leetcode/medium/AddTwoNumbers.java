package melwin.leetcode.medium;

public class AddTwoNumbers {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int c = 0;
		ListNode head = null, prev = null;
		while (l1 != null || l2 != null) {
			int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + c;
			ListNode node = new ListNode(sum % 10);
			c = sum / 10;
			if (head == null) {
				head = node;
			} else {
				prev.next = node;
			}
			prev = node;

			l1 = l1 != null ? l1.next : null;
			l2 = l2 != null ? l2.next : null;
		}
		if (c != 0) {
			ListNode node = new ListNode(c);
			prev.next = node;
		}
		return head;
	}

	public static void main(String[] args) {
	}

}
