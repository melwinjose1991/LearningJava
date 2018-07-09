package melwin.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

// 366 - Find Leaves of Binary Tree - O(n) - get max distance to leaf

public class FindLeavesOfBinaryTree {

	public List<List<Integer>> findLeaves(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		helper(result, root);
		return result;
	}

	private int helper(List<List<Integer>> list, TreeNode root) {
		if (root == null)
			return -1;

		int left = helper(list, root.left);
		int right = helper(list, root.right);
		int curr = Math.max(left, right) + 1;

		if (list.size() <= curr) {
			list.add(new ArrayList<Integer>());
		}

		list.get(curr).add(root.val);

		return curr;
	}

	public static void main(String[] args) {
	}

}
