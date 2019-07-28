package melwin.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

// Trees | DFS

public class PathSumII {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	private List<List<Integer>> results;

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		results = new ArrayList<List<Integer>>();
		traverseTree(root, new ArrayList<Integer>(), sum, 0);
		return results;
	}

	private void traverseTree(TreeNode node, List<Integer> path, int sum, int cur_sum) {
		if (node == null)
			return;
		path.add(node.val);
		cur_sum += node.val;
		if (node.left == null && node.right == null && cur_sum == sum) {
			results.add(new ArrayList<>(path));
		} else {
			if (node.left != null)
				traverseTree(node.left, path, sum, cur_sum);
			if (node.right != null)
				traverseTree(node.right, path, sum, cur_sum);
		}
		path.remove(path.size() - 1);
	}

	public static void main(String[] args) {
	}

}
