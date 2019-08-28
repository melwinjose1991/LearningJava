package melwin.leetcode.easy;

// BST | Tree

public class ClosestBSTValue {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	private int closest_value;
	private double min_diff;

	public int closestValue(TreeNode root, double target) {
		min_diff = Integer.MAX_VALUE;
		traverse(root, target);
		return closest_value;
	}

	private void traverse(TreeNode node, double target) {
		if (node == null)
			return;

		double diff = Math.abs(target - node.val);
		if (diff < min_diff) {
			min_diff = diff;
			closest_value = node.val;
		}
		if (node.val <= target) {
			traverse(node.right, target);
		} else {
			traverse(node.left, target);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
