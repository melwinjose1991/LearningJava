package melwin.leetcode.medium;

import melwin.leetcode.hard.ListNode;

// 86. Partition List

public class PartitionList {

	public ListNode partition(ListNode head, int x) {
		ListNode smallerHead = new ListNode(0), biggerHead = new ListNode(0);
		ListNode smaller = smallerHead, bigger = biggerHead;
		
		while (head != null) {
			if (head.val < x) {
				smaller = smaller.next = head;
			} else {
				bigger = bigger.next = head;
			}
			head = head.next;
		}
		
		// no need for extra check because of fake heads
		smaller.next = biggerHead.next; // join bigger after smaller
		bigger.next = null; // cut off anything after bigger
		return smallerHead.next;
	}

	public static void main(String[] args) {
	}

}
