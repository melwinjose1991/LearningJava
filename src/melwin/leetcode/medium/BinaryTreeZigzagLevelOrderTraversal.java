package melwin.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Tree | BFS

public class BinaryTreeZigzagLevelOrderTraversal {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		if(root==null)
			return results;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		boolean left_to_right = true;
		while (!q.isEmpty()) {
			int len = q.size();
			List<Integer> local = new ArrayList<>();
			for (int i = 0; i < len; i++) {
				TreeNode node = q.poll();
				if (node.left != null) {
					q.add(node.left);
				}
				if (node.right != null) {
					q.add(node.right);
				}
				local.add(node.val);
			}
			if (!left_to_right)
				Collections.reverse(local);
			results.add(local);
			left_to_right = !left_to_right;
		}
		return results;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
