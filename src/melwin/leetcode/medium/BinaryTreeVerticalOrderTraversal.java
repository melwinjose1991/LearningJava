package melwin.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

// 314 - Binary Tree Vertical Order Traversal

public class BinaryTreeVerticalOrderTraversal {

	private static class TreeColumnNode {
		public TreeNode treeNode;
		int col;

		public TreeColumnNode(TreeNode node, int col) {
			this.treeNode = node;
			this.col = col;
		}
	}

	public List<List<Integer>> verticalOrder(TreeNode root) {

		List<List<Integer>> res = new ArrayList<>();
		if (root == null) {
			return res;
		}

		Queue<TreeColumnNode> queue = new LinkedList<>();
		Map<Integer, List<Integer>> map = new HashMap<>();
		queue.offer(new TreeColumnNode(root, 0));
		int min = 0;
		int max = 0;

		while (!queue.isEmpty()) {
			
			int curr_lvl_nodes = queue.size();
			for (int i = 1; i <= curr_lvl_nodes; i++) {
				TreeColumnNode node = queue.poll();
				if (map.containsKey(node.col)) {
					map.get(node.col).add(node.treeNode.val);
				} else {
					map.put(node.col, new ArrayList<Integer>(Arrays.asList(node.treeNode.val)));
				}

				if (node.treeNode.left != null) {
					queue.offer(new TreeColumnNode(node.treeNode.left, node.col - 1));
					min = Math.min(node.col - 1, min);
				}
				if (node.treeNode.right != null) {
					queue.offer(new TreeColumnNode(node.treeNode.right, node.col + 1));
					max = Math.max(node.col + 1, max);
				}
			}
			
		}

		for (int i = min; i <= max; i++) {
			res.add(map.get(i));
		}

		return res;
	}

	public static void main(String[] args) {
	}

}
