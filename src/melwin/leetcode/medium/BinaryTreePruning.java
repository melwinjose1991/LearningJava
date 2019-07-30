package melwin.leetcode.medium;

// Tree | Medium | Recursion

public class BinaryTreePruning {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static TreeNode pruneTree(TreeNode root) {
		if (traverseTree(root) > 0)
			return root;
		else
			return null;
	}

	private static int traverseTree(TreeNode node) {
		if (node == null)
			return 0;
		int left_sum = traverseTree(node.left);
		int right_sum = traverseTree(node.right);
		if (left_sum == 0)
			node.left = null;
		if (right_sum == 0)
			node.right = null;
		return left_sum + node.val + right_sum;
	}

	public static void main(String[] args) {
	}

}
