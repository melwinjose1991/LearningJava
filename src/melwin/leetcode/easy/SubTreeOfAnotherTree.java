package melwin.leetcode.easy;

import melwin.leetcode.medium.TreeNode;

// 572. Subtree of Another Tree - O(n^2)

public class SubTreeOfAnotherTree {

	public boolean isSubtree(TreeNode s, TreeNode t) {
		if (s == null)
			return false;
		if (isSame(s, t))
			return true;
		return isSubtree(s.left, t) || isSubtree(s.right, t);
	}

	private boolean isSame(TreeNode s, TreeNode t) {
		if (s == null && t == null)
			return true;
		if (s == null || t == null)
			return false;

		if (s.val != t.val)
			return false;

		return isSame(s.left, t.left) && isSame(s.right, t.right);
	}

	public static void main(String[] args) {
	}

}
