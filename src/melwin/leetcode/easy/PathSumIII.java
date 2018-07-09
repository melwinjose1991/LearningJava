package melwin.leetcode.easy;

import java.util.HashMap;

import melwin.leetcode.medium.TreeNode;

// 437. Path Sum III - HashMap + DFS

public class PathSumIII {

	public int pathSum(TreeNode root, int sum) {
		HashMap<Integer, Integer> preSum = new HashMap<Integer, Integer>();
		preSum.put(0, 1);
		helper(root, 0, sum, preSum);
		return count;
	}

	int count = 0;

	public void helper(TreeNode root, int currSum, int target, HashMap<Integer, Integer> preSum) {
		if (root == null) {
			return;
		}

		currSum += root.val;

		if (preSum.containsKey(currSum - target)) {
			count += preSum.get(currSum - target);
		}

		if (!preSum.containsKey(currSum)) {
			preSum.put(currSum, 1);
		} else {
			preSum.put(currSum, preSum.get(currSum) + 1);
		}

		helper(root.left, currSum, target, preSum);
		helper(root.right, currSum, target, preSum);
		preSum.put(currSum, preSum.get(currSum) - 1);
	}

	public static void main(String[] args) {
	}

}
