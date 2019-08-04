package melwin.leetcode.medium;

// Linked List | Recursing Two Linked List

public class AddTwoNumbersII {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int n1 = getLength(l1);
		int n2 = getLength(l2);
		ListNode[] ret = null;
		// System.out.println(n1 + " " + n2);
		if (n1 >= n2) {
			ret = recurse(l1, 0, n1, l2, 0, n2);
		} else {
			ret = recurse(l2, 0, n2, l1, 0, n1);
		}
		getLength(ret[0]);
		if (ret[1].val > 0) {
			ret[1].next = ret[0];
			return ret[1];
		} else {
			return ret[0];
		}

	}

	private static int getLength(ListNode head) {
		ListNode node = head;
		int n = 0;
		while (node != null) {
			// System.out.println(node.val);
			node = node.next;
			n++;
		}
		return n;
	}

	private static ListNode[] recurse(ListNode l1, int i, int n1, ListNode l2, int j, int n2) {
		if (l1 == null && l2 == null) {
			return new ListNode[] { null, new ListNode(0) };
		} else {
			if (i >= n1 - n2) {
				// System.out.println(i + " " + n1 + " " + n2);
				ListNode[] ret = recurse(l1.next, i + 1, n1, l2.next, j + 1, n2);
				ListNode n = new ListNode((l1.val + l2.val + ret[1].val) % 10);
				n.next = ret[0];
				ListNode c = new ListNode((l1.val + l2.val + ret[1].val) / 10);
				return new ListNode[] { n, c };
			} else {
				// System.out.println(i + " " + n1 + " " + n2);
				ListNode[] ret = recurse(l1.next, i + 1, n1, l2, 0, n2);
				ListNode n = new ListNode((l1.val + ret[1].val) % 10);
				n.next = ret[0];
				ListNode c = new ListNode((l1.val + ret[1].val) / 10);
				return new ListNode[] { n, c };
			}
		}
	}

	public static void main(String[] args) {
		ListNode a1 = new ListNode(7);
		ListNode a2 = new ListNode(2);
		ListNode a3 = new ListNode(4);
		ListNode a4 = new ListNode(3);
		a1.next = a2;
		a2.next = a3;
		a3.next = a4;

		ListNode b1 = new ListNode(9);
		ListNode b2 = new ListNode(9);
		ListNode b3 = new ListNode(9);
		ListNode b4 = new ListNode(9);
		b1.next = b2;
		b2.next = b3;
		b3.next = b4;

		addTwoNumbers(a1, b1);
	}

}
