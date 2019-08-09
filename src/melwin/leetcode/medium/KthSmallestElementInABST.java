package melwin.leetcode.medium;

// Tree | Inorder Traversal

public class KthSmallestElementInABST {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	private int k_smallest, count;

	public int kthSmallest(TreeNode root, int k) {
		count = 0;
		k_smallest = root.val;
		inorderTraversal(root, k);
		return k_smallest;
	}

	private void inorderTraversal(TreeNode node, int k) {
		if (node == null)
			return;

		inorderTraversal(node.left, k);

		count++;
		if (count == k)
			k_smallest = node.val;

		inorderTraversal(node.right, k);

	}

	public static void main(String[] args) {
	}

}
