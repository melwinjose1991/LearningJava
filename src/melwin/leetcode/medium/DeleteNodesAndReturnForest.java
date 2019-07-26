package melwin.leetcode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

// Tree | Recursion | DFS | BFS | Traversal

public class DeleteNodesAndReturnForest {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	private static List<TreeNode> result;

	public static List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
		result = new ArrayList<>();
		Set<Integer> to_delete_list = new HashSet<>();
		for (int del : to_delete) {
			to_delete_list.add(del);
		}
		BFS(root, to_delete_list);
		for (TreeNode node : result) {
			negateValues(node);
		}
		return result;
	}

	private static void BFS(TreeNode root, Set<Integer> to_delete) {
		Queue<TreeNode> queue_1 = new LinkedList<>();
		Queue<TreeNode> queue_2 = new LinkedList<>();
		queue_1.add(root);
		queue_2.add(root);
		while (!queue_1.isEmpty()) {
			int current_length = queue_1.size();
			for (int i = 0; i < current_length; i++) {
				TreeNode curr_node = queue_1.remove();
				if (curr_node.left != null) {
					queue_1.add(curr_node.left);
					queue_2.add(curr_node.left);
				}
				if (curr_node.right != null) {
					queue_1.add(curr_node.right);
					queue_2.add(curr_node.right);
				}
			}
		}
		while (!queue_2.isEmpty()) {
			int current_length = queue_2.size();
			for (int i = 0; i < current_length; i++) {
				TreeNode curr_node = queue_2.remove();
				if (!to_delete.contains(curr_node.val) && curr_node.val > 0) {
					System.out.println(curr_node.val);
					DFS(curr_node, to_delete);
					result.add(curr_node);
				}
			}
		}
	}

	private static void DFS(TreeNode node, Set<Integer> to_delete) {
		if (node == null)
			return;
		if (!to_delete.contains(node.val)) {
			node.val *= -1;
			if (node.left != null) {
				if (to_delete.contains(node.left.val)) {
					node.left = null;
				} else {
					DFS(node.left, to_delete);
				}

			}
			if (node.right != null) {
				if (to_delete.contains(node.right.val)) {
					node.right = null;
				} else {
					DFS(node.right, to_delete);
				}

			}
		}
	}

	private static void negateValues(TreeNode node) {
		if (node == null)
			return;
		node.val *= -1;
		negateValues(node.left);
		negateValues(node.right);
	}

	public static void main(String[] args) {
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(3);
		TreeNode d = new TreeNode(4);
		a.left = b;
		a.right = c;
		c.right = d;

		int[] list = { 3 };
		delNodes(a, list);
	}

}
