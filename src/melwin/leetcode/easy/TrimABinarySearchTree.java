package melwin.leetcode.easy;

import melwin.leetcode.medium.TreeNode;

// 669 - Trim A Binary Search Tree - O(n) - Node jumping

public class TrimABinarySearchTree {

	public TreeNode trimBST(TreeNode root, int L, int R) {
		if (root == null)
			return null;

		if (root.val < L)
			return trimBST(root.right, L, R);
		if (root.val > R)
			return trimBST(root.left, L, R);

		root.left = trimBST(root.left, L, R);
		root.right = trimBST(root.right, L, R);

		return root;
	}

	public static void main(String[] args) {
	}

}
