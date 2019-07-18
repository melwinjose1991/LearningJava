package melwin.leetcode.easy;

// Tree | BST | Recursion

public class SearchInBST {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode searchBST(TreeNode root, int val) {
		if (root == null || root.val == val)
			return root;

		if (root.val < val)
			return searchBST(root.right, val);
		else
			return searchBST(root.left, val);
	}

	public static void main(String[] args) {

	}

}
