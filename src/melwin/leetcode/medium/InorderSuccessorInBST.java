package melwin.leetcode.medium;

// Tree | Inorder Traversal

public class InorderSuccessorInBST {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	private TreeNode successor, prev_node;

	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		successor = null;
		prev_node = null;
		inorder(root, p);
		return successor;

	}

	private void inorder(TreeNode node, TreeNode target) {
		if (node == null) {
			return;
		}

		inorder(node.left, target);

		if (prev_node!=null && prev_node.val == target.val)
			successor = node;
		prev_node = node;

		inorder(node.right, target);
	}

	public static void main(String[] args) {
	}

}
