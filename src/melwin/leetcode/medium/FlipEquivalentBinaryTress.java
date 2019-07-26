package melwin.leetcode.medium;

public class FlipEquivalentBinaryTress {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static boolean flipEquiv(TreeNode n1, TreeNode n2) {
		if (n1 == null && n2 == null)
			return true;
		if ((n1 == null && n2 != null) || (n1 != null && n2 == null)) {
			return false;
		} else if (n1.val == n2.val) {
			return (flipEquiv(n1.left, n2.left) && flipEquiv(n1.right, n2.right))
					|| (flipEquiv(n1.left, n2.right) && flipEquiv(n1.right, n2.left));
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
	}

}
