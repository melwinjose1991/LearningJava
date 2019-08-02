package melwin.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

// Arrays | Permutation Combination

public class Subsets {
	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		getSubsets(nums, 0, results, new ArrayList<>());
		return results;
	}

	private static void getSubsets(int[] nums, int i, List<List<Integer>> results, List<Integer> list) {
		if (i == nums.length) {
			System.out.println(list.toString());
			results.add(new ArrayList<Integer>(list));
			return;
		} else {
			list.add(nums[i]);
			getSubsets(nums, i + 1, results, list);
			list.remove(list.size() - 1);

			getSubsets(nums, i + 1, results, list);
		}
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3 };
		subsets(nums);
	}

}
