package melwin.hackerrank.practice.datastructures.tree;

public class IsThisBST {

	class Node {
		int data;
		Node left;
		Node right;
	}

	private static void inOrderTraversal(Node node) {
		if (node.left != null)
			inOrderTraversal(node.left);

		if (last_value == Integer.MIN_VALUE) {
			last_value = node.data;
		} else {
			if (last_value >= node.data)
				is_bst = false;
			last_value = node.data;
		}

		if (node.right != null)
			inOrderTraversal(node.right);
	}

	private static int last_value = Integer.MIN_VALUE;
	private static boolean is_bst = true;

	boolean checkBST(Node root) {
		inOrderTraversal(root);
		return is_bst;
	}

	public static void main(String[] args) {
	}

}
