package melwin.leetcode;

// ||BINARY TREE|| ||MAX SUM|| ||NON ADJACENT NODES||
// ||LEET CODE|| ||DFS|| ||RECURSIVE||
// Time : O(n)

public class Analyzed_HouseRobberIII {
	public static int rob(TreeNode root) {
		if (root == null)
			return 0;

		int[] result = helper(root);
		return Math.max(result[0], result[1]);
	}

	public static int[] helper(TreeNode root) {
		if (root == null) {
			int[] result = { 0, 0 };
			return result;
		}

		int[] result = new int[2];
		int[] left = helper(root.left);
		int[] right = helper(root.right);

		// result[0] is when root is selected, result[1] is when not.
		result[0] = root.val + left[1] + right[1];
		result[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

		return result;
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
		TreeNode root = new TreeNode(1);

		root.left = new TreeNode(2);
		root.right = new TreeNode(3);

		root.left.left = new TreeNode(1);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(5);

		System.out.println(rob(root));
	}
}
