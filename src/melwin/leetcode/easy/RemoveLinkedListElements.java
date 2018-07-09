package melwin.leetcode.easy;

import melwin.leetcode.hard.ListNode;

// 203 - Remove Linked List Elements

public class RemoveLinkedListElements {

	public ListNode removeElements(ListNode head, int val) {
		ListNode curr = head, prev = null, new_head = null;
		while (curr != null) {
			if (curr.val == val) {
				if (prev != null) {
					prev.next = curr.next;
				}
			} else {
				if (prev == null) {
					new_head = curr;
				}
				prev = curr;
			}
			curr = curr.next;
		}
		return new_head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
