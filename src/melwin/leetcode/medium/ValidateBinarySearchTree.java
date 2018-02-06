package melwin.leetcode.medium;

import java.util.Stack;

// Leetcode - 98 - Validate Binary Search Tree - O(n)
// BST - Stack

public class ValidateBinarySearchTree {
	
	public boolean isValidBST(TreeNode root) {
		if (root == null)
			return true;
		Stack<TreeNode> stack = new Stack<>();
		TreeNode pre = null;

		while (root != null || !stack.isEmpty()) {
			
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			
			root = stack.pop();
			if (pre != null && root.val <= pre.val)
				return false;
			pre = root;
			root = root.right;
		}

		return true;
	}

	public static void main(String[] args) {
	}

}
