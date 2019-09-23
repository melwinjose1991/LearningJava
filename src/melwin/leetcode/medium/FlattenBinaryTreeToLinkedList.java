package melwin.leetcode.medium;

// Tree | Linked List | Recursion

public class FlattenBinaryTreeToLinkedList {
	public static void flatten(TreeNode root) {
		flatIt(root);
	}

	private static TreeNode[] flatIt(TreeNode n) {
		if (n == null) {
			return null;
		}
		if (n.left == null && n.right == null) {
			return new TreeNode[] { n, n };
		}

		TreeNode[] left_flat = flatIt(n.left);
		if (left_flat != null) {
			TreeNode n_right = n.right;
			n.left = null;
			n.right = left_flat[0];
			left_flat[1].right = n_right;
			TreeNode[] right_flat = flatIt(n_right);
			if (right_flat != null)
				return new TreeNode[] { n, right_flat[1] };
			else {
				return new TreeNode[] { n, left_flat[1] };
			}
		} else {
			TreeNode[] right = flatIt(n.right);
			return new TreeNode[] { n, right[1] };
		}
	}

	private static void traverse(TreeNode n) {
		if (n == null)
			return;
		traverse(n.left);
		System.out.print(n.val + " ");
		traverse(n.right);
	}

	public static void main(String[] args) {
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(3);
		TreeNode d = new TreeNode(4);

		a.left = b;
		b.right = c;
		a.right = d;

		traverse(a);
		flatIt(a);
		traverse(a);
	}

}
