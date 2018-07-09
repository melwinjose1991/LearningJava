package melwin.leetcode.hard;

import melwin.leetcode.medium.TreeNode;

// 124. Binary Tree Maximum Path Sum - O(n) - lots of cases of +/-

public class BinaryTreeMaximumPathSum {

	public int maxPathSum(TreeNode root) {
		int[] max = new int[1];
		max[0] = Integer.MIN_VALUE;
		maxPathSum(max, root);
		return max[0];
	}

	private int maxPathSum(int[] max, TreeNode root) {
		if (root == null)
			return 0;
		int leftMax = Math.max(0, maxPathSum(max, root.left));
		int rightMax = Math.max(0, maxPathSum(max, root.right));
		max[0] = Math.max(max[0], root.val + leftMax + rightMax);
		return root.val + Math.max(leftMax, rightMax);
	}

	public static void main(String[] args) {
	}

}
