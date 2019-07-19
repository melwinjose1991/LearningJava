package melwin.leetcode.easy;

// LinkedList | Preprocessing

public class IntersectionOfTwoLinkedList {
	public static class ListNode {

		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		int a_length = 0, b_length = 0, a_skip = 0, b_skip = 0;
		for (ListNode tmp = headA; tmp != null; tmp = tmp.next)
			a_length++;
		for (ListNode tmp = headB; tmp != null; tmp = tmp.next)
			b_length++;
		if (a_length > b_length) {
			a_skip = a_length - b_length;
			a_length = b_length;
		} else if (b_length > a_length) {
			b_skip = b_length - a_length;
			b_length = a_length;
		}

		for (int i = 0; i < a_skip; i++)
			headA = headA.next;

		for (int i = 0; i < b_skip; i++)
			headB = headB.next;

		while (headA != null) {
			if (headA == headB) {
				return headA;
			}
			headA = headA.next;
			headB = headB.next;
		}
		return null;
	}

	public static void main(String[] args) {
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(1);
		ListNode c = new ListNode(1);
		ListNode d = new ListNode(1);
		a.next = c;
		b.next = c;
		c.next = d;

		System.out.println(getIntersectionNode(a, b));
	}

}
