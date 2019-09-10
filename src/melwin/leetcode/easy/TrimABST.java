package melwin.leetcode.easy;

// Tree | Recursion

public class TrimABST {
	public TreeNode trimBST(TreeNode root, int L, int R) {
		return trim(root, L, R);
	}

	private TreeNode trim(TreeNode node, int L, int R) {
		if (node == null)
			return null;

		if (node.val >= L && node.val <= R) {
			TreeNode l = trim(node.left, L, R);
			TreeNode r = trim(node.right, L, R);
			node.left = l;
			node.right = r;
			return node;
		} else if (node.val < L) {
			return trim(node.right, L, R);
		} else {
			return trim(node.left, L, R);
		}
	}

	public static void main(String[] args) {
	}

}
