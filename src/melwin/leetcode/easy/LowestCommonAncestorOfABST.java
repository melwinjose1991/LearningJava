package melwin.leetcode.easy;

// Tree | Post Order Traversal

public class LowestCommonAncestorOfABST {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	private TreeNode lca;

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		lca = null;
		postOrderTraversal(root, p.val, q.val);
		return lca;
	}

	private boolean postOrderTraversal(TreeNode node, int p, int q) {
		if (node == null)
			return false;
		boolean left_ok = postOrderTraversal(node.left, p, q);
		boolean right_ok = postOrderTraversal(node.right, p, q);
		if ((left_ok && right_ok) || ((left_ok || right_ok) && (node.val == p || node.val == q))) {
			lca = node;
		}
		return node.val == p || node.val == q || left_ok || right_ok;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
