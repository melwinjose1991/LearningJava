package melwin.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class LeafSimilarTrees {
	public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
		List<Integer> tree_1_leaves = new ArrayList<Integer>();
		List<Integer> tree_2_leaves = new ArrayList<Integer>();
		traverse(root1, tree_1_leaves);
		traverse(root2, tree_2_leaves);
		if (tree_1_leaves.equals(tree_2_leaves)) {
			return true;
		} else {
			return false;
		}
	}

	private static void traverse(TreeNode node, List<Integer> leaves) {
		if (node == null)
			return;
		if (node.left == null && node.right == null)
			leaves.add(node.val);
		else {
			traverse(node.left, leaves);
			traverse(node.right, leaves);
		}

	}

	public static void main(String[] args) {
	}

}
