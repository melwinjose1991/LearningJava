package melwin.leetcode.easy;

import melwin.leetcode.medium.TreeNode;

// 101 - Symmetric Tree - O(n)

public class SymmetricTree {
	
	public boolean isSymmetric(TreeNode root) {
		return root == null || isSymmetricHelp(root.left, root.right);
	}

	private boolean isSymmetricHelp(TreeNode left, TreeNode right) {
		if (left == null || right == null)
			return left == right;
		if (left.val != right.val)
			return false;
		return isSymmetricHelp(left.left, right.right) && isSymmetricHelp(left.right, right.left);
	}

	public static void main(String[] args) {
	}

}
