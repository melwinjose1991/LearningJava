package melwin.leetcode.medium;

import melwin.leetcode.medium.TreeNode;

// Tree | Recursion

public class ClosestLeafInABinaryTree {

	private static int global_min, global_leaf;

	public static int findClosestLeaf(TreeNode root, int k) {
		global_min = Integer.MAX_VALUE;
		global_leaf = k;
		traverse(root, k);
		return global_leaf;
	}

	private static int[] traverse(TreeNode node, int k) {
		if (node == null)
			return new int[] { -1, 0, 0 };
		if (node.left == null && node.right == null) {
			if (node.val == k) {
				global_min = 0;
				global_leaf = node.val;
				return new int[] { 1, 1, 0 };
			} else
				return new int[] { 0, 1, node.val };
		}
		int[] l = traverse(node.left, k);
		int[] r = traverse(node.right, k);
		if (node.val == k) {
			int local_min = Integer.MAX_VALUE, local_leaf = 0;
			if (l[0] == 0) {
				local_min = l[1];
				local_leaf = l[2];
			}
			if (r[0] == 0 && r[1] < local_min) {
				local_min = r[1];
				local_leaf = r[2];
			}
			if (local_min < global_min) {
				global_min = local_min;
				global_leaf = local_leaf;
			}
			return new int[] { 1, 1, 0 };
		} else if (l[0] == 1 || r[0] == 1) {
			if (l[0] == 1) {
				if (r[0] == 0) {
					if (l[1] + r[1] < global_min) {
						global_min = l[1] + r[1];
						global_leaf = r[2];
					}
					return new int[] { 1, r[1] + 1, r[2] };
				} else {
					return new int[] { 1, l[1] + 1, 0 };
				}
			} else {
				if (l[0] == 0) {
					if (l[1] + r[1] < global_min) {
						global_min = l[1] + r[1];
						global_leaf = l[2];
					}
					return new int[] { 1, l[1] + 1, l[2] };
				} else {
					return new int[] { 1, r[1] + 1, 0 };
				}
			}
		} else {
			int local_min = Integer.MAX_VALUE, local_leaf = 0;
			if (l[0] == 0) {
				local_min = l[1];
				local_leaf = l[2];
			}
			if (r[0] == 0 && r[1] < local_min) {
				local_min = r[1];
				local_leaf = r[2];
			}
			return new int[] { 0, local_min + 1, local_leaf };
		}
	}

	public static void main(String[] args) {
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(3);
		TreeNode d = new TreeNode(4);
		TreeNode e = new TreeNode(5);
		TreeNode f = new TreeNode(6);
		a.left = b;
		a.right = c;
		b.left = d;
		d.left = e;
		e.left = f;

		System.out.println(findClosestLeaf(a, 2));
	}

}
