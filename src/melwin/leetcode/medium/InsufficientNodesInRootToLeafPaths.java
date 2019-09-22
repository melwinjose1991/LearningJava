package melwin.leetcode.medium;

// Recursion | Tree

public class InsufficientNodesInRootToLeafPaths {
	public TreeNode sufficientSubset(TreeNode root, int limit) {
		int sum = traverse(root, limit, 0);
		if (sum >= limit)
			return root;
		else
			return null;

	}

	private int traverse(TreeNode n, int limit, int sum) {
		if (n == null)
			return Integer.MIN_VALUE;
		if (n.left == null && n.right == null)
			return sum + n.val;
		int l = traverse(n.left, limit, sum + n.val);
		int r = traverse(n.right, limit, sum + n.val);
		if (l < limit && r < limit) {
			n.left = null;
			n.right = null;
			return Integer.MIN_VALUE;
		} else if (l < limit) {
			n.left = null;
			return r;
		} else if (r < limit) {
			n.right = null;
			return l;
		} else {
			return Math.max(l, r);
		}
	}

	public static void main(String[] args) {
	}

}
