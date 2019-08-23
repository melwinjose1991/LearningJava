package melwin.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Tree | DFS + BFS

public class AllNodesDistanceKInBinaryTree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
		List<Integer> result = new ArrayList<>();
		bfs(target, K, result, 0);
		postOrder(root, target, K, result);
		return result;
	}

	private static int[] postOrder(TreeNode node, TreeNode target, int K, List<Integer> result) {
		if (node == null)
			return new int[] { 0, 0 };

		int[] l = postOrder(node.left, target, K, result);
		int[] r = postOrder(node.right, target, K, result);
		if (l[0] == 1) {
			if (K - l[1] >= 0) {
				bfs(node, K - l[1], result, 1);
			}
			return new int[] { 1, l[1] + 1 };
		} else if (r[0] == 1) {
			if (K - r[1] >= 0) {
				bfs(node, K - r[1], result, -1);
			}
			return new int[] { 1, r[1] + 1 };
		} else if (node.val == target.val) {
			return new int[] { 1, 1 };
		} else {
			return new int[] { 0, 0 };
		}
	}

	private static void bfs(TreeNode node, int k, List<Integer> result, int direction) {
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(node);
		int lvl = 0;
		while (!q.isEmpty() && lvl <= k) {
			if (lvl == 0) {
				TreeNode n = q.poll();
				if (lvl == k)
					result.add(n.val);
				if (direction == 0) {
					if (n.left != null)
						q.add(n.left);
					if (n.right != null)
						q.add(n.right);
				} else if (direction == -1) {
					if (n.left != null)
						q.add(n.left);
				} else {
					if (n.right != null)
						q.add(n.right);
				}
			} else {
				int len = q.size();
				for (int i = 0; i < len; i++) {
					TreeNode n = q.poll();
					if (lvl == k)
						result.add(n.val);
					if (n.left != null)
						q.add(n.left);
					if (n.right != null)
						q.add(n.right);
				}
			}
			lvl++;
		}
	}

	public static void main(String[] args) {
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(3);
		TreeNode d = new TreeNode(4);
		TreeNode e = new TreeNode(5);
		a.left = b;
		a.right = c;
		b.left = d;
		d.left = e;

		System.out.println(distanceK(a, b, 1));
		System.out.println(distanceK(a, b, 2));
	}

}
