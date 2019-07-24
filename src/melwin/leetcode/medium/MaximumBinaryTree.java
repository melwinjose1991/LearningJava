package melwin.leetcode.medium;

// Tree | Recursion

public class MaximumBinaryTree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static TreeNode constructMaximumBinaryTree(int[] nums) {
		return traverseArray(0, nums.length - 1, nums);
	}

	public static TreeNode traverseArray(int i, int j, int[] nums) {
		if (i == j) {
			TreeNode node = new TreeNode(nums[i]);
			return node;
		}
		int max_index = 0, max_num = Integer.MIN_VALUE, k;
		for (k = i; k <= j; k++) {
			if (nums[k] > max_num) {
				max_num = nums[k];
				max_index = k;
			}
		}
		TreeNode node = new TreeNode(max_num);
		node.left = (max_index - 1 >= i) ? traverseArray(i, max_index - 1, nums) : null;
		node.right = (max_index + 1 <= j) ? traverseArray(max_index + 1, j, nums) : null;
		return node;
	}

	public static void main(String[] args) {
		int[] A = { 3, 2, 1, 6, 0, 5 };
		System.out.println(constructMaximumBinaryTree(A));
	}

}
