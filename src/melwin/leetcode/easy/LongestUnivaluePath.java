package melwin.leetcode.easy;

import melwin.leetcode.medium.TreeNode;

// 687 - Longest Univalue Path - O(n) ~ Diamater of Tree

public class LongestUnivaluePath {

	public int longestUnivaluePath(TreeNode root) {
		int[] res = new int[1];
		if (root != null)
			dfs(root, res);
		return res[0];
	}

	private int dfs(TreeNode node, int[] res) {
		int l = node.left != null ? dfs(node.left, res) : 0; // Longest-Univalue-Path-Start-At - left child
		int r = node.right != null ? dfs(node.right, res) : 0; // Longest-Univalue-Path-Start-At - right child
		int resl = node.left != null && node.left.val == node.val ? l + 1 : 0; // Longest-Univalue-Path-Start-At - node,
																				// and go left
		int resr = node.right != null && node.right.val == node.val ? r + 1 : 0; // Longest-Univalue-Path-Start-At -
																					// node, and go right
		res[0] = Math.max(res[0], resl + resr); // Longest-Univalue-Path-Across - node
		return Math.max(resl, resr);
	}

	public static void main(String[] args) {
	}

}
