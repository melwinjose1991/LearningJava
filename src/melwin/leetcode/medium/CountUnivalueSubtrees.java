package melwin.leetcode.medium;

// Tree

public class CountUnivalueSubtrees {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	private int count;

	public int countUnivalSubtrees(TreeNode root) {
		count = 0;
		traverse(root);
		return count;
	}

	private boolean traverse(TreeNode node) {
		if (node == null)
			return true;

		boolean left = traverse(node.left);
		boolean right = traverse(node.right);

		if (left && right) {
			if ((node.left == null || node.left.val == node.val)
					&& (node.right == null || node.right.val == node.val)) {
				count++;
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
	}

}
