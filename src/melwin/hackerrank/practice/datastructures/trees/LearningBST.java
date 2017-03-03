package melwin.hackerrank.practice.datastructures.trees;

public class LearningBST {

	// InOrder Traversal
	public void inOrderTravesal(TreeNode node) {
		if (node.left != null)
			inOrderTravesal(node.left);

		System.out.print(node.val + " ");

		if (node.right != null)
			inOrderTravesal(node.right);
	}

	// VALIDATE BST
	public boolean isValidBST(TreeNode root) {
		return isValidBST(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
	}

	private boolean isValidBST(TreeNode p, double min, double max) {
		if (p == null)
			return true;

		if (p.val <= min || p.val >= max)
			return false;

		return isValidBST(p.left, min, p.val) && isValidBST(p.right, p.val, max);
	}

	// VALIDATE BST - 2
	private void inOrderTraversal2(TreeNode node) {
		if (node.left != null)
			inOrderTraversal2(node.left);

		if (last_value == Integer.MIN_VALUE) {
			last_value = node.val;
		} else {
			if (last_value >= node.val)
				is_bst = false;
			last_value = node.val;
		}

		if (node.right != null)
			inOrderTraversal2(node.right);
	}

	private int last_value = Integer.MIN_VALUE;
	private boolean is_bst = true;

	public boolean isValidBST2(TreeNode root) {
		inOrderTraversal2(root);
		return is_bst;
	}

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(20);
		root.left = new TreeNode(10);
		root.right = new TreeNode(30);
		root.left.left = new TreeNode(5);
		root.left.left.right = new TreeNode(7);
		root.left.right = new TreeNode(15);
		root.right.left = new TreeNode(25);
		root.right.right = new TreeNode(35);
		root.left.right.left = new TreeNode(13);
		root.left.right.right = new TreeNode(18);

		LearningBST x = new LearningBST();

		System.out.print("inorder-traversal: ");
		x.inOrderTravesal(root);

		System.out.println("\n\nisValidBST: "+x.isValidBST(root));
		System.out.println("isValidBST2: "+x.isValidBST2(root));

	}
}
