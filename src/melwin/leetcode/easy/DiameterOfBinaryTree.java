package melwin.leetcode.easy;

import com.sun.corba.se.impl.orbutil.graph.Node;

public class DiameterOfBinaryTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	private int max_distance;

	public int diameterOfBinaryTree(TreeNode root) {
		max_distance = 0;
		traverseTree(root);
		return max_distance;
	}

	private int traverseTree(TreeNode node) {
		if (node == null)
			return -1;
		if (node.left == null && node.right == null)
			return 0;
		int max_left_dist = traverseTree(node.left);
		int max_right_dist = traverseTree(node.right);
		if (max_left_dist != -1 && max_right_dist != -1) {
			int dist_path_node = max_left_dist + 2 + max_right_dist;
			if (dist_path_node > max_distance) {
				max_distance = dist_path_node;
			}
		} else {
			int dist_path_node = Math.max(max_left_dist, max_right_dist) + 1;
			if (dist_path_node > max_distance) {
				max_distance = dist_path_node;
			}
		}
		return Math.max(max_left_dist, max_right_dist) + 1;
	}

	public static void main(String[] args) {
	}

}
