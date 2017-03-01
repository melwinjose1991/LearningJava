package melwin.leetcode;

// ||Binary_Tree|| ||Path_Sum|| ||O_n||

public class Analyzed_BinaryTreeMaximumPathSum {

	public int maxPathSum(TreeNode root) {
		int max[] = new int[1];
		max[0] = Integer.MIN_VALUE;
		postOrder(root, max);
		return max[0];
	}

	public int postOrder(TreeNode root, int[] max) {
		if (root == null)
			return 0;

		int left = postOrder(root.left, max);
		int right = postOrder(root.right, max);

		int current = Math.max(root.val, Math.max(root.val + left, root.val + right));

		max[0] = Math.max(max[0], Math.max(current, left + root.val + right));

		return current;
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
