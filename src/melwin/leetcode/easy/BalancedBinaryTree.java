package melwin.leetcode.easy;

// Tree | Recursion

public class BalancedBinaryTree {

	private boolean is_balanced;

	public boolean isBalanced(TreeNode root) {
		is_balanced = true;
		checkHeightDifference(root);
		return is_balanced;
	}

	private int checkHeightDifference(TreeNode n) {
		if (n == null)
			return 0;

		int left_h = checkHeightDifference(n.left);
		int right_h = checkHeightDifference(n.right);
		if (Math.abs(left_h - right_h) > 1) {
			is_balanced = false;
		}
		return Math.max(left_h, right_h) + 1;
	}

	public static void main(String[] args) {
	}

}
