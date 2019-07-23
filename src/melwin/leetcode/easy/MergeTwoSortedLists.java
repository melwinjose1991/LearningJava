package melwin.leetcode.easy;

// Linked List

public class MergeTwoSortedLists {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode head_ptr = null, prev_ptr = null;
		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				if (head_ptr == null) {
					head_ptr = l1;
				} else {
					prev_ptr.next = l1;
				}
				prev_ptr = l1;
				l1 = l1.next;
			} else {
				if (head_ptr == null) {
					head_ptr = l2;
				} else {
					prev_ptr.next = l2;
				}
				prev_ptr = l2;
				l2 = l2.next;
			}
		}
		if (l1 != null) {
			if (head_ptr == null)
				head_ptr = l1;
			else
				prev_ptr.next = l1;
		}
		if (l2 != null) {
			if (head_ptr == null)
				head_ptr = l2;
			else
				prev_ptr.next = l2;
		}
		return head_ptr;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
