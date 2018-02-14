package melwin.leetcode.easy;

import melwin.leetcode.hard.ListNode;

// 61 - Rotate List - O(n)

public class RotateList {

	public ListNode rotateRight(ListNode head, int k) {
		if (head == null || head.next == null)
			return head;

		ListNode dummy = head;
		ListNode fast = dummy, slow = dummy;

		int n;
		for (n = 1; fast.next != null; n++) // Get the total length
			fast = fast.next;

		for (int j = n - 1 - k % n; j > 0; j--) // Get the n-1-(k%n) th node
			slow = slow.next;

		fast.next = dummy; // Do the rotation
		dummy = slow.next;
		slow.next = null;

		return dummy;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
