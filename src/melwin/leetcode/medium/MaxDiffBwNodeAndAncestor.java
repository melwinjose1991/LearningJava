package melwin.leetcode.medium;

// Tree | Medium

public class MaxDiffBwNodeAndAncestor {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	private int max_diff;

	public int maxAncestorDiff(TreeNode root) {
		max_diff = 0;
		traverseTree(root);
		return max_diff;
	}

	private int[] traverseTree(TreeNode node) {
		if (node == null) {
			return new int[] { -1, -1 };
		}

		int[] left = traverseTree(node.left);
		int[] right = traverseTree(node.right);
		int min = node.val, max = node.val;
		if (left[0] != -1) {
			max_diff = Math.max(max_diff, Math.abs(left[0] - node.val));
			min = Math.min(min, left[0]);
		}
		if (left[1] != -1) {
			max_diff = Math.max(max_diff, Math.abs(left[1] - node.val));
			max = Math.max(max, left[1]);
		}
		if (right[0] != -1) {
			max_diff = Math.max(max_diff, Math.abs(right[0] - node.val));
			min = Math.min(min, right[0]);
		}
		if (right[1] != -1) {
			max_diff = Math.max(max_diff, Math.abs(right[1] - node.val));
			max = Math.max(max, right[1]);
		}

		return new int[] { min, max };
	}

	public static void main(String[] args) {
	}

}
