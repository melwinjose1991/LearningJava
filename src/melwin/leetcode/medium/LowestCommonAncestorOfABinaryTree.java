package melwin.leetcode.medium;

// Leetcode - 236 - Lowest Common Ancestor of a Binary Tree
// Check if p and q are on the left or right of the current node

public class LowestCommonAncestorOfABinaryTree {
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || root == p || root == q)
			return root;

		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);

		return left == null ? right : right == null ? left : root;
	}

	public static void main(String[] args) {
	}

}
