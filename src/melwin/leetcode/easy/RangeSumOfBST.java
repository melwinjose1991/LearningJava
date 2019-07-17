package melwin.leetcode.easy;

// Tree | Inorder Traversal | Recursion

public class RangeSumOfBST {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static int rangeSumBST(TreeNode root, int L, int R) {
		int left_sum = 0;
		if (root.left != null && root.val >= L) {
			left_sum += rangeSumBST(root.left, L, R);
		}

		int right_sum = 0;
		if (root.right != null && root.val <= R) {
			right_sum += rangeSumBST(root.right, L, R);
		}

		return left_sum + ((root.val >= L && root.val <= R) ? root.val : 0) + right_sum;

	}

	public static void main(String[] args) {
	}

}
