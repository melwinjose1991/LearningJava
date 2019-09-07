package melwin.leetcode.easy;

// Tree | Recursion

public class UnivaluedBinaryTree {

	public boolean isUnivalTree(TreeNode root) {
		if (root == null)
			return true;

		boolean left = isUnivalTree(root.left);
		boolean right = isUnivalTree(root.right);

		if (left && right) {
			if ((root.left == null || root.left.val == root.val)
					&& (root.right == null || root.right.val == root.val)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
	}

}
