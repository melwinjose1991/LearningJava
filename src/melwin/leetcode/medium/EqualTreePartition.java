package melwin.leetcode.medium;

// Tree | Recursion

public class EqualTreePartition {

	private boolean possible;
	private int total_sum;

	public boolean checkEqualTree(TreeNode root) {
		possible = false;
		total_sum = getTotalSum(root);
		postOrder(root);
		return possible;
	}

	private int getTotalSum(TreeNode n) {
		if (n == null)
			return 0;

		int l = getTotalSum(n.left);
		int r = getTotalSum(n.right);
		return l + n.val + r;
	}

	private int postOrder(TreeNode n) {
		if (n == null)
			return Integer.MIN_VALUE;

		int l = postOrder(n.left);
		int r = postOrder(n.right);
		if ((l != Integer.MIN_VALUE && total_sum == 2 * l) || (r != Integer.MIN_VALUE && total_sum == 2 * r)) {
			possible = true;
		}
		return l + n.val + r;
	}

	public static void main(String[] args) {
	}

}
