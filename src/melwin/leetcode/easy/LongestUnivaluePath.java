package melwin.leetcode.easy;

// Tree | Recursion

public class LongestUnivaluePath {

	private int max_len;

	public int longestUnivaluePath(TreeNode root) {
		max_len = 0;
		traverse(root);
		return max_len;
	}

	private int[] traverse(TreeNode node) {
		if (node == null)
			return null;

		int[] l = traverse(node.left);
		int[] r = traverse(node.right);
		int path_1 = (l != null && l[0] == node.val) ? l[1] + 1 : 0;
		int path_2 = (r != null && r[0] == node.val) ? r[1] + 1 : 0;
		int path_3 = (l != null && r != null && l[0] == r[0] && r[0] == node.val) ? l[1] + r[1] + 2 : 0;
		max_len = Math.max(max_len, Math.max(path_1, Math.max(path_2, path_3)));
		return new int[] { node.val, Math.max(path_1, path_2) };
	}

	public static void main(String[] args) {
	}

}
