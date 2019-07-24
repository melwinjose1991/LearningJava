package melwin.leetcode.easy;

// Tree | DFS

public class LowestCommonAncestorOfDeepestLeaves {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	private TreeNode lca_node;

	public TreeNode lcaDeepestLeaves(TreeNode root) {
		lca_node = null;
		int max_depth = getMaxDepth(root);
		// System.out.println(max_depth);
		dfsTree(root, max_depth, 0);
		return lca_node;
	}

	private int getMaxDepth(TreeNode node) {
		if (node == null)
			return -1;
		if (node.left == null && node.right == null)
			return 0;
		int left_depth = getMaxDepth(node.left);
		int right_depth = getMaxDepth(node.right);
		return Math.max(left_depth, right_depth) + 1;
	}

	private int dfsTree(TreeNode node, int max_depth, int depth) {
		if (node == null)
			return -1;
		if (depth == max_depth) {
			lca_node = node;
			return 1;
		}
		int left = dfsTree(node.left, max_depth, depth + 1);
		int right = dfsTree(node.right, max_depth, depth + 1);
		if (left == 1 && right == 1) {
			lca_node = node;
		}
		return Math.max(left, right);
	}

	public static void main(String[] args) {
	}

}
