package melwin.leetcode.easy;

// Tree

public class ConvertBSTToGreaterTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode convertBST(TreeNode root) {
		convert(root, 0);
		return root;
	}

	private int convert(TreeNode node, int sum_p) {
		if (node == null)
			return 0;
		int sum_r = convert(node.right, sum_p);

		int old_val = node.val;
		node.val = node.val + sum_r + sum_p;

		int sum_l = convert(node.left, sum_p + sum_r + old_val);

		return sum_l + old_val + sum_r;
	}

	public static void main(String[] args) {
	}

}
