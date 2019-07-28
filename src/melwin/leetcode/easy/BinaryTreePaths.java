package melwin.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<String> binaryTreePaths(TreeNode root) {
		List<String> results = new ArrayList<>();
		traverseTree(root, "", results);
		return results;
	}

	private void traverseTree(TreeNode node, String path, List<String> results) {
		if (node == null)
			return;
		if (node.left == null && node.right == null) {
			path = path + ((path == "") ? "" : "->") + node.val;
			results.add(path);
		} else {
			path = path + ((path == "") ? "" : "->") + node.val;
			if (node.left != null)
				traverseTree(node.left, path, results);
			if (node.right != null)
				traverseTree(node.right, path, results);
		}
	}

	public static void main(String[] args) {
	}

}
