package melwin.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

// Tree | BST | Inorder Traversal 

public class FindModeInBST {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	private int max_count, cur_count, prev_val;
	private List<Integer> modes;

	public int[] findMode(TreeNode root) {
		max_count = Integer.MIN_VALUE;
		cur_count = 0;
		prev_val = -1;
		modes = new ArrayList<>();

		traverseBST(root);

		int[] modes_int = new int[modes.size()];
		for (int i = 0; i < modes.size(); i++) {
			modes_int[i] = modes.get(i);
		}
		return modes_int;
	}

	private void traverseBST(TreeNode node) {
		if (node == null)
			return;

		traverseBST(node.left);

		if (prev_val == node.val) {
			cur_count++;
		} else {
			cur_count = 1;
		}

		if (cur_count > max_count) {
			max_count = cur_count;
			modes = new ArrayList<>();
			modes.add(node.val);
		} else if (cur_count == max_count) {
			modes.add(node.val);
		}

		prev_val = node.val;

		traverseBST(node.right);

	}

	public static void main(String[] args) {
	}

}
