package melwin.leetcode.easy;

// Tree | BST | Recursion

public class BSTtoGST {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode bstToGst(TreeNode root) {
		traverse(root, 0);
		return root;
	}

	public int traverse(TreeNode node, int greater_sum) {
		if (node == null)
			return 0;
		int right_sum = traverse(node.right, greater_sum);
		int tmp = node.val;
		node.val = node.val + right_sum + greater_sum;
		int left_sum = traverse(node.left, node.val);
		return left_sum + tmp + right_sum;
	}

	public static void main(String[] args) {
	}

}
