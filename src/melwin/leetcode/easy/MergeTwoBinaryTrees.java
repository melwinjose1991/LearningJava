package melwin.leetcode.easy;

public class MergeTwoBinaryTrees {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		if (t1 == null && t2 == null) {
			return null;
		}
		if (t1 == null) {
			return t2;
		}
		if (t2 == null) {
			return t1;
		}
		int t1_val = (t1 != null) ? t1.val : 0;
		int t2_val = (t2 != null) ? t2.val : 0;
		TreeNode new_node = new TreeNode(t1_val + t2_val);
		new_node.left = mergeTrees((t1 != null) ? t1.left : null, (t2 != null) ? t2.left : null);
		new_node.right = mergeTrees((t1 != null) ? t1.right : null, (t2 != null) ? t2.right : null);
		return new_node;
	}

	public static void main(String[] args) {
	}

}
