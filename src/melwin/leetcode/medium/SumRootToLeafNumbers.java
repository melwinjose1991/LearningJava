package melwin.leetcode.medium;

// 129 - Sum Root To Leaf Numbers

public class SumRootToLeafNumbers {

	public int sumNumbers(TreeNode root) {
		return sum(root, 0);
	}

	public int sum(TreeNode n, int s) {
		if (n == null)
			return 0;
		if (n.right == null && n.left == null)
			return s * 10 + n.val;
		return sum(n.left, s * 10 + n.val) + sum(n.right, s * 10 + n.val);
	}

	public static void main(String[] args) {
	}

}
