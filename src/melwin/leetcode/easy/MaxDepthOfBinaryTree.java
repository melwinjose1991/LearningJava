package melwin.leetcode.easy;

public class MaxDepthOfBinaryTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int maxDepth(TreeNode root) {
		return traverseTree(root, 0);
	}

	public static int traverseTree(TreeNode root, int depth) {
		if (root == null)
			return 0;
		int left_depth = traverseTree(root.left, depth);
		int right_depth = traverseTree(root.right, depth);
		return (left_depth >= right_depth ? left_depth : right_depth) + 1;
	}

	public static void main(String[] args) {
	}

}
