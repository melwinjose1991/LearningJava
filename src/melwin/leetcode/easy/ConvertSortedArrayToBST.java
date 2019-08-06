package melwin.leetcode.easy;

// Tree | BST

public class ConvertSortedArrayToBST {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static TreeNode sortedArrayToBST(int[] nums) {
		return createTree(nums, 0, nums.length);
	}

	private static TreeNode createTree(int[] nums, int i, int j) {
		if (i <= j) {
			int mid = (i + j) / 2;
			TreeNode node = new TreeNode(nums[mid]);
			node.left = createTree(nums, i, mid - 1);
			node.right = createTree(nums, mid + 1, j);
			return node;
		} else {
			return null;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
