package melwin.leetcode.medium;

// Tree

public class BinaryTreeLongestConsecutiveSequence {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	private int max_len;

	public int longestConsecutive(TreeNode root) {
		max_len = 0;
		traverse(root);
		return max_len;
	}

	private int[] traverse(TreeNode node) {
		if (node == null)
			return null;
		int[] left = traverse(node.left);
		int[] right = traverse(node.right);
		int max = 1;
		if (left != null && left[0] == node.val + 1) {
			max = Math.max(max, left[1] + 1);
		}
		if (right != null && right[0] == node.val + 1) {
			max = Math.max(max, right[1] + 1);
		}
		max_len = Math.max(max_len, max);
		return new int[] { node.val, max };
	}

	public static void main(String[] args) {
	}

}
