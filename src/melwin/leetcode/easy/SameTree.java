package melwin.leetcode.easy;

import melwin.leetcode.medium.TreeNode;

// 100 - Same Tree - O(n)

public class SameTree {

	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null)
			return true;

		if ((p == null && q != null) || (p != null && q == null))
			return false;

		return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}

	public static void main(String[] args) {
	}

}
