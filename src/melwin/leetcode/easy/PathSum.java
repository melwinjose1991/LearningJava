package melwin.leetcode.easy;

public class PathSum {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean hasPathSum(TreeNode root, int sum) {
		return traverseTree(root, 0, sum);
	}

	public boolean traverseTree(TreeNode node, int curr_sum, int reqd_sum) {
		if (node == null)
			return false;
		if (node.left == null && node.right == null) {
			if (curr_sum + node.val == reqd_sum)
				return true;
			else
				return false;
		}
		boolean left_path = traverseTree(node.left, curr_sum + node.val, reqd_sum);
		boolean right_path = traverseTree(node.right, curr_sum + node.val, reqd_sum);
		return left_path | right_path;

	}

	public static void main(String[] args) {
	}

}
