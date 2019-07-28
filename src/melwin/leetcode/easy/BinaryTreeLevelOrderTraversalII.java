package melwin.leetcode.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Graphs | BFS

public class BinaryTreeLevelOrderTraversalII {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		if (root == null)
			return results;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int len = queue.size();
			List<Integer> lvl_elements = new ArrayList<>();
			for (int i = 0; i < len; i++) {
				TreeNode node = queue.remove();
				lvl_elements.add(node.val);
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
			}
			results.add(lvl_elements);
		}
		Collections.reverse(results);
		return results;
	}

	public static void main(String[] args) {
	}

}
