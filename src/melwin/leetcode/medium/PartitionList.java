package melwin.leetcode.medium;

// Linked List | Re-wiring | Medium

public class PartitionList {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode partition(ListNode head, int x) {
		if (head == null)
			return null;
		ListNode less_head = null, less_prev = null, gt_head = null, gt_prev = null;
		ListNode node = head;
		while (node != null) {
			if (node.val < x) {
				if (less_head == null) {
					less_head = node;
					less_prev = node;
				} else {
					less_prev.next = node;
					less_prev = node;
				}
			} else {
				if (gt_head == null) {
					gt_head = node;
					gt_prev = node;
				} else {
					gt_prev.next = node;
					gt_prev = node;
				}
			}
			node = node.next;
		}

		if (less_head == null) {
			gt_prev.next = null;
			return gt_head;
		} else {
			less_prev.next = gt_head;
			if (gt_prev != null)
				gt_prev.next = null;
			return less_head;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
