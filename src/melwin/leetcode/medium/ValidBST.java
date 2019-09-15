package melwin.leetcode.medium;

public class ValidBST {

	private TreeNode prev;
	private boolean valid;

	public boolean isValidBST(TreeNode root) {
		prev = null;
		valid = true;
		traverse(root);
		return valid;
	}

	private void traverse(TreeNode n) {
		if (n == null)
			return;
		traverse(n.left);
		if (prev != null && prev.val >= n.val) {
			valid = false;
		}
		prev = n;
		traverse(n.right);
	}

	public static void main(String[] args) {
	}

}
