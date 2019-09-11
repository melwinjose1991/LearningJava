package melwin.leetcode.easy;

// Tree | Recursion

public class MinDepthOfBinaryTree {

	private int min_depth;

	public int minDepth(TreeNode root) {
		if (root == null)
			return 0;
		min_depth = Integer.MAX_VALUE;
		traverse(root, 1);
		return min_depth;
	}

	private void traverse(TreeNode node, int depth) {
		if (node == null)
			return;
		if (node.left == null && node.right == null) {
			min_depth = Math.min(min_depth, depth);
		} else {
			traverse(node.left, depth + 1);
			traverse(node.right, depth + 1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
