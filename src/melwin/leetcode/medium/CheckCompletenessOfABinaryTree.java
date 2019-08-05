package melwin.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

// Tree | BFS

public class CheckCompletenessOfABinaryTree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static boolean isCompleteTree(TreeNode root) {
		int max_depth = getMaxDepth(root) - 1;
		int lvl = 0;
		int last_complete_node = -1;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		while (!q.isEmpty()) {
			int n = q.size();
			if (lvl != max_depth) {
				if (n != Math.pow(2, lvl)) {
					return false;
				}
			} else {
				return true;
			}
			last_complete_node = -1;
			for (int i = 0; i < n; i++) {
				TreeNode node = q.poll();
				if (i > 0 && last_complete_node + 1 != i && (node.left != null || node.right != null)) {
					return false;
				}
				if (node.left != null && node.right != null) {
					q.add(node.left);
					q.add(node.right);
					last_complete_node = i;
				} else if (node.left == null && node.right != null) {
					return false;
				} else if (node.left != null && node.right == null) {
					q.add(node.left);
				} else {
				}
			}
			lvl++;
		}
		if (last_complete_node == -1) {
			return true;
		} else {
			return false;
		}

	}

	private static int getMaxDepth(TreeNode node) {
		if (node == null) {
			return 0;
		} else {
			int left = getMaxDepth(node.left);
			int right = getMaxDepth(node.right);
			return Math.max(left, right) + 1;
		}
	}

	public static void main(String[] args) {
		TreeNode a = new TreeNode(0);
		TreeNode b = new TreeNode(0);
		TreeNode c = new TreeNode(0);
		TreeNode d = new TreeNode(0);
		TreeNode e = new TreeNode(0);
		TreeNode f = new TreeNode(0);

		a.left = b;
		a.right = c;
		b.left = d;
		b.right = e;
		c.left = f;
		System.out.println(isCompleteTree(a));
	}

}
