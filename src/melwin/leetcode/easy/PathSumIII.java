package melwin.leetcode.easy;

import java.util.HashMap;

// DFS | XXX

public class PathSumIII {

	private int count;
	private HashMap<Integer, Integer> sum_count;

	public int pathSum(TreeNode root, int sum) {
		count = 0;
		sum_count = new HashMap<>();
		traverse(root, 0, sum);
		return count;
	}

	private void traverse(TreeNode node, int prev_sum, int reqd_sum) {
		if (node == null)
			return;

		int cur_sum = prev_sum + node.val;
		if (cur_sum == reqd_sum)
			count++;
		count += sum_count.getOrDefault(cur_sum - reqd_sum, 0);

		sum_count.put(cur_sum, sum_count.getOrDefault(cur_sum, 0) + 1);
		traverse(node.left, cur_sum, reqd_sum);
		traverse(node.right, cur_sum, reqd_sum);
		sum_count.put(cur_sum, sum_count.getOrDefault(cur_sum, 0) - 1);
	}

	public static void main(String[] args) {

	}

}
