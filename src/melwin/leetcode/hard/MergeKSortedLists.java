package melwin.leetcode.hard;

import java.util.Comparator;
import java.util.PriorityQueue;

// Priority Queue | Min Heap

public class MergeKSortedLists {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode mergeKLists(ListNode[] lists) {
		if (lists.length == 0)
			return null;
		int k = lists.length;
		PriorityQueue<ListNode> pq = new PriorityQueue<>(k, new Comparator<ListNode>() {
			@Override
			public int compare(ListNode arg0, ListNode arg1) {
				return arg0.val - arg1.val;
			}
		});
		for (int i = 0; i < k; i++) {
			if (lists[i] != null)
				pq.add(lists[i]);
		}
		ListNode new_head = null;
		ListNode prev = null;
		while (!pq.isEmpty()) {
			ListNode node = pq.poll();
			if (new_head == null) {
				new_head = node;
				prev = node;
				if (node.next != null) {
					pq.add(node.next);
				}
			} else {
				prev.next = node;
				prev = node;
				if (node.next != null) {
					pq.add(node.next);
				}
			}
		}
		return new_head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
