package melwin.leetcode.easy;

// Tree | Recursion

public class BinaryTreeTilt {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	private int tilt_sum;

	public int findTilt(TreeNode root) {
		tilt_sum = 0;
		traverse(root);
		return tilt_sum;
	}

	private int traverse(TreeNode node) {
		if (node == null) {
			return 0;
		}
		int left_sum = traverse(node.left);
		int right_sum = traverse(node.right);
		int tilt = Math.abs(left_sum - right_sum);
		tilt_sum += tilt;
		return left_sum + node.val + right_sum;
	}

	public static void main(String[] args) {
	}

}
