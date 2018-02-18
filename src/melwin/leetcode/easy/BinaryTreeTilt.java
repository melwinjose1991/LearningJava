package melwin.leetcode.easy;

import melwin.leetcode.medium.TreeNode;

// 563 - Binary Tree Tilt - O(n)

public class BinaryTreeTilt {

	public int findTilt(TreeNode root) {
		int[] res = helper(root);
		return res[1];
	}

	private int[] helper(TreeNode node) {
		if (node == null)
			return new int[] { 0, 0 };
		int[] l = helper(node.left);
		int[] r = helper(node.right);
		return new int[] { l[0] + r[0] + node.val, Math.abs(l[0] - r[0]) + l[1] + r[1] };
	}

	public static void main(String[] args) {
	}

}
