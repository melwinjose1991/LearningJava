package melwin.leetcode.easy;

import melwin.leetcode.medium.TreeNode;

// 226 - Invert Binary Tree

public class InvertBinaryTree {

	public TreeNode invertTree(TreeNode root) {
		if (root == null)
			return null;
		TreeNode tempRight = root.right;
		root.right = invertTree(root.left);
		root.left = invertTree(tempRight);
		return root;
	}

	public static void main(String[] args) {
	}

}
