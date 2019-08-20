package melwin.leetcode.medium;

// Tree | Next

public class PopulatingNextRightPointersInEachNode {
	static class Node {
		public int val;
		public Node left;
		public Node right;
		public Node next;

		public Node() {
		}

		public Node(int _val, Node _left, Node _right, Node _next) {
			val = _val;
			left = _left;
			right = _right;
			next = _next;
		}
	}

	public static Node connect(Node root) {
		connectLRChild(root);
		connectCross(root);
		return root;
	}

	public static void connectCross(Node node) {
		if (node == null)
			return;
		if (node.next != null && node.right != null) {
			node.right.next = node.next.left;
		}
		connectCross(node.left);
		connectCross(node.right);
	}

	public static void connectLRChild(Node node) {
		if (node == null)
			return;
		if (node.left != null && node.right != null) {
			node.left.next = node.right;
		}
		connectLRChild(node.left);
		connectLRChild(node.right);
	}

	public static void main(String[] args) {
	}

}
