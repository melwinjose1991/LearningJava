package melwin.leetcode.medium;

// Linked List | Rewiring

public class RemoveDuplicatesFromSortedListII {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static ListNode deleteDuplicates(ListNode head) {
		if(head==null)
			return null;
		
		ListNode new_head = null, prev = null, n = head;
		while (n != null) {
			ListNode node = n;
			while (node.next != null && node.val == node.next.val) {
				node = node.next;
			}
			if (!node.equals(n)) {
				n = node.next;
			} else {
				if (new_head == null) {
					new_head = n;
					prev = n;
				} else {
					prev.next = n;
					prev = n;
				}
				n = n.next;
			}
		}
		if(prev!=null) prev.next = null;
		return new_head;
	}

	public static void printList(ListNode node) {
		while (node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(3);
		ListNode d = new ListNode(3);
		ListNode e = new ListNode(4);
		ListNode f = new ListNode(4);
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		e.next = f;

		printList(deleteDuplicates(a));
	}

}
