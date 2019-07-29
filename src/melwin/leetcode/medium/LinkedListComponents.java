package melwin.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

// Linked List

public class LinkedListComponents {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static int numComponents(ListNode head, int[] G) {
		Set<Integer> set = new HashSet<>();
		for (int g : G) {
			set.add(g);
		}
		int c = 0;
		ListNode node = head;
		while (node != null) {
			if (set.contains(node.val)) {
				c++;
				node = node.next;
				while (node != null && set.contains(node.val)) {
					node = node.next;
				}
			} else {
				node = node.next;
			}
		}
		return c;
	}

	public static void main(String[] args) {
		ListNode a = new ListNode(0);
		ListNode b = new ListNode(1);
		ListNode c = new ListNode(2);
		ListNode d = new ListNode(3);
		ListNode e = new ListNode(4);
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;

		int[] G = { 0, 4, 1, 3 };
		System.out.println(numComponents(a, G));
	}

}
