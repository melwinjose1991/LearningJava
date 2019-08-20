package melwin.leetcode.easy;

// Tree | In Order Traversal

public class MinAbsDiffInBst {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	int minDiff = Integer.MAX_VALUE;
	TreeNode prev;

	public int getMinimumDifference(TreeNode root) {
		inorder(root);
		return minDiff;
	}

	public void inorder(TreeNode root) {
		if (root == null)
			return;
		inorder(root.left);
		if (prev != null)
			minDiff = Math.min(minDiff, root.val - prev.val);
		prev = root;
		inorder(root.right);
	}

	public static void main(String[] args) {
	}

}
