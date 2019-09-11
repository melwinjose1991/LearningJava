package melwin.leetcode.medium;

// Tree | Recursion | Parent

public class InorderSuccessorInBSTII {

	private Node succ;

	public Node inorderSuccessor(Node x) {
		succ = null;
		traverse(x);
		return succ;
	}

	private void traverse(Node x) {
		if (x.right == null) {
			if (x.parent != null) {
				if (x.parent.left != null && x.parent.left.val == x.val) {
					// x is parent's left child
					succ = x.parent;
				} else {
					// x is parent's right child
					Node n = x.parent;
					while (n.parent != null && n.parent.right != null && n.parent.right.val == n.val) {
						n = n.parent;
					}
					succ = n.parent;
				}
			} else {
				// no parent or right child
				succ = null;

			}
		} else {
			// there is a right child
			Node n = x.right;
			while (n != null) {
				succ = n;
				n = n.left;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
