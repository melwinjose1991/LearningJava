package melwin.leetcode.hard;

import melwin.leetcode.medium.TreeNode;

// 99 - Recover Binary Search Tree - O(n)

public class RecoverBinarySearchTree {

	TreeNode firstElement = null;
	TreeNode secondElement = null;
	TreeNode prevElement = new TreeNode(Integer.MIN_VALUE);

	public void recoverTree(TreeNode root) {

		traverse(root);

		int temp = firstElement.val;
		firstElement.val = secondElement.val;
		secondElement.val = temp;
	}

	private void traverse(TreeNode root) {

		if (root == null)
			return;

		traverse(root.left);

		if (firstElement == null && prevElement.val >= root.val) {
			firstElement = prevElement;
		}

		if (firstElement != null && prevElement.val >= root.val) {
			secondElement = root;
		}
		prevElement = root;

		traverse(root.right);
	}

	public static void main(String[] args) {
	}

}
