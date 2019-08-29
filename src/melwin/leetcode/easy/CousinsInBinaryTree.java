package melwin.leetcode.easy;

// Tree | DFS

public class CousinsInBinaryTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean isCousins(TreeNode root, int x, int y) {
		int[] x_info = getDepthParent(root, x, 0, null);
		int[] y_info = getDepthParent(root, y, 0, null);
		if (x_info[0] == y_info[0] && x_info[1] != y_info[1]) {
			return true;
		} else {
			return false;
		}
	}

	private int[] getDepthParent(TreeNode node, int target, int lvl, TreeNode parent) {
		if (node == null)
			return new int[] { 0, 0 };

		if (node.val == target)
			return new int[] { lvl, parent != null ? parent.val : 0 };

		int[] left = getDepthParent(node.left, target, lvl + 1, node);
		if (left[0] > 0)
			return left;

		int[] right = getDepthParent(node.right, target, lvl + 1, node);
		if (right[0] > 0)
			return right;

		return new int[] { 0, 0 };

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
