package melwin.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

// Linked List

public class CopyListWithRandomPointer {
	class Node {
		public int val;
		public Node next;
		public Node random;

		public Node() {
		}

		public Node(int _val, Node _next, Node _random) {
			val = _val;
			next = _next;
			random = _random;
		}
	};

	public Node copyRandomList(Node head) {
		if (head == null)
			return null;

		Map<Node, Node> map = new HashMap<Node, Node>();

		// loop 1. copy all the nodes
		Node node = head;
		while (node != null) {
			map.put(node, new Node(node.val, null, null));
			node = node.next;
		}

		// loop 2. assign next and random pointers
		node = head;
		while (node != null) {
			map.get(node).next = map.get(node.next);
			map.get(node).random = map.get(node.random);
			node = node.next;
		}

		return map.get(head);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
