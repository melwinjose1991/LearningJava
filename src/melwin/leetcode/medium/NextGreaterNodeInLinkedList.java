package melwin.leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// Stack | Monotone | XXX

public class NextGreaterNodeInLinkedList {

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public int[] nextLargerNodes(ListNode head) {
		List<Integer> list = new ArrayList<Integer>();
		while (head != null) {
			list.add(head.val);
			head = head.next;
		}

		Stack<Integer> stack = new Stack<>();
		int[] result = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			while (!stack.isEmpty() && list.get(stack.peek()) < list.get(i))
				result[stack.pop()] = list.get(i);
			stack.push(i);
		}
		return result;
	}

	public static void main(String[] args) {
	}

}
