package melwin.leetcode.easy;

// Tree | Recursion

public class InvertBinaryTree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static TreeNode invertTree(TreeNode node) {
		if (node == null)
			return null;
		TreeNode tmp = node.left;
		node.left = node.right;
		node.right = tmp;
		invertTree(node.left);
		invertTree(node.right);
		return node;
	}

	public static void main(String[] args) {
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(3);
		TreeNode d = new TreeNode(4);
		a.left = b;
		a.right = c;
		c.right = d;

		invertTree(a);
	}

}
