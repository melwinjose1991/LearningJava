package melwin.leetcode;

public class RemoveDuplicatesFromSortedListII {

	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode current = head;
		ListNode previous = null;
		ListNode new_head = null;
		while (current.next != null) {
			int current_val = current.val;
			int next_val = current.next.val;
			if (current_val == next_val) {
				while (current.next != null && current.next.val == current_val) {
					current = current.next;
				}
				if (previous != null) {
					if (current.next != null) {
						previous.next = current.next;
						current = current.next;
					} else {
						previous.next = null;
					}
				} else {
					if (current.next != null) {
						current = current.next;
					} else {
						// all duplicates
						return null;
					}
				}
			} else {
				if (previous == null) {
					new_head = current;
				}
				previous = current;
				current = current.next;
			}
		}
		if (new_head == null) {
			new_head = current;
		}
		return new_head;
	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {

	}

}
