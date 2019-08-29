package melwin.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Tree | BFS | DFS

public class MaximumWidthOfBinaryTree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static int widthOfBinaryTree(TreeNode root) {
		int max_width = 0;
		if (root == null)
			return max_width;

		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			int len = q.size();
			max_width = Math.max(max_width, len);

			int last_node = -1;
			List<TreeNode> tmp = new ArrayList<>();
			for (int i = 0; i < len; i++) {
				TreeNode node = q.poll();
				if (node != null) {
					if (node.left != null || tmp.size() > 0) {
						tmp.add(node.left);
						if (tmp.get(tmp.size() - 1) != null)
							last_node = tmp.size() - 1;
					}
					if (node.right != null || tmp.size() > 0) {
						tmp.add(node.right);
						if (tmp.get(tmp.size() - 1) != null)
							last_node = tmp.size() - 1;
					}
				} else {
					if (tmp.size() > 0) {
						tmp.add(null);
						tmp.add(null);
					}
				}
			}
			for (int i = 0; i <= last_node; i++) {
				q.add(tmp.get(i));
			}

		}
		return max_width;
	}

	public static void main(String[] args) {
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(3);
		TreeNode c = new TreeNode(5);
		TreeNode d = new TreeNode(3);
		a.left = b;
		b.left = c;
		b.right = d;

		System.out.println(widthOfBinaryTree(a));

	}

}
