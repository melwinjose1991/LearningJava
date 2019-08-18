package melwin.leetcode.medium;

// Tree | Post Order | Recursion - Multiple return values

public class LargestBSTSubtree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	private int max_n;

	public int largestBSTSubtree(TreeNode root) {
		if(root==null)
			return 0;
		max_n = 1;
		postOrder(root);
		return max_n;
	}

	private int[] postOrder(TreeNode node) {
		if (node == null)
			return new int[] { 1, 0, Integer.MAX_VALUE, Integer.MIN_VALUE };
		else {
			int[] l = postOrder(node.left);
			int[] r = postOrder(node.right);
			if (l[0] == 1 && r[0] == 1 && node.val > l[3] && node.val < r[2]) {
				max_n = Math.max(max_n, l[1] + 1 + r[1]);
				return new int[] { 1, l[1] + 1 + r[1], Math.min(node.val, l[2]), Math.max(node.val, r[3]) };
			} else {
				return new int[] { -1, 0, 0, 0 };
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
