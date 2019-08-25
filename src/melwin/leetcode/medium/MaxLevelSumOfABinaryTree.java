package melwin.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

// BFS | Tree

public class MaxLevelSumOfABinaryTree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static int maxLevelSum(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		int max_sum = Integer.MIN_VALUE, min_lvl = 1;
		int lvl = 1;
		while (!q.isEmpty()) {
			int len = q.size();
			int sum = 0;
			for (int i = 0; i < len; i++) {
				TreeNode n = q.poll();
				sum += n.val;
				if (n.left != null)
					q.add(n.left);
				if (n.right != null)
					q.add(n.right);
			}
			if (sum > max_sum) {
				max_sum = sum;
				min_lvl = lvl;
			}
			lvl++;
		}
		return min_lvl;
	}

	public static void main(String[] args) {
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(7);
		TreeNode c = new TreeNode(0);
		TreeNode d = new TreeNode(7);
		TreeNode e = new TreeNode(-8);
		a.left = b;
		a.right = c;
		b.left = d;
		b.right = e;
		System.out.println(maxLevelSum(a));
	}

}
