package melwin.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Tree | Post Order Traversal | Hash Map

public class MostFrequentSubtreeSum {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	private static List<Integer> result;
	private static HashMap<Integer, Integer> sum_count;
	private static int max_count;

	public static int[] findFrequentTreeSum(TreeNode root) {
		result = new ArrayList<Integer>();
		sum_count = new HashMap<>();
		max_count = 0;

		postOrderTraversal(root);
		
		int[] result_int = new int[result.size()];
		for (int i = 0; i < result.size(); i++) {
			result_int[i] = result.get(i);
		}
		return result_int;
	}

	private static int postOrderTraversal(TreeNode node) {
		if (node == null) {
			return 0;
		} else {
			int left_sum = postOrderTraversal(node.left);
			int right_sum = postOrderTraversal(node.right);
			int sum = left_sum + node.val + right_sum;
			int new_count = sum_count.getOrDefault(sum, 0) + 1;
			sum_count.put(sum, new_count);
			if (new_count > max_count) {
				result = new ArrayList<>();
				result.add(sum);
				max_count = new_count;
			} else if (new_count == max_count) {
				result.add(sum);
			}
			return sum;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
