package melwin.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

// Tree | Post Order Traversal

public class FindLeavesOfBinaryTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<List<Integer>> findLeaves(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		height(root, res);
		return res;
	}

	private int height(TreeNode node, List<List<Integer>> res) {
		if (null == node)
			return -1;
		int level = 1 + Math.max(height(node.left, res), height(node.right, res));
		if (res.size() < level + 1)
			res.add(new ArrayList<>());
		res.get(level).add(node.val);
		return level;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
