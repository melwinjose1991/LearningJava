package melwin.leetcode;


public class Analyzed_ValidateBinarySearchTree {

	public boolean isValidBST(TreeNode root) {
		return isValidBST(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
	}

	private boolean isValidBST(TreeNode p, double min, double max) {
		if (p == null)
			return true;

		if (p.val <= min || p.val >= max)
			return false;

		return isValidBST(p.left, min, p.val) && isValidBST(p.right, p.val, max);
	}

	// Your solution for IsThisBST uses global static variable.
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(0);
		Analyzed_ValidateBinarySearchTree x = new Analyzed_ValidateBinarySearchTree();
		System.out.println(x.isValidBST(root));
	}

}
