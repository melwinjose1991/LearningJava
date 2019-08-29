package melwin.leetcode.medium;

// Linked List

public class FlattenAMultilevelDoublyLinkedList {
	static class Node {
		public int val;
		public Node prev;
		public Node next;
		public Node child;

		public Node() {
		}

		public Node(int _val, Node _prev, Node _next, Node _child) {
			val = _val;
			prev = _prev;
			next = _next;
			child = _child;
		}
	};

	public static Node flatten(Node head) {
		rewire(head);
		return head;
	}

	private static Node[] rewire(Node node) {
		Node head = node, ptr = node, prev = node;
		while (ptr != null) {
			if (ptr.child != null) {
				Node next = ptr.next;
				Node[] head_tail = rewire(ptr.child);
				ptr.child = null;
				head_tail[0].prev = ptr;
				ptr.next = head_tail[0];
				if (next != null) {
					head_tail[1].next = next;
					next.prev = head_tail[1];
				}
				prev = head_tail[1];
				ptr = next;
			} else {
				prev = ptr;
				ptr = ptr.next;
			}
		}
		return new Node[] { head, prev };
	}

	private static void traverse(Node head) {
		Node ptr = head;
		while (ptr != null) {
			System.out.print(ptr.val);
			if (ptr.child != null) {
				System.out.print("(");
				traverse(ptr.child);
				System.out.print(")");
			}
			ptr = ptr.next;
			if (ptr != null)
				System.out.print("-");
		}
	}

	public static void main(String[] args) {
		Node a_prev = new Node();
		Node a = new Node();
		Node b = new Node();
		Node c = new Node();
		Node d = new Node();
		a_prev.next = a;
		a.prev = a_prev;
		a.next = d;
		d.prev = a;
		a.child = b;
		b.child = c;

		a_prev.val = 0;
		a.val = 1;
		b.val = 2;
		c.val = 3;
		d.val = 4;

		traverse(a_prev);
		System.out.println();
		flatten(a_prev);
		traverse(a_prev);
	}

}
